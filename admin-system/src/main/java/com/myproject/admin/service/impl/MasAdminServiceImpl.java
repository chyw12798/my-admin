package com.myproject.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.myproject.admin.api.CommonResult;
import com.myproject.admin.dao.MasAdminDao;
import com.myproject.admin.dao.MasAdminPermissionRelationDao;
import com.myproject.admin.component.AdminDetails;
import com.myproject.admin.dao.MasRoleDao;
import com.myproject.admin.dto.*;
import com.myproject.admin.mapper.*;
import com.myproject.admin.model.*;
import com.myproject.admin.securityUtils.JwtTokenUtil;
import com.myproject.admin.service.MasAdminService;
import com.myproject.admin.service.MasPermissionService;
import com.myproject.admin.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MasAdminServiceImpl implements MasAdminService {

    // 直接调用commom项目下的类, 需要将对应的包导入进来(MybatisConfig.java)
    @Autowired
    private MasAdminMapper adminMapper;
    @Autowired
    private MasAdminDao adminDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private MasAdminRoleRelationMapper adminRoleRelationMapper;
    @Autowired
    private MasRolePermissionRelationMapper rolePermissionRelationMapper;
    @Autowired
    private MasAdminPermissionRelationMapper adminPermissionRelationMapper;
    @Autowired
    private MasAdminPermissionRelationDao adminPermissionRelationDao;
    @Autowired
    private MasRoleMapper roleMapper;
    @Autowired
    private MasPermissionMapper permissionMapper;
    @Autowired
    private MasPermissionService permissionService;
    @Autowired
    private MasRoleDao roleDao;
    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.verificationCode}")
    private String VERIFICATION_CODE_PRFIX;
    @Value("${redis.key.expire.verificationCode}")
    private Long VERIFICATION_CODE_EXPIRE;


    public AdminDetails loadDetailByName(String adminName){
        MasAdminExample adminExample = new MasAdminExample();
        adminExample.createCriteria().andUserNameEqualTo(adminName);
        List<MasAdmin> admins = adminMapper.selectByExample(adminExample);
        if (CollectionUtils.isEmpty(admins)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        MasAdmin nowAdmin = admins.get(0);

        MasRole adminRole = roleDao.getAdminRole(nowAdmin.getId());
//        if (adminRole == null) {
//            throw new RuntimeException("请联系管理员为你设定相应角色！");
//        }

        List<MasPermission> permissions = adminDao.getAdminPermissionList(nowAdmin.getId());
        if (CollectionUtils.isEmpty(permissions)) {
            throw new RuntimeException("您暂无任何权限!");
        }
        return new AdminDetails(nowAdmin,adminRole,permissions);
    }

    // 登录返回token
    @Override
    public String login(MasAdminParam adminParam) {

        // 首先要拿到用户的userDetails(这里是他的子类 adminDetails)
        UserDetails adminDetails = loadDetailByName(adminParam.getUserName());

        // 这个时候adminDetails=MasAdmin + List<MasPermission> + role;
        // 与传来的密码比对
        if (!passwordEncoder.matches(adminParam.getPassword(),adminDetails.getPassword())) {
            throw new BadCredentialsException("密码不正确！");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(adminDetails, adminParam.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(adminDetails);
        return token;

    }

    @Override
    public CommonResult register(String userName, String password) {
        MasAdminExample example = new MasAdminExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<MasAdmin> admins = adminMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(admins)) {
//            return CommonResult.failed("该账号已被注册!");
            return CommonResult.failed("账号已被注册！");
        }
        String encodPasswrd = passwordEncoder.encode(password);
        MasAdmin rAdmin = new MasAdmin();
        rAdmin.setUserName(userName);
        rAdmin.setPassword(encodPasswrd);
        rAdmin.setRegisterDate(new Date());
        rAdmin.setStatus(1);
        int count = adminMapper.insert(rAdmin);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("注册失败!");
    }

    @Override
    public List<MasAdmin> list(String userName, Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        if (StringUtils.isEmpty(userName)){
            return adminMapper.selectByExample(new MasAdminExample());
        }
        MasAdminExample example = new MasAdminExample();
        example.createCriteria().andUserNameLike("%"+userName+"%");
        return adminMapper.selectByExample(example);
    }

    @Override
    public CommonResult updatePassword(UpdatePasswordParam updatePasswordParam){
        if (StringUtils.isEmpty(updatePasswordParam.getNewPassword()) ||
                StringUtils.isEmpty(updatePasswordParam.getOldPassword()) ||
                        StringUtils.isEmpty(updatePasswordParam.getUserName())) {
            return CommonResult.failed("提交参数不合法");
        }
        MasAdminExample adminExample = new MasAdminExample();
        adminExample.createCriteria().andUserNameEqualTo(updatePasswordParam.getUserName());
        List<MasAdmin> admins = adminMapper.selectByExample(adminExample);
        if (CollectionUtils.isEmpty(admins)) {
            return CommonResult.failed("账户不存在!");
        }
        MasAdmin admin = admins.get(0);
        if (!admin.getPassword().equals(updatePasswordParam.getOldPassword())) {
            return CommonResult.failed("旧密码不正确!");
        }
        admin.setPassword(updatePasswordParam.getNewPassword());
        adminMapper.updateByPrimaryKey(admin);
        return CommonResult.success("修改密码成功");


    }

    @Override
    public List<MasPermission> permissionList(Long id) {
        return adminDao.getAdminPermissionList(id);
    }

    @Override
    public CommonResult permissionUpdate(UpdateAdminPermissionParam updateAdminPermissionParam) {
        Long adminId = updateAdminPermissionParam.getAdminId();
        List<Long> permissionIdList = updateAdminPermissionParam.getPermissionIds();
        // 查看用户对应的角色权限，判断permissionList是否有越权
        String checkString = checkAdminPermission(adminId,permissionIdList);
        if (checkString != "1") {
            return CommonResult.failed(checkString);
        }
        MasAdminPermissionRelationExample adminPermissionRelationExample = new MasAdminPermissionRelationExample();
        adminPermissionRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        List<MasAdminPermissionRelation> adminPermissionRelations = adminPermissionRelationMapper.selectByExample(adminPermissionRelationExample);
        if (CollectionUtils.isEmpty(adminPermissionRelations)){
            // 直接insert
            adminPermissionRelationDao.insertList(adminId, permissionIdList);
        }
        List<Long> oldPermissions = adminPermissionRelations.stream().map(MasAdminPermissionRelation::getPermissionId).collect(Collectors.toList());
        List<Long> addPermissionIdList = permissionIdList.stream().filter(permissionId -> !oldPermissions.contains(permissionId)).collect(Collectors.toList());
        List<Long> deletePermissionIdList = oldPermissions.stream().filter(permissionId -> !permissionIdList.contains(permissionId)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(addPermissionIdList)) {
            adminPermissionRelationDao.insertList(adminId, addPermissionIdList);
        }
        if (!CollectionUtils.isEmpty(deletePermissionIdList)) {
            MasAdminPermissionRelationExample deleteAdminPermissionsExample = new MasAdminPermissionRelationExample();
            deleteAdminPermissionsExample.createCriteria().andAdminIdEqualTo(adminId).andPermissionIdIn(deletePermissionIdList);
            adminPermissionRelationMapper.deleteByExample(deleteAdminPermissionsExample);
        }
        return CommonResult.success(1);
    }

    @Override
    public CommonResult veificationCodelogin(VerificationCodeLoginParam verificationCodeLoginParam) {
        //
        String phone = verificationCodeLoginParam.getPhone();
        String code = verificationCodeLoginParam.getVerificationCode();
        if (StringUtils.isEmpty(redisService.get(VERIFICATION_CODE_PRFIX+phone))
                || !redisService.get(VERIFICATION_CODE_PRFIX+phone).equals(code)){
            return CommonResult.failed("验证码不正确");
        }
        MasAdminExample masAdminExample = new MasAdminExample();
        masAdminExample.createCriteria().andPhoneEqualTo(verificationCodeLoginParam.getPhone());
        MasAdmin masAdmin = adminMapper.selectByExample(masAdminExample).get(0);
        AdminDetails adminDetails = loadDetailByName(masAdmin.getUserName());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(adminDetails, adminDetails.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        String token = jwtTokenUtil.generateToken(adminDetails);
        Map<String ,String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("header", "hearder");
        redisService.remove(VERIFICATION_CODE_PRFIX+phone);
        return CommonResult.success(tokenMap);
    }

    @Override
    public CommonResult getVerificationCode(String phone) {
        MasAdminExample masAdminExample = new MasAdminExample();
        masAdminExample.createCriteria().andPhoneEqualTo(phone);
        List<MasAdmin> admins = adminMapper.selectByExample(masAdminExample);
        if (CollectionUtils.isEmpty(admins)){
            return CommonResult.failed("您的手机号暂未注册!");
        }
        // 根据当前时间生成六位数
        StringBuilder code = new StringBuilder(6);
        for (int i = 0;i<6; i++) {
            code.append(new Random().nextInt(10));
        }
        redisService.set(VERIFICATION_CODE_PRFIX+phone, code.toString());
        redisService.setExpire(VERIFICATION_CODE_PRFIX+phone, VERIFICATION_CODE_EXPIRE);
        return CommonResult.success(code.toString());
    }

    public String checkAdminPermission(Long adminId,List<Long> permissionIdList){
        MasAdminRoleRelationExample adminRoleRelationExample = new MasAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        List<MasAdminRoleRelation> adminRoleRelations = adminRoleRelationMapper.selectByExample(adminRoleRelationExample);
        if (CollectionUtils.isEmpty(adminRoleRelations)){
            return "未查询到用户的角色!";
        }
        Long roleId = adminRoleRelations.get(0).getRoleId();
        MasRolePermissionRelationExample rolePermissionRelationExample = new MasRolePermissionRelationExample();
        rolePermissionRelationExample.createCriteria().andRoleIdEqualTo(roleId);
        List<MasRolePermissionRelation> rolePermissionRelationList = rolePermissionRelationMapper.selectByExample(rolePermissionRelationExample);
        if (CollectionUtils.isEmpty(rolePermissionRelationList)){
            return "请先为该用户所属角色增加相应权限！";
        }
        List<Long> rolePermissionIds = rolePermissionRelationList.stream().map(MasRolePermissionRelation::getPermissionId).collect(Collectors.toList());
        if (!rolePermissionIds.containsAll(permissionIdList)){
            return "用户超出所属角色权限！";
        }
        return "1";
    }

    @Override
    public CommonResult roleUpdate(UpdateAdminRoleParam updateAdminRoleParam){
        // 删除原有角色和权限，新增传来的角色和权限
        Long adminId = updateAdminRoleParam.getMasAdminId();
        MasAdminRoleRelationExample adminRoleRelationExample = new MasAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        MasAdminPermissionRelationExample adminPermissionRelationExample = new MasAdminPermissionRelationExample();
        adminPermissionRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminPermissionRelationMapper.deleteByExample(adminPermissionRelationExample);

        List<Long> permissions = updateAdminRoleParam.getMasPermissions();
        adminPermissionRelationDao.insertList(adminId,permissions);
        MasAdminRoleRelation adminRoleRelation = new MasAdminRoleRelation();
        adminRoleRelation.setAdminId(adminId);
        adminRoleRelation.setRoleId(updateAdminRoleParam.getMasRoleId());
        adminRoleRelationMapper.insert(adminRoleRelation);
        return CommonResult.success(1);
    }
}

