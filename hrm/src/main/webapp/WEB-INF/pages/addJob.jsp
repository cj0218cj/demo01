<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/8/1
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
<form action="jobAdd.do?d_id=${requestScope.d_id}" method="post">
    职位名称：<input type="text" name="j_name"><br/>
    基本薪资：<input type="number" min="1" name="j_bansePay"><br/>
    <input type="submit" value="确认添加">
</form>
<h3>${qq}</h3>
<a href="returnManage.do">返回</a>
</body>
</html>
