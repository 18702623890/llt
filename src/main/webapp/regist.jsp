<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Jfianl注册界面</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        clock = '';
        nums = 60;
        btn = null;
        function sendCode(ele){
         //   window.alert("触发了这个按钮")
            $.ajax({
                type : "POST",
                url : "/common/sendMess",
                data : { "email" : $("#email").val()},
                async : true,
                success : function(data) {
                    var yzm=data.yzm;
               //     window.alert(yzm);
                    time(ele)
                }
            });
        }
        function time(thisBtn) {
            btn = thisBtn;
            btn.disabled = true; // 将按钮置为不可点击
           btn.value = nums + '秒后可重新获取';//让按钮显示倒计时
           clock = setInterval(doLoop, 1000);  //setInterval（arg1，arg2）为定时器，arg1为执行哪个函数，arg2为多久执行一次（单位毫秒）
        }
        function doLoop() {
            nums--;
            if (nums > 0) {
                btn.value = nums + '秒后可重新获取';
            }
        else {
            //如果倒数计时结束，就清除定时器，将按钮状态改为可点击，并将按钮值显示为“重新发送”，最后重置倒计时时间60秒。
                 clearInterval(clock); // 清除js定时器
                 btn.disabled = false;
                 btn.value = '重新发送验证码';
                 nums = 60;
        }
        }
    </script>
</head>
<body>
  <h1 align="center">用户注册</h1>
  <form action="<%=request.getContextPath()%>/users/adduser" method="post">
    <table align="center">
        <tr>
            <td>用户名：</td>
            <td><input  type="text" name="users.username" value="${op.username}" maxlength="20"><font color="red">${(usernameMsg)}</font></td>
        </tr>
        <tr>
            <td>设置密码：</td>
            <td><input type="password" name="users.password" value="${op.password}" maxlength="20"><font color="red">${(passwordMsg)}</font></td>
        </tr>
        <tr>
            <td>手机号码：</td>
            <td> <input type="text"  id="phone" name="users.phone" value="${op.phone}" maxlength="20"><font color="red">${(phoneMsg)}</font></td>
        </tr>
        <tr>
            <td>邮箱：</td>
            <td> <input type="text"  id="email"name="users.email" value="${op.email}" maxlength="20"><font color="red">${(emailMsg)}</font> </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td> <input type="text" name="users.birthday" value="${op.birthday}" maxlength="20"><font color="red">${(birthdayMsg)}</font></td>
        </tr>
        <tr>
            <td>家庭住址：</td>
            <td><input type="text" name="users.address" value="${op.address}" maxlength="20"></td>
        </tr>
        <tr>
            <td>邮箱验证：</td>
            <td> <input type="text" name="input_code"  placeholder="请输入验证码"><font color="red">${(input_codeMsg)}</font></td>
            <td> <input type="button" id="getCode" value="获取验证码" onclick="sendCode(this)"></td>
        </tr>
        <tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"></td>
        </tr>
    </table>
  </form>
</body>
</html>
