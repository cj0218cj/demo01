<%@ page import="cn.cj.model.RecruManage" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/31
  Time: 17:06
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
    List<RecruManage> list= (List<RecruManage>) session.getAttribute("resume2");
    int totalPages= (int) session.getAttribute("totalPages");
%>
<%
    if (list.size()==0){
%>
<p>您还未收到Offer，请<a href="returnback.do">返回</a>去投递简历吧 </p>
<%
}else{
    for (int i=0;i<list.size();i++){
%>
<p><%=list.get(i).getRecruitment().getJob().getJ_name()%></p>
<%
        }
    }
%>
<a href="returnback.do">返回</a>
</body>
</html>
