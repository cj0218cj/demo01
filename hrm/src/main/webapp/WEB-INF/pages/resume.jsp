<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/26
  Time: 22:06
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
<table>
    <tr>
        <th>姓名：</th>
        <th>${sessionScope.resume.r_name}</th>
    </tr>
    <tr>
        <th>年龄：</th>
        <th>${sessionScope.resume.r_age}</th>
    </tr>
    <tr>
        <th>性别：</th>
        <th>${sessionScope.resume.r_sex}</th>
    </tr>
    <tr>
        <th>毕业院校：</th>
        <th>${sessionScope.resume.r_school}</th>
    </tr>
    <tr>
        <th>专业：</th>
        <th>${sessionScope.resume.r_major}</th>
    </tr>
    <tr>
        <th>联系电话：</th>
        <th>${sessionScope.resume.r_phone}</th>
    </tr>
    <tr>
        <th>工作年限：</th>
        <th>${sessionScope.resume.r_workingYears}</th>
    </tr>
    <tr>
        <th>工作经历：</th>
        <th>${sessionScope.resume.r_workExperience}</th>
    </tr>
    <tr>
        <th>自我介绍：</th>
        <th>${sessionScope.resume.r_introduce}</th>
    </tr>
    <tr>
        <td>
            <form action="updateResume.do" method="post">
                <input type="submit" value="修改">
            </form>
        </td>
        <td>
            <form action="deleteResume.do" method="post">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
</table>

</body>
</html>
