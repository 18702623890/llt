<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/8 0008
  Time: 下午 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<% String path=request.getContextPath(); %>
<html>
<head>
    <title>Jfinal登录</title>
</head>
<body background="<%=path%>/img/123.jpg">
<br>
<br>
<br>
<br>
<table width="559" height="423" border="0" align="center" cellpadding="0" cellspacing="0"  background="<%=path %>/img/dfff.jpg">
    <tr>
        <td><div align="center" style="FONT-WEIGHT: bold; FONT-SIZE: 30pt;">用户登录界面</div></td>
    </tr>
    <tr>
        <td width="559">
            <form action="<%=request.getContextPath()%>/users/login" method="post">
                <table width="410" height="198" border="0" align="right" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="50" height="20" valign="bottom">
                            用户名：
                        </td>
                        <td width="300" valign="bottom">
                            <input type="text" name="users.username" value="${login_users.username}" onMouseOver="this.style.background='#F0DAF3';" onMouseOut="this.style.background='#FFFFFF'">${usernameMsg}
                        </td>
                    </tr>
                    <tr>
                        <td height="10" colspan="2" valign="bottom"></td>
                    </tr>
                    <tr>
                        <td width="50" height="20" valign="bottom">
                        密&nbsp;&nbsp;&nbsp;&nbsp;码：
                    </td>
                        <td width="300" >
                            <input type="password" name="users.password" value="${login_users.password}" size="21" class="input2" align="bottom" onMouseOver="this.style.background='#F0DAF3';" onMouseOut="this.style.background='#FFFFFF'">${passwordMsg}
                        </td>
                    </tr>
                    <tr>
                        <td height="10" colspan="2" valign="bottom"></td>
                    </tr>
                    <tr>
                        <td width="50" height="20" valign="center">
                            验证码：
                        </td>
                        <td width="100">
                            <input name="code" type="text"  value="" size="21" class="input2" align="bottom" onMouseOver="this.style.background='#F0DAF3';" onMouseOut="this.style.background='#FFFFFF'">
                        </td>
                    </tr>
                    <tr> <td colspan="2" align="center"> <img src="/yzm" id="img" onclick="javascript:this.src='/yzm?x='+Math.random()"/>${codeMsg}</td></tr>
                    <tr>
                        <td height="10" colspan="2" valign="bottom"></td>
                    </tr>
                    <tr>
                        <td colspan="2" valign="top">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                            <input name="button" type="submit" class="submit1" value="登录"> &nbsp;
                            <input name="Submit2" type="reset" class="submit1" value="重置">
                            <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
                        </td>
                    </tr>
                    <tr>
                        <td height="10" colspan="2" valign="bottom"></td>
                    </tr>
                    <tr>
                        <td colspan="2" valign="top">&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
                            <a href="<%=request.getContextPath()%>/users/resign">没有用户名,快速注册</a>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
</body>
</html>

