package com.gwz.demo.validator;
import com.gwz.demo.model.Users;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

<<<<<<< HEAD
public class UserValidator extends Validator {
    @Override
    protected void validate(Controller controller) {
     validateRequired("users.username","usernameMsg","用户名不能为空");
     validateRequired("users.password","passwordMsg","密码不能为空");
     validateRegex("users.phone","\\b(1\\d{10})\\b","phoneMsg","电话号码不合格");
     validateEmail("users.email","emailMsg","邮箱格式不正确");
     validateDate("users.birthday","birthdayMsg","生日格式不对");
     String input_code=controller.getPara("input_code");
     String yzm=controller.getAttr("yzm");
     if(!input_code.equals(yzm)) {
             controller.setAttr("input_codeMsg","验证码不正确");
         }
=======
public class UserValidator extends BaseValidator {
    @Override
    protected void validate(Controller controller) {
        validateRequired("users.username", "usernameMsg", "用户名不能为空");
        validateRequired("users.password", "passwordMsg", "密码不能为空");
        validatePassword("users.password","passwordMsg","密码应由字母数字组合");
        validateRegex("users.phone", "\\b(1\\d{10})\\b", "phoneMsg", "电话号码不合格");
        validateEmail("users.email", "emailMsg", "邮箱格式不正确");
        validateDate("users.birthday", "birthdayMsg", "生日格式不对");
        if (controller.getPara("input_code") != null) {
            String input_code = controller.getPara("input_code");
            String yzm = controller.getAttr("yzm");
            if (!input_code.equals(yzm)) {
                controller.setAttr("input_codeMsg", "验证码不正确");
            }
        }
>>>>>>> 第一次更新
    }
    @Override
    protected void handleError(Controller controller) {   //如果验证不成功，返回那个界面
    String actionKey=getActionKey();
    Users users=controller.getModel(Users.class,"users");
    controller.setAttr("op",users);
    controller.keepModel(Users.class);
    if("/users/adduser".equals(actionKey)){
        controller.render("/regist.jsp");
    }
    else if ("/users/updateUser".equals(actionKey))
    {
        controller.render("/editUser.jsp");
        }
    }
}
