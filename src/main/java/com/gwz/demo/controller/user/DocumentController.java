package com.gwz.demo.controller.user;

import com.gwz.demo.model.Preference;
<<<<<<< HEAD
import com.gwz.demo.model.UpFile;
import com.gwz.demo.service.impl.user.DocumentService;
import com.gwz.demo.service.impl.user.USerService;
import com.gwz.demo.util.FileDirtory;
import com.gwz.demo.util.IdGenertor;
=======
import com.gwz.demo.model.Task;
import com.gwz.demo.model.UpFile;
import com.gwz.demo.service.impl.user.DocumentService;
import com.gwz.demo.service.impl.user.TaskService;
import com.gwz.demo.service.impl.user.USerService;
import com.gwz.demo.util.FileDirtory;
import com.gwz.demo.util.IdGenertor;
import com.jfinal.aop.Inject;
>>>>>>> 第一次更新
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
<<<<<<< HEAD
=======
import java.sql.Timestamp;
>>>>>>> 第一次更新
import java.util.List;

public class DocumentController extends Controller {
    //处理文档
<<<<<<< HEAD
=======
    @Inject
    TaskService taskService;
>>>>>>> 第一次更新
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
<<<<<<< HEAD
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
=======
        String storeDirectory= getSession().getServletContext().getRealPath(Preference._path);   //存储路径
        UploadFile file =getFile("filename");  //处理文件上传
        UpFile upfile=this.getModel(UpFile.class,"file");  //映射
        Task task=this.getModel(Task.class,"json_task");
        String fileName = "";
        if(file.getFile().length() > 200*1024*1024) {
            System.err.println("文件长度超过限制，必须小于200M");
        }else {
            //上传文件
            File tempfile = file.getFile(); //得到文件
            try {
                String hashvalue = FileDirtory.getFileMD5String(tempfile);  //文件生成hash值
                System.out.println(hashvalue);
                if (documentService.finByChecksum(hashvalue) != null) {
                    System.out.println("该文件已上传，请勿重复提交");
                    renderJsp("/astu/error.jsp");
                } else {
                    upfile.set("checksum", hashvalue);
                    task.set("checksum",hashvalue);
                    task.set("status",0);
                    System.out.println(task);
                    fileName = file.getFileName();
                    String type=file.getFileName().substring(file.getFileName().lastIndexOf("."));
                    System.out.println(fileName);
                    String dest = storeDirectory + "\\"+ hashvalue+type;
                    File file2=new File(dest);
                    System.out.println(file2);
                    File file1=new File("D://23.txt");
                    String filepath = storeDirectory;
                    System.out.println(tempfile);
                   if(tempfile.isFile()) {
                    if(tempfile.renameTo(file2)){
                          System.out.println("成功");//以checksum的形式对文件进行重命名
                      }
                   upfile.set("filename", fileName);
                    upfile.set("path", filepath);
                   }
                   else{
                       System.out.println("不存在");
                   }
                }
                String author = getPara("author");
                upfile.set("author", author);
                String description = getPara("description");
                upfile.set("description", description);
                Timestamp timestamp=new Timestamp((System.currentTimeMillis()));
                System.out.println(timestamp);
                upfile.set("uploadTime",timestamp);
                upfile.set("status",0);
                serService.saveFile(upfile);
                taskService.addTask(task);
                paginate();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
>>>>>>> 第一次更新
    }
    public void downloadDoc(){
      String id=getPara("id");
      UpFile upFile=documentService.findById(id);
      String path=upFile.get("path");
      System.out.println(path);
<<<<<<< HEAD
      File file=new File(path+"/"+upFile.get("filename"));
=======
      File file=new File(path+"\\"+upFile.get("filename"));
>>>>>>> 第一次更新
      if(file.exists()){
          renderFile(file);
      }
      else{
          System.out.println("文件不存在");
      }
<<<<<<< HEAD

    }


=======
    }
>>>>>>> 第一次更新
}
