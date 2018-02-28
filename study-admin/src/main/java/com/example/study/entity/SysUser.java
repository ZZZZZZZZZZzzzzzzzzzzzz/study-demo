package com.example.study.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * @ProjectName: hzCloud_SEM_YUN
 * @ClassName: com.example.study.entity
 * @Description:
 * @author: <a htef="mailto:zhanglw@daqsoft.com">zhanglw@daqsoft.com</a>
 * @Create: 2018/2/28 0028 上午 10:31
 * @Version: V3.6.0
 * @Copyright: <a htef="http://www.daqsoft.com">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 **/
@Entity
@Table(name = "SYS_USER")
public class SysUser {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "USER_NAME", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "SYS_USER_ROLE", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<SysRole> roles;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }
}
