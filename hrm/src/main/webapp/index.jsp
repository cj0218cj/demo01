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
            width: 1422px;
            height: 800px;
            background: url("resources/images/1.jpg");
            background-size: contain;
            margin: 0 auto;
            border: 1px solid black;
            position: relative;

        }
        #login{
            background: honeydew;
            width: 400px;
            height: 250px;
            position: absolute;
            left: 400px;top: 380px;
            margin: auto;
            font-size: 30px;

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
    <div id="manager"><a href="managerLogin.do">我是管理员</a></div>
    <h2>Welcome</h2>
    <div id="login">
        <legend>用户登录</legend>
        <form action="login.do?" method="post">
            账号：<input type="text" name="u_name" style="height: 40px"/><br/>
            密码：<input type="password" name="u_pass" style="height: 40px"/><br/>
            <input type="submit" value="登录" style="font-size: 30px">
            <a href="toregister.do">注册</a>

        </form>
        <h3>${error}
        </h3>

    </div>
</div>
</body>
</html>