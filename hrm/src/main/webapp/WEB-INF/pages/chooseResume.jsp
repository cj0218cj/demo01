<%@ page import="cn.cj.model.Resumes" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/29
  Time: 10:08
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
<form action="confirm.do" method="post">
    <%
        List<Resumes> list= (List<Resumes>) session.getAttribute("resumes");
    %>
    <%
        if (list.size()==0){
            %>
    <p>您还没有简历，请先去<a href="addResume.do">新建</a>一份简历</p>
    <%
        }else {
            for (int i=0;i<list.size();i++){
                %>
    <input type="radio" value="<%=list.get(i).getR_id()%>" name="r_id">我的简历<%=i+1%><br/>
    <%
            }
        }
    %>
    <input type="submit" value="投递">
</form>
</body>
</html>
