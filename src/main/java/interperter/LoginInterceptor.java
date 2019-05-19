package interperter;

import com.gwz.demo.model.Users;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class LoginInterceptor implements Interceptor {
    @Override
    public void intercept(Invocation invocation) {
        Controller controller=invocation.getController();
        Users users=controller.getSessionAttr("userlogin");
        if(users==null){
            controller.renderText("请先登录");
            controller.redirect("/login.jsp");
<<<<<<< HEAD

            return ;
        }
        invocation.invoke();

=======
            return ;
        }
        invocation.invoke();
>>>>>>> 第一次更新
    }
}
