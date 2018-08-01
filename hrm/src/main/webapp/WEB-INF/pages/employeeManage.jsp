<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/8/1
  Time: 15:51
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
请选择：<br/>
部门：<select id="dept">
    <c:forEach items="${depts}" var="dept">
        <option value="${dept.d_id}">${dept.d_name}</option>
    </c:forEach>
</select>
职位：<select id="job">

</select>
</body>
</html>
