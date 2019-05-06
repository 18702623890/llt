<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改用户信息</title>
</head>
<body>
  <h1 align="center">修改用户信息</h1>
  <form action="<%=request.getContextPath()%>/users/updateUser" method="post">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input  type="text" name="users.username" value="${up.username}" maxlength="20"></td><td>${(usernameMsg)}</td>
        </tr>
        <tr>
            <td>密 码：</td>
            <td><input type="password" name="users.password" value="${up.password}" maxlength="20"></td><td>${passwordMsg}</td>
        </tr>
        <tr>
            <td>手机号码：</td>
            <td> <input type="text" name="users.phone" value="${up.phone}" maxlength="20"></td><td><font color="red">${phoneMsg}</font></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td> <input type="text" name="users.email" value="${up.email}" maxlength="20"></td><td>${emailMsg}</td>
        </tr>
        <tr>
            <td>生日：</td>
            <td> <input type="text" name="users.birthday" value="${up.birthday}" maxlength="20"></td><td>${birthdayMsg}</td>
        </tr>
        <tr>
            <td>家庭住址：</td>
            <td><input type="text" name="users.address" value="${up.address}" maxlength="20"></td><td ><font color="red">${addresssMsg}</font></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
  </form>
</body>
</html>
