<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/31
  Time: 10:29
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
<form action="messageUpdate.do" method="post">

    <table>
        <tr>
            <th>发布时间：</th>
            <th><input type="text" value="${rtm.rt_time}" name="rt_time" disabled="disabled">
            <input type="hidden" value="${rtm.rt_id}" name="rt_id">
            </th>
        </tr>
        <tr>
            <th>工作岗位：</th>
            <th><input type="text" value="${rtm.job.j_name}" disabled="disabled">
            <input type="hidden" value="${rtm.job.j_id}" name="j_id">
            </th>
        </tr>
        <tr>
            <th>招聘人数：</th>
            <th><input type="number" value="${rtm.rt_number}" name="rt_number">人</th>
        </tr>
        <tr>
            <th>招聘信息：</th>
            <th><input type="text" value="${rtm.rt_message}" name="rt_message"></th>
        </tr>
        <tr>
            <th>工作地点：</th>
            <th><input type="text" value="${rtm.rt_workingAddress}" name="rt_workingAddress"></th>
        </tr>
        <tr>
            <th>职位要求：</th>
            <th><input type="text" value="${rtm.rt_requirements}" name="rt_requirements"></th>
        </tr>
        <tr>
            <th>工资待遇：</th>
            <th>面议</th>
        </tr>
    </table>

    <input type="submit" value="确认更改">
</form>
</body>
</html>
