<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/26
  Time: 22:05
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
您当前还没有简历，请去<a href="addResume.do">创建</a>
</body>
</html>
