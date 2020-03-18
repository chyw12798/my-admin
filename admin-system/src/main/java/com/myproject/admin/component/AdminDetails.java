package com.myproject.admin.component;

import com.myproject.admin.model.MasAdmin;
import com.myproject.admin.model.MasPermission;
import com.myproject.admin.model.MasRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * UserDetails:
 *   Provides core user information.
 *   提供用户信息
 *   Implementations are not used directly by Spring Security for security purposes.
 *   处于安全考虑,springSecurity不会直接使用UserDetails。
 *   They simply store user information which is later encapsulated into { Authentication} objects.
 *   UserDetails只是存储用户信息，这些用户信息后面会被封装到Authentication(认证方式)对象中,
 *   This allows non-security related user information (such as email addresses,telephone numbers etc) to be stored in a convenient location.
 *   这样就可以将与安全无关的用户信息(邮箱地址,手机号码等)存储在方便的位置
 *   Concrete implementations must take particular care to ensure the non-null contract detailed for each method is enforced.
 *   具体实现必须要十分小心,要确保每个被强制执行方法中详细的不为null合同
 *   See {@link org.springframework.security.core.userdetails.User} for a reference implementation (which you might like to extend or use in your code).
 *   参考这个User类的实现，代码要和这个类一样

 */
public class AdminDetails implements UserDetails {

    private List<MasPermission> masPermissionList;
    // 一个管理者账户只能对应一个角色
    private MasRole masRole;
    private MasAdmin masAdmin;
    public AdminDetails(MasAdmin masAdmin,MasRole masRole,List<MasPermission> masPermissionList){
        this.masRole = masRole;
        this.masPermissionList = masPermissionList;
        this.masAdmin = masAdmin;
    }

    // 这个方法就是返回权限列表(authority权威)
    /**
     * Returns the authorities granted to the user. Cannot return <code>null</code>.
     * 	返回给用户授予的权限，不能返回null
     * @return the authorities, sorted by natural key (never <code>null</code>)
     *
     * 注意这里的返回值是Collection<? extends GrantedAuthority>
     * 首先GrantedAuthority是一个interface, 返回的SimpleGrantedAuthority集合是GrantedAuthority的实现类
     * 并非继承类, 这里的extends应该是对接口和父类都使用(个人猜测)
     * 其次, 这里用Collection来表示返回的集合, 不用ArrayList, 目的应该是为了易于扩展
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // 仅仅是获取permission的value
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (MasPermission permission: masPermissionList) {
            if (permission.getValue() != null ) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission.getValue());
                authorityList.add(authority);
            }
        }
        return authorityList;
        /**
         * java1.8:
         *      return permissionList.stream()
         *                 .filter(permission -> permission.getValue()!=null)
         *                 .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
         *                 .collect(Collectors.toList());
         */
    }

    public List<MasPermission> getMasPermissionList() {
        return this.masPermissionList;
    }

    public MasAdmin getMasAdmin(){
        return this.masAdmin;
    }

    public MasRole getMasRole() {
        return this.masRole;
    }

    @Override
    public String getPassword() {
        return this.masAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return this.masAdmin.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return masAdmin.getStatus().equals(1);
    }
}
