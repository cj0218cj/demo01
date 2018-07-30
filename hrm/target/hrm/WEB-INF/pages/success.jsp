<%@ page import="cn.cj.model.Recruitment" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/25
  Time: 14:54
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
        #all{
            width: 1000px;
            height: 600px;
            background-color: pink;
            background-size: contain;
            margin: 0 auto;
            border: 1px solid black;
            position: relative;
        }
        #title{
            width: 1000px;
            height: 100px;
            background: url("../../resources/images/title.jpg");
            margin: auto;
            font-size: 40px;
            font-family: 华文行楷;
        }
        #personal{
            margin: 0px;
            padding: 0px;
            width: 1000px;
            height: 30px;
            background-color: blanchedalmond;

        }
        #personal ul{
            list-style: none;
            margin: 0px;
            padding: 0px;
        }
        #personal li{
            float: left;
            text-align: center;
            margin:0px  80px;
        }
        #left{
            width: 300px;
            height: 450px;
            float: left;
            background-color: royalblue;
        }
        #content{
            width: 400px;
            height: 450px;
            float: left;
            background-color: hotpink;
        }
        #right{
            width: 300px;
            height: 450px;
            float: left;
            background-image: url("../../resources/images/产品.png");
            background-color: yellowgreen;
        }
        #foot{
            font-size: 15px;
            text-align: center;
        }
    </style>
</head>
<body>
<div id="all">
<div id="title">
    <span>欢迎来到XX公司</span>

</div>
<div id="personal">
    <ul>

        <li><a href="updatePass.do">修改密码</a></li>
        <li><a href="lookResumes.do">查看个人简历</a></li>
        <li><a href="addResume.do">新建简历</a></li>
        <li><a href="getinvite.do">面试邀请</a></li>
    </ul>
</div>
    <div id="left">
        <ul style="list-style: none"><span style="font-size: 30px">公司简介</span>
            <li style="margin-bottom: 25px"><a href="https://www.baidu.com">公司文化</a></li>
            <li style="margin-bottom: 25px"><a href="https://www.baidu.com">业务范围</a></li>
            <li style="margin-bottom: 25px"><a href="https://www.baidu.com">企业团队</a></li>
            <li style="margin-bottom: 25px"><a href="https://www.baidu.com">合作伙伴</a></li>
        </ul>
    </div>
<div id="content">
    <h2 style="font-family: 楷体">诚聘：</h2>
    <%
        List<Recruitment> list= (List<Recruitment>) session.getAttribute("allRecuritment");
        int totalPages= (int) session.getAttribute("totalPages");
    %>
    <%
        for (int i=0;i<list.size();i++){
    %>
    <a href="getrealRecruitment.do?rt_id=<%=list.get(i).getRt_id()%>"><%=list.get(i).getJob().getJ_name()%></a><br/>

    <%
        }
    %>
    <a href="success.do?currentPage=<%=(int)session.getAttribute("page")>1?(int)session.getAttribute("page")-1:1%>">上一页</a>

    <%
        for (int i = 1; i <=totalPages; i++) {
    %>
    <a href="success.do?currentPage=<%=i%>"><%=i%></a>
    <%
        }
    %>
    <a href="success.do?currentPage=<%=(int)session.getAttribute("page")<totalPages?(int)session.getAttribute("page")+1:totalPages%>">下一页</a>

</div>
    <div id="right">

    </div>
    <div id="foot">艾萨克 ©版权所有 demo@demo.com</div>
</div>
</body>
</html>
