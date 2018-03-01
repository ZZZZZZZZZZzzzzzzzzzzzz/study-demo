package com.example.study.service.impl;

import com.example.study.dao.SysUserRepository;
import com.example.study.entity.SecurityUser;
import com.example.study.entity.SysUser;
import com.example.study.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: hzCloud_SEM_YUN
 * @ClassName: com.example.study.service.impl
 * @Description:
 * @author: <a htef="mailto:zhanglw@daqsoft.com">zhanglw@daqsoft.com</a>
 * @Create: 2018/2/28 0028 下午 2:45
 * @Version: V3.6.0
 * @Copyright: <a htef="http://www.daqsoft.com">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 **/
@Component
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findByName(username);
        if( sysUser == null ){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        SecurityUser securityUser = new SecurityUser(sysUser);
        return securityUser;
    }
}
