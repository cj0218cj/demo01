<%@ page import="cn.cj.model.Resumes" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/27
  Time: 16:09
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
<p>请选择需要查看的简历</p>
<%
    List<Resumes> list= (List<Resumes>) session.getAttribute("resumesList");
%>
<%
    for (int i=0;i<list.size();i++){
        %>

<a href="lookResume.do?r_id=<%=list.get(i).getR_id()%>">我的简历<%=i+1%></a><br/>
<%
    }
%>
<a href="returnback.do">返回</a>

</body>
</html>
