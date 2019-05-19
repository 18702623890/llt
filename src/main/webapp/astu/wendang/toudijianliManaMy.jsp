<%@ page language="java" pageEncoding="UTF-8"   isELIgnored="false"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function down1(fujianPath,fujianYuashiMing)
           {
               var url="<%=path %>/updown/updown.jsp?fujianPath="+fujianPath+"&fujianYuashiMing="+fujianYuashiMing;
		       url=encodeURI(url); 
               url=encodeURI(url); 
               window.open(url,"_self");
           }
        </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="2" background="<%=path %>/img/tbg.gif">&nbsp;投递简历记录&nbsp;</td>
				</tr>
<<<<<<< HEAD
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="50%">投递简历时间</td>
					<td width="50%">简历附件</td>
		        </tr>	
=======
				<tr>
				<s:fieldError="' align="center" bgcolor="#FAFAF1" height="22">
					<td width="50%">投递简历时间</td>
					<td width="50%">简历附件</td>
		        </tr>
>>>>>>> 第一次更新
				<s:iterator value="#request.toudijianliList" id="toudijianli">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#toudijianli.shijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#toudijianli.fujianYuanshiming"/>
						<a href="#" onclick="down1('<s:property value="#toudijianli.fujian"/>','<s:property value="#toudijianli.fujianYuanshiming"/>')" style="font-size: 10px;color: red">down</a>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
