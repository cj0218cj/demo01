<%--
  Created by IntelliJ IDEA.
  User: cj
  Date: 2018/6/21
  Time: 19:45
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
        #big{
            width: 1422px;
            height: 800px;
            background: url("../../resources/images/1.jpg");
            background-size: contain;
            margin: 0 auto;
            border: 1px solid black;
            position: relative;
        }
        #register{
            background: honeydew;
            width: 450px;
            height: 300px;
            position: absolute;
            left: 100px;top: 400px;
            margin: auto;
            font-size: 40px;
        }
    </style>
    <script>
        function checkName() {
            var xmlHttp=new XMLHttpRequest();
            xmlHttp.open("GET","check?name="+document.getElementById("user").value,true);
            xmlHttp.send();
            xmlHttp.onreadystatechange=function () {
                if (xmlHttp.readyState==4&&xmlHttp.status==200){
                    document.getElementById("name").innerHTML=xmlHttp.responseText;
                }
            }
        }
    </script>
</head>
<body>
<div id="big">
    <h3>欢迎注册^-^</h3>
    <div id="register">
        <legend>用户注册</legend>
        <form action="register.do" method="post">
            账号：<input  type="text" id="user" name="u_name" style="height: 40px" onblur="checkName()"/><span id="name"></span><br/>
            密码：<input type="password" id="pwd" style="height: 40px" name="u_pass"/><span id="spwd"></span><br/>
            <%--确认密码：<input type="password" id="rpwd" name="pass"/><span id="srpwd"></span><br/>--%>

            <input type="submit" value="注册" style="font-size: 30px">
            <a href="back.do">登录</a>
        </form>
        <span style="font-size: 20px">${error}</span>
    </div>
</div>

</body>
</html>
