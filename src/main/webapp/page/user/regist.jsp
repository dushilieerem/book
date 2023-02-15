<%--
  Created by IntelliJ IDEA.
  User: liudeyi
  Date: 2023/2/13
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <link rel="stylesheet" href="css/regist.css">
</head>
<body>
<div class="rg_layout">
    <div class="rg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
    </div>
    <div class="rg_center">
        <div class="rg_form">
            <form action="/mybook/UserServlet?action=regist" method="post">
                <table>
                    <tr><!--label 标签的作用是当点击文字也会跳到文本输出框-->
                        <!--for属性与ID属性对应规定 label 绑定到哪个表单元素。-->
                        <td class="td_left"><label for="username">用户名</label> </td>
                        <td class="td_right"><input type="text" name="username" id="username"> </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="password">密码</label> </td>
                        <td class="td_right"><input type="password" name="password" id="password"> </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label for="confirmpassword">确认密码</label> </td>
                        <td class="td_right"><input type="password" name="confirmpassword" id="confirmpassword"> </td>
                    </tr>


                    <tr>
                        <td class="td_left"><label for="email">email</label> </td>
                        <td class="td_right"><input type="text" name="email" id="email"> </td>
                    </tr>

                    <tr>
                        <td class="td_left"><label>验证码</label> </td>
                        <td class="td_right">
                            <input type="text" name="yzm" id="yzm">
                            <input type="button"value="发送验证码">
                            <!--                            <img src="images/verify_code.jpg" id="img_check">-->
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="注册" id="btn_sub">
                        </td>
                    </tr>

                </table>
            </form>
        </div>
    </div>
    <div class="rg_right">
        <p>已有账号？<a href="page/user/login.jsp">立即登录</a></p>
    </div>
</div>
</body>
</html>
