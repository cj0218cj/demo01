<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/26
  Time: 22:21
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
<form action="resumeUpdate.do" method="post">
<table>
    <tr>
        <th>姓名：</th>
        <th><input type="text" value="${sessionScope.resume.r_name}" name="r_name"></th>
    </tr>
    <tr>
        <th>年龄：</th>
        <th><input type="number" value="${sessionScope.resume.r_age}" name="r_age"></th>
    </tr>
    <tr>
        <th>性别：</th>
        <th><input type="text" value="${sessionScope.resume.r_sex}" name="r_sex"></th>
    </tr>
    <tr>
        <th>毕业院校：</th>
        <th><input type="text" value="${sessionScope.resume.r_school}" name="r_school"></th>
    </tr>
    <tr>
        <th>专业：</th>
        <th><input type="text" value="${sessionScope.resume.r_major}" name="r_major"></th>
    </tr>
    <tr>
        <th>联系电话：</th>
        <th><input type="number" value="${sessionScope.resume.r_phone}" name="r_phone"></th>
    </tr>
    <tr>
        <th>工作年限：</th>
        <th><input type="number" value="${sessionScope.resume.r_workingYears}" name="r_workingYears"></th>
    </tr>
    <tr>
        <th>工作经历：</th>
        <th><textarea name="r_workExperience">${sessionScope.resume.r_workExperience}</textarea></th>
    </tr>
    <tr>
        <th>自我介绍：</th>
        <th><textarea name="r_introduce" >${sessionScope.resume.r_introduce}</textarea></th>
    </tr>

</table>
    <input type="submit" value="确认修改">
</form>
<a href="returnback.do">返回</a>
<h3>${aa}</h3>
</body>
</html>
