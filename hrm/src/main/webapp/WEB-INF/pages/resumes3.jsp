<%@ page import="cn.cj.model.RecruManage" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/31
  Time: 17:33
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
<%
    List<RecruManage> list= (List<RecruManage>) session.getAttribute("resume3");
    int totalPages= (int) session.getAttribute("totalPages");
%>
<%
    for (int i=0;i<list.size();i++){
%>
    <tr>
        <td><%=list.get(i).getRecruitment().getJob().getJ_name()%></td>
        <td><%=list.get(i).getResumes().getR_name()%></td>
        <td>
            <form action="getemployee.do?rm_id=<%=list.get(i).getRm_id()%>" method="post">
                <input type="submit" value="招入">
            </form>

    </tr>
<%
    }
%>
</table>
<a href="meetingResult.do?currentPage=<%=(int)session.getAttribute("page")>1?(int)session.getAttribute("page")-1:1%>">上一页</a>

<%
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="meetingResult.do?currentPage=<%=i%>"><%=i%></a>
<%

    }
%>
<a href="meetingResult.do?currentPage=<%=(int)session.getAttribute("page")<totalPages?(int)session.getAttribute("page")+1:totalPages%>">下一页</a>

</body>
</html>
