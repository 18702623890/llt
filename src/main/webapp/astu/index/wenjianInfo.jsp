<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/24 0024
  Time: 下午 4:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>我的所有文件</title>
</head>
<style type="text/css">
    .odd{
        background-color: #9acfea;
    }
    .even{
        background-color: #BFD67C;
    }
    .pagination {
        text-align: center;
        alignment: center;
        display: inline-block;
        margin: 10px;
    }
    .pageination a{
        text-decoration: none;
        border:1px solid #f9d52b;
        padding: 5px 7px;
        color: #767675;
        cursor: pointer;
    }
    div.center{
        text-align: center;
    }

    ul.pagination li {display: inline;}

    ul.pagination li a {
        float: left;
        padding: 8px 16px;
        text-decoration: none;
    }
    ul.pagination li a.active{
        background-color:deepskyblue ;
    }
    ul.pagination li a:visited{
        background-color:#d10e00;
    }
    ul.pagination li a:hover:not(.active){
        background-color: #DCECA6;
    }
</style>
<body>
<h1 align="center"> 我的文件信息</h1>
<table border="1" width="95%">
    <tr>
        <td align="center">文件信息</td>
        <td align="center">作者</td>
        <td align="center">文件描述</td>
        <td align="center">操作</td>
    </tr>
    <c:forEach items="${filelist}" var="b" varStatus="vs">
    <tr class="${vs.index%2==0?'odd':'even'}">
            <td align="center">
             ${b.filename}</td>
            <td align="center">
                ${b.author}</td>
            <td align="center">
               ${b.description}</td>
            </td>
        <td>
        <a href="<%=request.getContextPath()%>/doc/deleteDoc?id=${b.id}"> 删除</a>
            <a href="<%=request.getContextPath()%>/doc/downloadDoc?id=${b.id}">下载</a>
        </td>
    </tr>
        </c:forEach>
</table>
<div class="pagination" align="center">
    <nav aria-label="Page navigation">
        <ul class="pagination" >
            <li><a href="<%=request.getContextPath()%>/doc/paginate?pageNumber=${blogPage.pageNumber>1?blogPage.pageNumber-1:1}">上一页</a></li>
            <c:forEach begin="1" end="${blogPage.totalPage}" varStatus="page">
                <c:choose>
                    <c:when test="${blogPage.pageNumber==page.index}">
                        <li class="active"><a href="<%=request.getContextPath()%>/doc/paginate?pageNumber=${page.index}">${page.index}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="<%=request.getContextPath()%>/doc/paginate?pageNumber=${page.index}">${page.index}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <li><a href="<%=request.getContextPath()%>/doc/paginate?pageNumber=${blogPage.pageNumber<blogPage.totalPage?blogPage.pageNumber+1:blogPage.totalPage}">下一页</a></li>
        </ul>
    </nav>
</div>
</body>
</html>
