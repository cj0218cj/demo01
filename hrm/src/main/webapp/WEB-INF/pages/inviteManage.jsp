<%@ page import="cn.cj.model.Recruitment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/30
  Time: 09:41
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
<a href="newRecruitment.do" >新建招聘信息</a>
<a href="deleteRecruitment.do?currentPage=1">查看未发布招聘信息</a>
<%
    List<Recruitment> list= (List<Recruitment>) session.getAttribute("allRecuritment");
    int totalPages= (int) session.getAttribute("totalPages");
%>
<%
    for (int i=0;i<list.size();i++){
%>
<form action="updateRecruitment.do?rt_id=<%=list.get(i).getRt_id()%>" method="post">
<a href="getrealRecruitmentmessage.do?rt_id=<%=list.get(i).getRt_id()%>"><%=list.get(i).getJob().getJ_name()%></a>
<input type="submit" value="撤回">
</form>
<br/>

<%
    }
%>
<a href="returnManage.do">返回</a>
<a href="inviteManage.do?currentPage=<%=(int)session.getAttribute("page")>1?(int)session.getAttribute("page")-1:1%>">上一页</a>

<%
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="inviteManage.do?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<a href="inviteManage.do?currentPage=<%=(int)session.getAttribute("page")<totalPages?(int)session.getAttribute("page")+1:totalPages%>">下一页</a>

</body>
</html>
