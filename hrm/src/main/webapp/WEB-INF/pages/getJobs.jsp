<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/8/1
  Time: 09:43
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
<table >
    <h2>${dept.d_name}</h2>
    <a href="addJob.do?d_id=${dept.d_id}">增加职位</a>
    <tr>
        <th>职位名称</th>
        <th>最低薪资</th>
        <th>修改</th>
        <th>删除</th>
        <th>查看</th>
    </tr>

    <c:forEach items="${deptJobs}" var="job">
        <tr>
            <td>${job.j_name}</td>
            <td>${job.j_basePay}</td>
            <td><a href="updateJob.do?d_id=${dept.d_id}&j_id=${job.j_id}">修改</a></td>
            <td><a href="deleteJob.do?d_id=${dept.d_id}&j_id=${job.j_id}">删除</a> </td>
            <td><a href="getEmployeeByJob.do?currentPage=1&j_id=${job.j_id}">查看员工</a> </td>

        </tr>
    </c:forEach>
</table>
<a href="getJob.do?d_id=${dept.d_id}&currentPage=${page>1?page-1:1}">上一页</a>

<%
    int totalPages= (int) request.getAttribute("totalPages");
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="getJob.do?d_id=${dept.d_id}&currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<a href="getJob.do?d_id=${dept.d_id}&currentPage=${page<totalPages?page+1:totalPages}">下一页</a>
</body>
</html>
