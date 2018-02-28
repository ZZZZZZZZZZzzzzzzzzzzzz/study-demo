package com.example.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ProjectName: hzCloud_SEM_YUN
 * @ClassName: com.example.study.config
 * @Description:
 * @author: <a htef="mailto:zhanglw@daqsoft.com">zhanglw@daqsoft.com</a>
 * @Create: 2018/2/28 0028 下午 2:04
 * @Version: V3.6.0
 * @Copyright: <a htef="http://www.daqsoft.com">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 **/
@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        super.addResourceHandlers(registry);
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
    }
}
