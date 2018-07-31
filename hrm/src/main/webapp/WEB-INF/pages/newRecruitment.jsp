<%@ page import="cn.cj.model.Job" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/30
  Time: 13:50
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
<form action="addRecruitment.do" method="post">
    <table>
        <tr>
            <th>招聘职位：</th>
            <th><select name="j_id">
                <%
                    List<Job> jobs= (List<Job>) session.getAttribute("jobs");
                    for (int i=0;i<jobs.size();i++){
                        %>
                <option value="<%=jobs.get(i).getJ_id()%>"><%=jobs.get(i).getJ_name()%></option>
                <%
                    }
                %>

            </select> </th>
        </tr>
        <tr>
            <th>招聘人数:</th>
            <th><input type="number" min="1" name="rt_number"></th>
        </tr>
        <tr>
            <th>招聘信息：</th>
            <th><input type="text" name="rt_message"></th>
        </tr>
        <tr>
            <th>面试地点：</th>
            <th><input type="text" name="rt_workingAddress"></th>
        </tr>
        <tr>
            <th>职位要求：</th>
            <th><input type="text" name="rt_requirements"></th>
        </tr>
        <tr>
            <th><input type="submit" value="确认添加"></th>
        </tr>
    </table>
</form>
</body>
</html>
