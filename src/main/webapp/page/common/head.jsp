<%--
  Created by IntelliJ IDEA.
  User: liudeyi
  Date: 2023/2/10
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basepath=request.getScheme()
    +"://"+request.getServerName()
            +":"
    +request.getServerPort()
    +request.getContextPath()
    +"/";
    pageContext.setAttribute("basepath",basepath);
%>
<base href="<%=basepath%> ">
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

