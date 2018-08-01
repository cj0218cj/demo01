<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/31
  Time: 18:05
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
<h3>招人成功，请为其办理入职手续</h3>
<form action="addEmployee.do" method="post">
<table>
    <tr>

        <th>员工姓名：</th>
        <th><input type="text" value="${resume.r_name}" name="e_name">
            <input type="hidden" value="${resume.r_user.u_id}" name="u_id">
        </th>
    </tr>
    <tr>
        <th>初始密码：</th>
        <th><input type="text" name="e_pass"></th>
    </tr>
    <tr>
        <th>联系方式：</th>
        <th><input type="text" name="e_phone" value="${resume.r_phone}" ></th>
    </tr>
    <tr>
        <th>部门：</th>
        <th><input type="text" value="${job.dept.d_name}" >
        <input type="hidden" name="d_id" value="${job.dept.d_id}">
        </th>
    </tr>
    <tr>
        <th>职位：</th>
        <th><input type="text" value="${job.j_name}" >
        <input type="hidden" name="j_id" value="${job.j_id}">
        </th>
    </tr>
    <tr>
        <th>基本薪资：</th>
        <th><input type="number" min="${job.j_basePay}" name="e_salary"></th>
    </tr>
</table>
    <input type="submit" value="提交">
</form>
</body>
</html>
