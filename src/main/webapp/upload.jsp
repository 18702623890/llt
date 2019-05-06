<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/9 0009
  Time: 下午 5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
 <form action="<%=request.getContextPath()%>/users/doUploadFile" method="post" enctype="multipart/form-data">
     <table>
     <tr>
         <td>上传文件名:</td>
         <td><input type="file" name="filename"></td>
     </tr>
         <tr><td>上传作者:</td>
             <td><input type="text" name="author"></td>
         </tr>
         <tr>
             <td>上传描述</td>
             <td><textarea name="description" rows="5" cols="30"></textarea></td>
         </tr>
     <tr>
         <td><input type="submit" value="确定">
         </td>
     </tr>
     </table>
 </form>
 <form action="<%=request.getContextPath()%>/users/showUserList" method="POST">
     <input type="submit" value="返回">
 </form>
 </form>
</body>
</html>
