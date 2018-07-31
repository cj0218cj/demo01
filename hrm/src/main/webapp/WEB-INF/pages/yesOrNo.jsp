<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/30
  Time: 14:51
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
<p>
    添加成功，是否立即发布？
</p>
<form action="updateRecruitmentState.do?state=1" method="post">
    <input type="submit" value="发布">
</form>
<form action="updateRecruitmentState.do?state=0" method="post">
    <input type="submit" value="暂不发布">
</form>
</body>
</html>
