<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/31
  Time: 23:22
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
    <style>
        #big{
            width: 1000px;
            height: 600px;
            background-size: contain;
            margin: 0 auto;
            border: 1px solid black;
            position: relative;
        }
        #left{
            margin: 0px;
            padding: 0px;
            width: 800px;
            height: 600px;
            float: left;
        }
        /*#right{*/
            /*margin: 0px;*/
            /*padding: 0px;*/
            /*width: 500px;*/
            /*height: 600px;*/
            /*float: left;*/
        /*}*/
        table{
            border-collapse:separate;
            border-spacing: 20px;
        }
    </style>
</head>
<body>
<div id="big">
    <div id="left">
        <table >
            <tr>
                <th><h2>部门</h2></th>
            </tr>
            <tr>
                <th><a href="addDept.do">增加部门</a> </th>
            </tr>
            <c:forEach items="${depts}" var="dept">
                <tr>
                    <td>${dept.d_name}</td>
                    <td>创建时间：${dept.d_date}</td>
                    <td><a href="updateDept.do?d_id=${dept.d_id}">修改</a></td>
                    <td><a href="deleteDept.do?d_id=${dept.d_id}">删除</a> </td>
                    <td><a href="getJob.do?d_id=${dept.d_id}&currentPage=1">查看职位</a> </td>
                    <td><a href="getEmployeeByDept.do?d_id=${dept.d_id}&currentPage=1">查看员工</a> </td>
                </tr>
            </c:forEach>
        </table>
        <a href="deptManage.do?currentPage=${page>1?page-1:1}">上一页</a>

        <%
            int totalPages= (int) request.getAttribute("totalPages");
            for (int i = 1; i <=totalPages; i++) {
        %>
        <a href="deptManage.do?currentPage=<%=i%>"><%=i%></a>
        <%
            }
        %>
        <a href="deptManage.do?currentPage=${page<totalPages?page+1:totalPages}">下一页</a>
<h3>${error}</h3>
    </div>
    <%--<div id="right">--%>
        <%--<table>--%>
            <%--<tr>--%>
                <%--<th><h2>职位</h2></th>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th><a href="">增加职位</a> </th>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th><a href="">修改职位</a> </th>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<th><a href="">删除职位</a> </th>--%>
            <%--</tr>--%>
        <%--</table>--%>
    <%--</div>--%>
</div>
</body>
</html>
