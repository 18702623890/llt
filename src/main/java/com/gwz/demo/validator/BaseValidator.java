package com.gwz.demo.validator;
import com.jfinal.validate.Validator;
public abstract class BaseValidator extends Validator {

    protected void validatePassword(String field, String errorKey, String errorMessage) {
        String value = controller.getPara(field);
        if(!isStrongPassword(value)){
            addError(errorKey,errorMessage);
        }
    }
    private static  final  String grp1="abcdefghijklmnopqrstuvwxyz";
    private static  final  String grp2="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String grp3="0123456789";
    protected  boolean isStrongPassword(String pw){
        boolean ok1=false,ok2=false,ok3=false;
        for(int i=0;i<pw.length();i++) {
            if (ok1 && ok2 && ok3)
                break;
            if(grp1.contains(pw.substring(i,i+1))){
                ok1=true;
                continue;
            }
            if(grp2.contains(pw.substring(i,i+1))) {
                ok2 = true;
                continue;
            }
            if(grp3.contains(pw.substring(i,i+1))){
                ok3=true;
                continue;
            }
        }
        return ok1 && ok2 && ok3;

    }

}
