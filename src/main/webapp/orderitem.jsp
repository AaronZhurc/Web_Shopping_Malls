<%@ page import="com.example.CozDes.service.IOrderService" %>
<%@ page import="com.example.CozDes.service.OrderService" %>
<%@ page import="com.example.CozDes.po.Cartitem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zrc12
  Date: 2020-12-25
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/cart.css" type="text/css" />
</head>
<body>
<div id="head">
    <a href="index.jsp"><img src="img/logo.png" id="logo"></a>
    <div id="search">
        <form action="index.jsp">
            <input type="text" name="gname" id="searcht" placeholder="查询商品">
            <div id="searchbtn">
                <input type="submit" id="searchsub" value="搜索">
            </div>
        </form>
    </div>
</div>
<div id="mid">
    <div id="midc">
<%
    List<Cartitem> cart=new ArrayList<Cartitem>();
    IOrderService os=new OrderService();
    cart=os.queryItem(request.getParameter("id"));
    out.println("<table align=\"center\">\n" +
            "            <tr>\n" +
            "                <th>编号</th>\n" +
            "                <th>商品</th>\n" +
            "                <th>商品单价</th>\n" +
            "                <th>商品数量</th>\n" +
            "                <th>商品总价</th>\n" +
            "                <th>收货地点</th>\n" +
            "            </tr>");
    for (Cartitem c : cart) {
        out.println("<tr>");
        out.println("<td>" + c.getId() + "</td>");
        out.println("<td>" + c.getGood().getName() + "</td>");
        out.println("<td>" + c.getGood().getPrice() + "</td>");
        out.println("<td>" + c.getNum() + "</td>");
        out.println("<td>" + c.getPrice() + "</td>");
        out.println("<td>" + c.getDest() + "</td>");
        out.println("<tr>");
    }
    out.println("</table>");
%>
    <div id="back"><a href="order.jsp">返回上一页</a></div>
    </div>
</div>
<div id="bottom">
    <a href="">联系我们</a>
    |
    <a href="">English</a>
    |
    <a href="">日本語</a>
    |
    <a href="">한국어</a>
    <p>Copyleft 114-514 版权没有</p>
</div>
</body>
</html>
