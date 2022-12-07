<%@ page import="com.example.CozDes.service.IOrderService" %>
<%@ page import="com.example.CozDes.service.OrderService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.CozDes.po.Orderitem" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: zrc12
  Date: 2020-12-25
  Time: 12:21
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
    <%
        List<Orderitem> orders=new ArrayList<Orderitem>();
        String userphone=null;
        IOrderService os=new OrderService();
        Cookie[] cookies=request.getCookies();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(int i=0;i< cookies.length;i++){
            if(cookies[i].getName().equals("userphone")){
                userphone=cookies[i].getValue();
            }
        }
        orders=os.queryOrder(userphone);
        if(orders==null||orders.size()==0){
            out.println("<div id=\"midn\">亲，购物车里没商品的</div>");
        }else {
            out.println("<table align=\"center\">\n" +
                    "            <tr>\n" +
                    "                <th>订单编号</th>\n" +
                    "                <th>创建日期</th>\n" +
                    "                <th>订单状态</th>\n" +
                    "                <th>操作</th>\n" +
                    "            </tr>");
            for (Orderitem o : orders) {
                out.println("<tr>");
                out.println("<td>" + o.getOrderid() + "</td>");
                out.println("<td>" + sdf.format(o.getDate()) + "</td>");
                out.println("<td>" + o.getStatus() + "</td>");
                out.println("<td class='query' style='cursor:pointer'>查看</td>");
                out.println("<tr>");
            }
            out.println("</table>");
        }
    %>
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
    var query=document.querySelectorAll(".query")
    for(var i=0;i<query.length;i++){
        query[i].onclick=function(){
            var row=this.parentElement.rowIndex;
            location="orderitem.jsp?id="+document.querySelector("table").rows[row].cells[0].innerHTML;
        }
    }
</script>
</body>
</html>
