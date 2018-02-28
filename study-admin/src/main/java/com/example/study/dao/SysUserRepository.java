package com.example.study.dao;

import com.example.study.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: hzCloud_SEM_YUN
 * @ClassName: com.example.study.dao
 * @Description:
 * @author: <a htef="mailto:zhanglw@daqsoft.com">zhanglw@daqsoft.com</a>
 * @Create: 2018/2/28 0028 下午 2:45
 * @Version: V3.6.0
 * @Copyright: <a htef="http://www.daqsoft.com">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 **/
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    @Query(value = "select t from SysUser t where t.username = :username ")
    SysUser findByName(@Param(value = "username") String username);
}
