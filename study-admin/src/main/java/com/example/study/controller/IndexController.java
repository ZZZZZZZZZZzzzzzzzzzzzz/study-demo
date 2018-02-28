package com.example.study.controller;

import com.example.study.entity.SecurityUser;
import com.example.study.entity.SysUser;
import com.example.study.service.SysUserService;
import com.example.study.utlis.R;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ProjectName: hzCloud_SEM_YUN
 * @ClassName: com.example.study.controller
 * @Description:
 * @author: <a htef="mailto:zhanglw@daqsoft.com">zhanglw@daqsoft.com</a>
 * @Create: 2018/2/28 0028 下午 1:36
 * @Version: V3.6.0
 * @Copyright: <a htef="http://www.daqsoft.com">成都中科大旗软件有限公司Copyright  2004-2017蜀ICP备08010315号</a>
 * @Warning: 注意：本内容仅限于成都中科大旗软件有限公司内部传阅，禁止外泄以及用于其他的商业目的。
 **/
@Controller
public class IndexController {

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("modules/{module}/{url}.html")
    public String module(@PathVariable("module") String module, @PathVariable("url") String url){
        return "modules/" + module + "/" + url;
    }

    @RequestMapping(value = {"/", "index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("index1.html")
    public String index1(){
        return "index1";
    }

    @RequestMapping("login.html")
    public String login(){
        return "login";
    }

    @RequestMapping("main.html")
    public String main(){
        return "main";
    }

    @RequestMapping("404.html")
    public String notFound(){
        return "404";
    }

    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpSession session)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

//    /**
//     * 登录
//     */
//    @ResponseBody
//    @RequestMapping(value = "/sys/login", method = RequestMethod.POST)
//    public R login(HttpSession session, String username, String password, String captcha) {
//        Object kaptcha = session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
//        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
//        if( kaptcha == null || !captcha.equalsIgnoreCase(kaptcha.toString()) ){
//            return R.error("验证码不正确");
//        }
//        if( username == null || username.trim().isEmpty() ){
//            return R.error("用户名不能为空");
//        }
//        if( password == null || password.trim().isEmpty() ){
//            return R.error("密码不能为空");
//        }
//        try {
//            SecurityUser securityUser = (SecurityUser) sysUserService.loadUserByUsername(username);
//            System.out.println();
//        } catch (UsernameNotFoundException u){
//            return R.error(u.getMessage());
//        }
//        return R.ok();
//    }
}
