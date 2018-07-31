<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/30
  Time: 00:24
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
<form action="inviteResult.do" method="post">
    <table>
        <tr>
            <td>面试职位：</td>
            <td>${sessionScope.recruManage.recruitment.job.j_name}</td>
        </tr>
        <tr>
            <td>面试时间：</td>
            <td>${sessionScope.recruManage.recruitment.rt_time}</td>
        </tr>
        <tr>
            <td>面试地点：</td>
            <td>${sessionScope.recruManage.recruitment.rt_workingAddress}</td>
        </tr>
    </table>
    <input type="radio" value="2" name="state">去面试<br/>
    <input type="radio" value="-1" name="state">不去了<br/>
    <input type="submit" value="提交">
    <a href="returnback.do">返回</a>
</form>
</body>
</html>
