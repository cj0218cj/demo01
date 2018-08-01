<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/8/1
  Time: 14:28
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
        <th>员工姓名</th>
        <th>联系电话</th>
        <th>所属部门</th>
        <th>职位</th>
        <th>基本薪资</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.e_name}</td>
            <td>${employee.e_phone}</td>
            <td>${employee.dept.d_name}</td>
            <td>${employee.job.j_name}</td>
            <td>${employee.e_salary}</td>
        </tr>
    </c:forEach>
    <tr><td><a href="returnManage.do">返回</a></td></tr>
</table>
<a href="getEmployeeByJob.do?currentPage=${page>1?page-1:1}&j_id=${jobId}">上一页</a>

<%
    int totalPages= (int) request.getAttribute("totalPages");
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="getEmployeeByJob.do?j_id=${jobId}&currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<a href="getEmployeeByDept.do?d_id=${deptId}&currentPage=${page<totalPages?page+1:totalPages}">下一页</a>
</body>
</html>
