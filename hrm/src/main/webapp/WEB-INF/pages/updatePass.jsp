<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/26
  Time: 17:11
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
<form action="passUpdate.do" method="post">
    请输入原密码：<input type="password" name="old"><br/>
    请输入新密码：<input type="password" name="pass"><br/>
    <input type="submit" value="确认更改">
    <a href="returnback.do.do">返回</a>
    <h3>${error}</h3>
</body>
</html>
