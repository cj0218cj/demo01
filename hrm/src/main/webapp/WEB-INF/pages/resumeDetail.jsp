<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/31
  Time: 15:13
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
<form action="meettingOrder.do" method="post">
<table>
    <tr>
        <th>姓名：</th>
        <th>${resu.r_name}</th>
    </tr>
    <tr>
        <th>年龄：</th>
        <th>${resu.r_age}</th>
    </tr>
    <tr>
        <th>性别：</th>
        <th>${resu.r_sex}</th>
    </tr>
    <tr>
        <th>毕业院校：</th>
        <th>${resu.r_school}</th>
    </tr>
    <tr>
        <th>专业：</th>
        <th>${resu.r_major}</th>
    </tr>
    <tr>
        <th>联系电话：</th>
        <th>${resu.r_phone}</th>
    </tr>
    <tr>
        <th>工作年限：</th>
        <th>${resu.r_workingYears}</th>
    </tr>
    <tr>
        <th>工作经历：</th>
        <th>${resu.r_workExperience}</th>
    </tr>
    <tr>
        <th>自我介绍：</th>
        <th>${resu.r_introduce}</th>
    </tr>
</table>
<input type="submit" value="通知面试">
</form>
<a href="returnManage.do">返回</a>

</body>
</html>
