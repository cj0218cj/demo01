<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/6/29
  Time: 13:58
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
    <style type="text/css">
        #div{
            width: 1200px;
            height: 800px;
            background: url("../../resources/images/1.jpg");
            background-size: contain;
            margin: 0 auto;
            border: 1px solid black;
            position: relative;

        }
        #login{
            background:#c4d4e3;
            width: 450px;
            height: 250px;
            position: absolute;
            left: 400px;top: 380px;
            margin: auto;
            font-size: 40px;
            text-align: center;

        }
        #manager{
            width: 100px;
            height: 40px;
            position: absolute;
            left: 1200px;
            top: 40px;
        }
        #manager a{
            color: blanchedalmond;
        }
    </style>
</head>
<body>
<div id="div">

    <div id="login">
        <legend>管理员登录</legend>
        <form action="managerLoginin.do" method="post">
            账号：<input type="text" name="m_name" style="height: 40px"/><br/>
            密码：<input type="password" name="m_pass" style="height: 40px"/><br/>
            <input type="submit" value="登录" style="font-size: 30px">
            <a href="back.do">返回</a>
        </form>
        <h3>${error}</h3>


    </div>
</div>
</body>
</html>
