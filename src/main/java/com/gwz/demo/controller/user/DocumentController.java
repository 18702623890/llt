package com.gwz.demo.controller.user;

import com.gwz.demo.model.Preference;
import com.gwz.demo.model.UpFile;
import com.gwz.demo.service.impl.user.DocumentService;
import com.gwz.demo.service.impl.user.USerService;
import com.gwz.demo.util.FileDirtory;
import com.gwz.demo.util.IdGenertor;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class DocumentController extends Controller {
    //处理文档
    static final DocumentController documentController=new DocumentController();
    static  final DocumentService documentService=DocumentService.documentService;
    USerService serService=new USerService();
    public void paginate(){
       Integer pageNumber=getParaToInt("pageNumber");
       if(pageNumber==null){
           pageNumber=1;
       }
        Page<UpFile> filePage=documentService.paginate(pageNumber,5);
        List<UpFile> fileList=filePage.getList();
        setSessionAttr("filelist",fileList);
        setSessionAttr("blogPage",filePage);
        System.out.println(fileList);
        render("/astu/index/wenjianInfo.jsp");
    }
    public void deleteDoc(){
        String id=getPara("id");
        System.out.println(id);
        documentService.deleteDocById(id);
        paginate();

    }
    public void uploadFile(){
        renderJsp("/astu/index/upload.jsp");
    }
    public  void doUploadFile(){
        HttpServletRequest request = getRequest();
        String basePath = request.getContextPath();
        //存储路径
        String storeDirectory= getSession().getServletContext().getRealPath(Preference._path);
        UploadFile file =getFile("filename");  //处理文件上传
        UpFile upfile=this.getModel(UpFile.class,"file");  //映射
        String fileName = "";
        if(file.getFile().length() > 200*1024*1024) {
            System.err.println("文件长度超过限制，必须小于200M");
        }else{
            //上传文件
        //    String type = file.getFileName().substring(file.getFileName().lastIndexOf(".")); // 获取文件的后缀,如.txt
            fileName = file.getFileName(); // 对文件重命名取得的文件名+后缀
            String path= FileDirtory.genChildDirectory(storeDirectory,fileName);
            String dest = storeDirectory+"/"+path + "/" + fileName;
            System.out.println(dest);
            String filepath=storeDirectory+"/"+path;
            file.getFile().renameTo(new File(dest));
            upfile.set("id", IdGenertor.genGUID());
            upfile.set("filename",fileName);
            upfile.set("path",filepath);
        }
        String author=getPara("author");
        upfile.set("author",author);
        String description=getPara("description");
        upfile.set("description",description);
        serService.saveFile(upfile);
        paginate();
     //   renderJsp("/astu/index/wenjianInfo.jsp");
    }
    public void downloadDoc(){
      String id=getPara("id");
      UpFile upFile=documentService.findById(id);
      String path=upFile.get("path");
      System.out.println(path);
      File file=new File(path+"/"+upFile.get("filename"));
      if(file.exists()){
          renderFile(file);
      }
      else{
          System.out.println("文件不存在");
      }

    }


}
