<%@ page import="cn.cj.model.RecruManage" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/31
  Time: 14:25
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
    List<RecruManage> list= (List<RecruManage>) session.getAttribute("resume0");
    int totalPages= (int) session.getAttribute("totalPages");
%>
<%
    for (int i=0;i<list.size();i++){
%>
    <%=list.get(i).getRecruitment().getJob().getJ_name()%>&nbsp;&nbsp;&nbsp;<a href="lookResumeDetail.do?rm_id=<%=list.get(i).getRm_id()%>"><%=list.get(i).getResumes().getR_name()%></a><br/>

<%
    }
%>
<a href="getResume.do?currentPage=<%=(int)session.getAttribute("page")>1?(int)session.getAttribute("page")-1:1%>">上一页</a>

<%
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="getResume.do?currentPage=<%=i%>"><%=i%></a>
<%

    }
%>
<a href="getResume.do?currentPage=<%=(int)session.getAttribute("page")<totalPages?(int)session.getAttribute("page")+1:totalPages%>">下一页</a>
<h3>${sessionScope.qq}</h3>
<a href="getResumes.do?currentPage=1">已读简历</a>
<a href="returnManage.do">返回</a>
</body>
</html>
