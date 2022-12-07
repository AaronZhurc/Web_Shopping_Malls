<%@ page import="com.example.CozDes.po.Cartitem" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zrc12
  Date: 2020-12-24
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的购物车</title>
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
                double total=0;
                List<Cartitem> cart=(List)session.getAttribute("cart");
                if(cart==null||cart.size()==0){
                    out.println("<div id=\"midn\">亲，购物车里没商品的</div>");
                }else {
                    out.println("<table align=\"center\">\n" +
                            "            <tr>\n" +
                            "                <th>编号</th>\n" +
                            "                <th>商品</th>\n" +
                            "                <th>商品单价</th>\n" +
                            "                <th>商品数量</th>\n" +
                            "                <th>商品总价</th>\n" +
                            "                <th>收货地点</th>\n" +
                            "                <th>操作</th>\n" +
                            "            </tr>");
                    if (request.getParameter("del") != null) {
                        String iddel = request.getParameter("del").toString();
                        Cartitem del=null;
                        for (Cartitem c : cart) {
                            if (c.getId().equals(iddel)) {
                                del=c;
                            }
                        }
                        cart.remove(del);
                        session.setAttribute("cart", cart);
                    }
                        for (Cartitem c : cart) {
                            out.println("<tr>");
                            out.println("<td>" + c.getId() + "</td>");
                            out.println("<td>" + c.getGood().getName() + "</td>");
                            out.println("<td>" + c.getGood().getPrice() + "</td>");
                            out.println("<td>" + c.getNum() + "</td>");
                            out.println("<td>" + c.getPrice() + "</td>");
                            out.println("<td>" + c.getDest() + "</td>");
                            out.println("<td class='del' style='cursor:pointer'>删除</td>");
                            out.println("<tr>");
                            total += c.getPrice();
                        }
                    out.println("</table>" +
                            "        <div id=\"price\">总计¥"+total+"</div>\n" +
                            "        <div id=\"buy\">结算</div>");
                    }
            %>
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
<script>
    var del=document.querySelectorAll(".del")
    for(var i=0;i<del.length;i++){
        del[i].onclick=function(){
            var row=this.parentElement.rowIndex;
            location="cart.jsp?del="+document.querySelector("table").rows[row].cells[0].innerHTML;
        }
    }
    var buy=document.querySelector("#buy")
    buy.onclick=function (){
        if(document.cookie==null||document.cookie=="") {
            location="login.jsp"
        }else {
            location="OrderServ"
        }
    }
</script>
</body>
</html>
