package com.gwz.demo.config;

import com.gwz.demo.controller.common.CommonController;
import com.gwz.demo.controller.user.DocumentController;
import com.gwz.demo.controller.user.UserController;
import com.gwz.demo.model.*;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.ModelRecordElResolver;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setViewType(ViewType.JSP);
        constants.setDevMode(true);
        ModelRecordElResolver.setResolveBeanAsModel(true);
<<<<<<< HEAD
        constants.setBaseUploadPath("upload/");
        constants.setBaseDownloadPath("/download");
=======
        constants.setBaseUploadPath("upload/pdfFile/");
        constants.setBaseDownloadPath("/download");
        constants.setInjectDependency(true);

>>>>>>> 第一次更新
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/users", UserController.class);
        routes.add("/common", CommonController.class);
        routes.add("/doc", DocumentController.class);

    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

        PropKit.use("db.properties");
        DruidPlugin druid = new DruidPlugin(PropKit.get("jdbc.url").trim(),
                PropKit.get("jdbc.user").trim(), PropKit.get("jdbc.password").trim());
        plugins.add(druid);
        ActiveRecordPlugin activeRecord=new ActiveRecordPlugin(druid);
        activeRecord.setShowSql(true);
        plugins.add(activeRecord);
        activeRecord.addMapping("users","id",Users.class);//数据库表名映射到users到对象
        activeRecord.addMapping("file","id",UpFile.class);
<<<<<<< HEAD
=======
        activeRecord.addMapping("json_task","id",Task.class);
>>>>>>> 第一次更新
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        //配置的是全局拦截器
  //      interceptors.add(new LoginInterceptor());
<<<<<<< HEAD
=======
     //   interceptors.add(new I18nInterceptor());
>>>>>>> 第一次更新
    }

    @Override
    public void configHandler(Handlers handlers) {
<<<<<<< HEAD

=======
            /* handlers.add(new Handler() {
                 @Override
                 public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
                     request.setAttribute("ctx",request.getContextPath());
                     next.handle(target,request,response,isHandled);
                 }
             });*/
>>>>>>> 第一次更新
    }


}
