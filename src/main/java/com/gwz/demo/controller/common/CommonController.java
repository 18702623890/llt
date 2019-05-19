package com.gwz.demo.controller.common;
<<<<<<< HEAD
import com.gwz.demo.util.Capthcha;
import com.jfinal.aop.Clear;
=======
import com.gwz.demo.service.impl.user.DocumentService;
import com.gwz.demo.service.impl.user.USerService;
import com.gwz.demo.util.Capthcha;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
>>>>>>> 第一次更新
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

@Clear
public class CommonController extends Controller {
<<<<<<< HEAD
=======
    @Inject
    DocumentService service;
>>>>>>> 第一次更新
  @ActionKey("/yzm")
    public void code(){
        renderCaptcha();
     }
     @ActionKey("/common/sendMess")
    public void sendMess() throws EmailException {
        String email=this.getPara("email");
        System.out.println(email);
         HtmlEmail htmlEmail=new HtmlEmail();
         htmlEmail.setHostName("smtp.163.com");
         htmlEmail.setCharset("utf-8");
         htmlEmail.addTo(email);
         htmlEmail.setAuthentication("llt1661@163.com","tang18702623890");
         htmlEmail.setFrom("llt1661@163.com","雷良堂");
         String yzm=new Capthcha().getRandomString();
         htmlEmail.setMsg("您好，你正在使用邮箱验证，您的验证码为："+yzm+"  请谨慎保管");
         htmlEmail.setSubject("验证码");
         htmlEmail.send();
         setAttr("yzm",yzm);
         renderJson();
    }
<<<<<<< HEAD
=======
    public  void getMess(){
     service.findById("23");

    }
>>>>>>> 第一次更新
}
