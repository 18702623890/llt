package com.gwz.demo.validator;


import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class TokenValidator extends Validator {
    @Override
    protected void validate(Controller c) {
        validateToken("jfinal_token","toke_msg","alert('上次已保存,请不要重复提交')");
    }

    @Override
    protected void handleError(Controller c) {

    }
}
