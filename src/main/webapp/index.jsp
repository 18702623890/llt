<html>
<body  background="<%=request.getContextPath() %>/img/dfff.jpg">
<form action="<%=request.getContextPath()%>/users/login" method="post">
    <h1 align="center">用户登录</h1>
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td> <input type="text" name="users.username" value="" maxlength="20">${usernameMsg}</td>
        </tr>
        <tr>
            <td>密 码：</td>
            <td> <input type="password" name="users.password" value="" maxlength="20">${passwordMsg}</td>
        </tr>
        <tr><br></tr>
        <tr >
            <td>验证码：</td>
            <td><input name="code" type="text" maxlength="10"></td> <td> <img src="/yzm" id="img" onclick="javascript:this.src='/yzm?x='+Math.random()"/>${codeMsg}</td>
        </tr>
        <tr>
            <td colspan="2" align="center"> <input type="submit"  value="登录" maxlength="20"></td>
        </tr>
    </table>
</form>
<p align="center"><a  href="<%=request.getContextPath()%>/users/resign">注册</a></p>
</body>
</html>