<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jfinal 用户列表</title>
</head>
<body>
<h1 align="center">jfinal 用户列表</h1>

<table border="1" width="100%">
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>手机号码</td>
        <td>邮箱</td>
        <td>生日</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${objectlist}" var="obj" varStatus="1" >
        <tr>
            <td class="center">${(obj.username)}</td>
            <td class="center">${(obj.password)}</td>
            <td class="center">${(obj.phone)}</td>
            <td class="center">${(obj.email)}</td>
            <td class="center">${(obj.birthday)}</td>
            <td class="center">${(obj.address)}</td>
            <td><a href="<%=request.getContextPath()%>/users/editById/${obj.id}">编辑</a>
                <a href="<%=request.getContextPath()%>/users/deleteById/${(obj.id)}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
 <p align="center"> <a href="<%=request.getContextPath()%>/users/uploadFile">上传文件</a></p>
<form action="<%=request.getContextPath()%>/users/logout" method="post">
    <p align="center">  <input type="submit" value="退出账户"> </p>
</form>
</body>
</html>