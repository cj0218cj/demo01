<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/8/1
  Time: 01:05
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
<form action="deptUpdate.do" method="post">
    部门名称：<input type="text" value="${sessionScope.dept.d_name}" name="d_name">
    <input type="submit" value="确认更改">
</form>
<h3>${error}</h3>
</body>
</html>
