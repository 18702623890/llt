package com.gwz.demo.controller.user;
import com.gwz.demo.model.UpFile;
import com.gwz.demo.model.Preference;
import com.gwz.demo.model.Users;
import com.gwz.demo.util.FileDirtory;
import com.gwz.demo.service.impl.user.USerService;
import com.gwz.demo.util.IdGenertor;
import com.gwz.demo.validator.LoginValidator;
import com.gwz.demo.validator.UserValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import interperter.LoginInterceptor;
import java.util.List;
<<<<<<< HEAD

=======
>>>>>>> 第一次更新
@Before(LoginInterceptor.class)
public class UserController extends Controller {
    USerService serService=new USerService();
    DocumentController documentController=DocumentController.documentController;
    /**
     * 注册
     */
    @Clear
    public void index(){

        renderJsp("/login.jsp");
    }
    @Clear
    public void resign(){

        redirect("/regist.jsp");
    }
    @Clear
    @Before(UserValidator.class)
    public void adduser(){
<<<<<<< HEAD
=======
        createToken("jfinal_token",30*60);
>>>>>>> 第一次更新
        Users users=this.getModel(Users.class,"users");
        if(serService.saveUsers(users)){
            renderText("注册成功");
        }
        else {
            renderText("注册失败");
        }
        index();
    }
    @Clear
    @Before(LoginValidator.class)
    public void login(){
       String username=getPara("users.username");
       String password=getPara("users.password");
        Users u=this.getModel(Users.class,"users");
        setAttr("login_users",u);
       boolean rs=serService.findUserByName(username);
       if(!rs){
           setAttr("usernameMsg","用户名不存在");
           render("/login.jsp");
           return ;
       }
       boolean result=validateCaptcha("code");
       if(!result){
           setAttr("codeMsg","验证码错误");
           render("/login.jsp");
           return ;
       }
       Users users=serService.LoginUsers(username,password);
       if(users!=null){
         System.out.println("登录成功！");
         setSessionAttr("userlogin",users);
         render("/astu/index.jsp");
       }
       else{
           setAttr("passwordMsg","密码不正确");
           render("/login.jsp");
           return ;
       }
    }
    @Clear
    public void logout(){
        removeSessionAttr("userlogin");
        System.out.println("注销账号");
        redirect("/login.jsp");
    }
    public void showUserList(){
        List<Users> objectlist=serService.findAllUsers();
        if(objectlist!=null){
          setAttr("objectlist",objectlist);
        }
        renderJsp("/userlist.jsp");
    }
    public void editById(){
          String id=getPara("id");
          setSessionAttr("keyId",id);
          Users users=serService.findUser(id);
          setAttr("up",users);
          renderJsp("/editUser.jsp");
    }
    @Before(UserValidator.class)
    public void updateUser(){
        Users users=this.getModel(Users.class,"users");   //还要记录好上次的id
        String id=getSessionAttr("keyId");
        users.set("id",id);
        serService.updateUsers(users);
        renderJsp("/astu/index/sysPro.jsp");
    }
    public void deleteById(){
        String id=getPara(0);
        serService.deleteById(id);
        showUserList();
    }




}
