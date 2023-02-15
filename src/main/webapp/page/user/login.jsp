<%--
  Created by IntelliJ IDEA.
  User: liudeyi
  Date: 2023/2/10
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=basePath%>">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/login.css" >
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">用户登录</div>
        <form action="UserServlet?login" method="post">
        <div class="form-wrapper">
            <input type="text" name="username" placeholder="请输入用户名" class="input-item">
            <input type="password" name="password" placeholder="请输入密码" class="input-item">
            <input type="submit"   class="btn" value="login">
            <div name="tsmsg" align="center">${requestScope.tsmsg}</div>
        </div>
            </form>
        <div class="msg">
            Don't have account?
            <a href="page/user/regist.jsp">Sign up</a>
        </div>

    </div>
</div>
</body>
</html>



