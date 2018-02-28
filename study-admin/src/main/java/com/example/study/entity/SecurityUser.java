package com.example.study.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: hzCloud_SEM_YUN
 * @ClassName: com.example.study.entity
 * @Description:
 * @author: <a htef="mailto:zhanglw@daqsoft.com">zhanglw@daqsoft.com</a>
 * @Create: 2018/2/28 0028 下午 4:01
 * @Version: V3.6.0
 * @Copyright: <a htef="http://www.daqsoft.com">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 **/
public class SecurityUser extends SysUser implements UserDetails {

    public SecurityUser(SysUser sysUser){
        if(sysUser != null)
        {
            this.setId(sysUser.getId());
            this.setUsername(sysUser.getUsername());
            this.setPassword(sysUser.getPassword());
            this.setRoles(sysUser.getRoles());
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysRole> roles = getRoles();
        roles.forEach(role -> {
            GrantedAuthority g = new SimpleGrantedAuthority(role.getCode());
            authorities.add(g);
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
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
        return true;
    }
}
