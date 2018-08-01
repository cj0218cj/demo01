<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/8/1
  Time: 11:19
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
<form action="jobUpdate.do?j_id=${job.j_id}&d_id=${job.dept.d_id}" method="post">
    职位名：<input type="text" value="${job.j_name}" name="j_name"><br/>
    最低薪资：<input type="number" value="${job.j_basePay}" name="money" min="1000"><br/>
    <input type="submit" value="确认更改">
</form>
<a href="returnManage.do">返回主界面</a>
</body>
</html>
