<%@ page import="com.example.CozDes.service.IGoodService" %>
<%@ page import="com.example.CozDes.service.GoodService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.CozDes.po.Goodbean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="css/index.css" type="text/css" />
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
    <div id="shopcart">
        <a href="cart.jsp">我的购物车</a>
    </div>
    <div id="menu">
        <a href="">东方</a>
        <a href="">苏联</a>
        <a href="">罗马</a>
        <a href="">二次元</a>
        <a href="">致远星</a>
    </div>
    <div class="userbanner" id="login">
        <div><a href="login.jsp">登录</a></div>
        <div>&nbsp|&nbsp</div>
        <div><a href="register.jsp">注册</a></div>
    </div>
    <div class="userbanner" id="welcome">
        <div id="weluser"></div>
        <div>&nbsp|&nbsp</div>
        <div><a href="order.jsp">查看订单</a></div>
        <div>&nbsp|&nbsp</div>
        <div id="exit">退出</div>
    </div>
    <script>
        var login=document.querySelector("#login")
        var welcome=document.querySelector("#welcome")
        var weluser=document.querySelector("#weluser")
        var uname
        if(document.cookie==null||document.cookie=="") {
            login.style.visibility = "visible"
            welcome.style.visibility = "hidden"
        }else{
            login.style.visibility = "hidden"
            var cookies = document.cookie.split("; ");
            for ( var i = 0; i < cookies.length; i++) {
                var c = cookies[i].split("=");
                if (c[0] == 'username'){
                    uname=c[1]
                }
            }
            weluser.innerHTML="欢迎您,"+uname
            welcome.style.visibility = "visible"
        }
        var btnexit=document.querySelector("#exit")
        btnexit.onclick=function (){
            var date = new Date()
            date.setTime(date.getTime() - 10000)
            document.cookie = "username" + "=a; expires=" + date.toGMTString()
            document.cookie = "userphone" + "=a; expires=" + date.toGMTString()
            location.reload()
        }
    </script>
</div>
<div id="mid">
    <div id="side">
        <div>
            <a href="">客服</a>
        </div>
        <div>
            <a href="">反馈</a>
        </div>
        <div id="totop">
            顶部
        </div>
    </div>
    <script>
        var totop=document.querySelector("#totop")
        totop.onclick=function(){
            document.body.scrollTop = 0;
            document.documentElement.scrollTop = 0;
        }
    </script>
    <div id="inner">
        <%
            IGoodService gs=new GoodService();
            List<Goodbean> goods=new ArrayList<Goodbean>();
            if(request.getParameter("gname")==null) {
                goods = gs.getAllGoods();
            }else{
                goods = gs.getAllGoods(request.getParameter("gname").toString());
            }
            for(Goodbean good:goods){
                out.println("<div class=\"goods\">");
                out.println(" <a class=\"gooda\" href=\"detail.jsp?url="+good.getUrl()+"\">");
                out.println("<div class=\"gooddiv\">");
                out.println("<img src=\""+good.getImg()+"\" class=\"goodimg\">");
                out.println("</div>");
                out.println("<div class=\"goodname\">"+good.getName()+"</div>");
                out.println("<div class=\"goodprice\">¥"+good.getPrice()+"</div>");
                out.println("</a>");
                out.println("</div>");
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
</body>
</html>