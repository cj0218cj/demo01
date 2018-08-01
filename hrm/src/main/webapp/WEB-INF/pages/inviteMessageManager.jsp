<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/30
  Time: 10:53
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
            <th>发布时间：</th>
            <th>${sessionScope.ret.rt_time}</th>
        </tr>
        <tr>
            <th>工作岗位：</th>
            <th>${sessionScope.ret.job.j_name}</th>
        </tr>
        <tr>
            <th>招聘人数：</th>
            <th>${sessionScope.ret.rt_number}人</th>
        </tr>
        <tr>
            <th>招聘信息：</th>
            <th>${sessionScope.ret.rt_message}</th>
        </tr>
        <tr>
            <th>工作地点：</th>
            <th>${sessionScope.ret.rt_workingAddress}</th>
        </tr>
        <tr>
            <th>职位要求：</th>
            <th>${sessionScope.ret.rt_requirements}</th>
        </tr>
        <tr>
            <th>工资待遇：</th>
            <th>面议</th>
        </tr>
    </table>

    <a href="returnManage.do">返回</a>
</body>
</html>
