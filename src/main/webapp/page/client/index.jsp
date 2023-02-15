<%--
  Created by IntelliJ IDEA.
  User: liudeyi
  Date: 2023/2/13
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/page/common/head.jsp"%>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="/img/logo.gif" >
    <span class="wel_word">网上书城</span>
    <div>
        <c:if test="${empty sessionScope.user}">
            <a href="page/user/login.jsp">登录</a> |
            <a href="page/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span >欢迎<span class="um_span">${sessionScope.user.username}</span> </span>
            <a href="jsp/order/order.jsp">我的订单</a>
            <a href="UserServlet?action=logout">注销</a>&nbsp;&nbsp;&nbsp;
        </c:if>
    </div>
</div>
<div id="main">
    <div id="book">
        <div id="book_cond">
            <form action="ClientBookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input type="text" id="min" name="min" value="${param.min}">元-
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <div>
                    <span style="color: red" id="cartLastName">当前购物车为空</span>
                </div>
            </c:if>
           <c:if test="${empty sessionScope.cart.items}">
               <span id="cartTotalCount">您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
               <div>
                   您刚刚将<span style="color: red" id="cartLastName">${sessionScope.lastName}</span>加入到了购物车中
               </div>
           </c:if>

        </div>
        <c:forEach items="${sessionScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img src="${book.imgPath}" class="book_img" alt="">
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">￥${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>

            </div>
        </c:forEach>
        </div>
    <%@include file="/page/common/page_nav.jsp"%>

</div>
<%@include file="/page/common/footer.jsp"%>
</body>
</html>
