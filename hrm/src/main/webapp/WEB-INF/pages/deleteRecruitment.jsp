<%@ page import="cn.cj.model.Recruitment" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/30
  Time: 15:20
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
    List<Recruitment> list= (List<Recruitment>) session.getAttribute("allRecuritmentde");
    int totalPages= (int) session.getAttribute("totalPages");
%>
<%
    for (int i=0;i<list.size();i++){
%>
<span>职位：<%=list.get(i).getJob().getJ_name()%>&nbsp;&nbsp;&nbsp;
        人数：<%=list.get(i).getRt_number()%>&nbsp;&nbsp;&nbsp;
    发布时间：<%=list.get(i).getRt_time()%>

</span>
<form action="updateInviteMessage.do?rt_id=<%=list.get(i).getRt_id()%>" method="post">
    <input type="submit" value="修改信息">
</form>
<form action="recruitmentDelete.do?rt_id=<%=list.get(i).getRt_id()%>" method="post">
    <input type="submit" value="删除">
</form>
<form action="updateState.do?rt_id=<%=list.get(i).getRt_id()%>" method="post">
    <input type="submit" value="再发布">
</form>
<%
    }
%>
<a href="returnManage.do">返回</a>
<a href="deleteRecruitment.do?currentPage=<%=(int)session.getAttribute("page")>1?(int)session.getAttribute("page")-1:1%>">上一页</a>

<%
    for (int i = 1; i <=totalPages; i++) {
%>
<a href="deleteRecruitment.do?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
<a href="deleteRecruitment.do?currentPage=<%=(int)session.getAttribute("page")<totalPages?(int)session.getAttribute("page")+1:totalPages%>">下一页</a>

</body>
</html>
