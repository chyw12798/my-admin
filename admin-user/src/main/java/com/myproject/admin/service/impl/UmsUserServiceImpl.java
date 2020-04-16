package com.myproject.admin.service.impl;

import com.myproject.admin.api.CommonResult;
import com.myproject.admin.component.UmsUserDetails;
import com.myproject.admin.dto.UmsUserLoginParam;
import com.myproject.admin.dto.UpdatePasswordParam;
import com.myproject.admin.mapper.UmsUserMapper;
import com.myproject.admin.model.UmsUser;
import com.myproject.admin.model.UmsUserExample;
import com.myproject.admin.securityUtils.JwtTokenUtil;
import com.myproject.admin.service.UmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName UmsUserServiceImpl
 * @Description TODO
 * @Author chyw1
 * @Date 2020/3/30 10:58
 * @Version 1.0
 */
@Service
public class UmsUserServiceImpl implements UmsUserService {

    @Autowired
    private UmsUserMapper umsUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public UmsUser getCurrentMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UmsUserDetails umsUserDetails = (UmsUserDetails) authentication.getPrincipal();
        return umsUserDetails.getUmsUser();
    }

    @Override
    public List<UmsUser> getUserByName(String userName){
        // 返回的userDetails最好做上非空判断,当然逻辑上也是需要对用户进行判断
        UmsUserExample umsUserExample = new UmsUserExample();
        umsUserExample.createCriteria().andUserNameEqualTo(userName);
        // 最好不要umsUserMapper.selectByExample(umsUserExample).get(0)
        // 因为select出来的可能是null,再.get(0)就会报NPE.
        List<UmsUser> umsUserList = umsUserMapper.selectByExample(umsUserExample);
        // 可能为null,需要做判断
        return umsUserList;
    }

    // 通过账号得到用户信息UmsUserDetails
    @Override
    public UmsUserDetails loadUserByUserName(String userName){

        List<UmsUser> umsUserList = getUserByName(userName);
        if (CollectionUtils.isEmpty(umsUserList)) {
            // 如果select返回的是null,就表示用户并未注册过，此处应该return null呢？还是throw Exception呢？
            throw new UsernameNotFoundException("用户名或密码错误!");
        }
        // 经过上面的判断,得到的umsUser肯定不是null且size()>0了,就可以放心.get(0)了
        UmsUser umsUser = umsUserList.get(0);
        // 构造器注入,对于类里面属性比较少的情况很合适。
        UmsUserDetails umsUserDetails = new UmsUserDetails(umsUser);
        return umsUserDetails;
    }


    @Override
    public String login(UmsUserLoginParam userLoginParam) {

        // UmsUserLoginParam类里已进行相应非空判断
        // springsecurity通过admin-comm包导入进来,先进行userDetails内容的编写

        // 已经将UmsUserDetails内容完成,进行注入
        String userName = userLoginParam.getUserName();
        String password = userLoginParam.getPassword();
        // loadUserByUserName接口给出了注释，可能会报UsernameNotFoundException异常
        UmsUserDetails umsUserDetails = loadUserByUserName(userName);

        // 进行密码比对
        if (!passwordEncoder.matches(userLoginParam.getPassword(),umsUserDetails.getPassword())){
            //Credential 证书的意思,容易想到对应password
            throw new BadCredentialsException("密码错误！");
        }

        // UserDetails的docs文档就已说明，UserDetails的内容会封装成一个Authentication
        // UsernamePasswordAuthenticationToken的构造方法的两个参数：(principal,credentials);
        // principal代表主体(容易想出对应的UserDetails),credentials代表证书(容易想到对应的password)
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(umsUserDetails,password);
        // 通过ContextHolder获取Context,然后进行setAuthorization();
        // SecurityContextHolder要做的事(static方法的内容),都是交给SecurityContextHolderStrategy去完成(委托delegate),
        // 这里的strategy是ThreadLocalSecurityContextHolderStrategy
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 通过jwt生成token
        String token = jwtTokenUtil.generateToken(umsUserDetails);

        return token;
    }

    @Override
    public CommonResult register(UmsUser umsUser) {

        String userName = umsUser.getUserName();
        // loadUserByUserName会有异常抛出,需要将获取UmsUser内容抽出来
        List<UmsUser> umsUsers = getUserByName(userName);
        if (!CollectionUtils.isEmpty(umsUsers)) {
            return CommonResult.failed("用户名已被注册");
        }

        if (umsUser.getCommandId() != null && umsUser.getCommandId() != 0) {
            // 推荐注册获得20积分
            UmsUser commandmanuser = umsUserMapper.selectByPrimaryKey(umsUser.getCommandId());
            if (commandmanuser != null) {
                UmsUser newUser = new UmsUser();
                newUser.setId(commandmanuser.getId());
                newUser.setIntegrals( commandmanuser.getIntegrals() + 20);
                umsUserMapper.updateByPrimaryKeySelective(newUser);
            }
        }

        umsUser.setStatus(1);
        umsUser.setRegisterTime(new Date());
        umsUser.setIntegrals(0);
        umsUser.setPassword(passwordEncoder.encode(umsUser.getPassword()));
        int count = umsUserMapper.insert(umsUser);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("注册失败");
    }

    @Override
    public CommonResult updatePassword(UpdatePasswordParam updatePasswordParam) {

        UmsUserExample example = new UmsUserExample();
        example.createCriteria().andPhoneEqualTo(updatePasswordParam.getPhone());
        List<UmsUser> umsUserList = umsUserMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(umsUserList)) {
            return CommonResult.failed("用户名不存在！");
        }
        UmsUser umsUser = umsUserList.get(0);
        UmsUser newUser = new UmsUser();
        newUser.setId(umsUser.getId());
        newUser.setPassword(passwordEncoder.encode(updatePasswordParam.getNewPassword()));
        int count = umsUserMapper.updateByPrimaryKeySelective(newUser);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed("修改失败！");
    }
}
