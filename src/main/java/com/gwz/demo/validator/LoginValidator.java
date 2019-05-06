package com.gwz.demo.validator;


import com.alibaba.druid.util.StringUtils;
import com.gwz.demo.model.Users;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import org.eclipse.jetty.util.StringUtil;

public class LoginValidator extends Validator {

    @Override
    protected void validate(Controller c) {
        validateRequired("users.username","usernameMsg","用户名不能为空");
        validateRequired("users.password","passwordMsg","密码不能为空");
        validateRequired("code","codeMsg","验证码不能为空");

    }

    @Override
    protected void handleError(Controller c) {
        Users users=c.getModel(Users.class,"users");
        c.setAttr("login_users",users);
    c.render("/login.jsp");
    }
}
