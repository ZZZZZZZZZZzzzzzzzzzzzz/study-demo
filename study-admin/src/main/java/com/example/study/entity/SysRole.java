package com.example.study.entity;

import javax.persistence.*;

/**
 * @ProjectName: hzCloud_SEM_YUN
 * @ClassName: com.example.study.entity
 * @Description:
 * @author: <a htef="mailto:zhanglw@daqsoft.com">zhanglw@daqsoft.com</a>
 * @Create: 2018/2/28 0028 上午 10:27
 * @Version: V3.6.0
 * @Copyright: <a htef="http://www.daqsoft.com">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 **/
@Entity
@Table(name = "SYS_ROLE")
public class SysRole {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "CODE", length = 20, nullable = false, unique = true)
    private String code;

    @Column(name = "NAME", length = 20, nullable = false, unique = true)
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
