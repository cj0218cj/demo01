<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/7/30
  Time: 01:24
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
        #title {
            width: 1000px;
            height: 100px;

            margin: auto;
            font-size: 40px;

        }
        #div1{
            margin: 0px;
            padding: 0px;
            width: 1000px;
            height: 30px;

        }
        #div2{
            margin: 0px;
            padding: 0px;
            width: 1000px;
            height: 30px;
        }
        #big ul{
            list-style: none;
            margin: 0px;
            padding: 0px;
        }
        #big li{
              float: left;
              text-align: center;
              margin:0px  80px;
          }
    </style>
</head>
<body>
<div id="big">
    <div id="title">
        <h3>欢迎使用本软件^-^</h3>
    </div>
<div id="div1">
    <ul>

        <li><a href="">发布招聘</a></li>
        <li><a href="">查看简历</a></li>
        <li><a href="">面试结果</a></li>
        <li><a href="">员工管理</a></li>
    </ul>
</div>
<div id="div2">
    <ul>

        <li><a href="">部门管理</a></li>
        <li><a href="">薪资管理</a></li>
        <li><a href="">考勤管理</a></li>
        <li><a href="">培训管理</a></li>
    </ul>
</div>
</div>
</body>
</html>
