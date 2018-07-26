<%@ page import="cn.cj.model.Recruitment" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/25
  Time: 23:51
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
<%
    Recruitment rt= (Recruitment) session.getAttribute("ret");
%>
<table>
    <tr>
        <th>发布时间：</th>
        <th><%=rt.getRt_time()%></th>
    </tr>
    <tr>
        <th>工作岗位：</th>
        <th><%=rt.getJob().getJ_name()%></th>
    </tr>
    <tr>
        <th>招聘人数：</th>
        <th><%=rt.getRt_number()%>人</th>
    </tr>
    <tr>
        <th>招聘信息：</th>
        <th><%=rt.getRt_message()%></th>
    </tr>
    <tr>
        <th>工作地点：</th>
        <th><%=rt.getRt_workingAddress()%></th>
    </tr>
    <tr>
        <th>职位要求：</th>
        <th><%=rt.getRt_requirements()%></th>
    </tr>
    <tr>
        <th>工资待遇：</th>
        <th>面议</th>
    </tr>
</table>
<form action="" method="post">
    <input type="submit" value="申请职位">
</form>
</body>
</html>
