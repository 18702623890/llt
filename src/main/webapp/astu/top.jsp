<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/base.css" rel="stylesheet" type="text/css">
	  <script language="javascript" type="text/javascript" src="<%=path %>/js/menu.js"></script>
  </head>
  <body bgColor='#C0D586' style="margin: 0;padding: 0">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" background="<%=path %>/img/topbg.gif">
	  <tr>
	    <td width='50%' height="60" style="font-size:26px; font-weight: bold;">&nbsp;&nbsp;用户的文档管理</td>
	    <td width='50%' align="right">
	    	<table width="750" border="0" cellspacing="0" cellpadding="0">
		      <tr>
			      <td align="right" height="26" style="padding-right:10px;line-height:26px;font-size:17px">
			        	<font style="font-size:16px; font-weight: bold;">
			        	    欢迎您回来：${userlogin.username}&nbsp;&nbsp;&nbsp;&nbsp;
			        	</font>
			      </td>
				  <td>
					  <a href="<%=path%>/users/editById?id=${userlogin.id}"target='main'>个人中心信息</a>
				  </td>
	          </tr>
	        </table>
	    </td>
	  </tr>
	</table>
  </body>
</html>
