<%@ page import="com.example.CozDes.po.Goodbean" %>
<%@ page import="com.example.CozDes.service.IGoodService" %>
<%@ page import="com.example.CozDes.service.GoodService" %><%--
  Created by IntelliJ IDEA.
  User: zrc12
  Date: 2020-12-23
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情</title>
    <link rel="stylesheet" href="css/detail.css" type="text/css" />
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
</div>
<%
    IGoodService gs=new GoodService();
    Goodbean good=null;
    good=gs.getGood(request.getParameter("url"));
    pageContext.setAttribute("url",request.getParameter("url"));
    pageContext.setAttribute("name",good.getName());
    pageContext.setAttribute("img",good.getImg());
    pageContext.setAttribute("price",good.getPrice());
    pageContext.setAttribute("stock",good.getStock());
    pageContext.setAttribute("intro",good.getIntro());
%>
<div id="mid">
    <div id="preview">
        <img src="${img}"/>
    </div>
    <div id="summary">
        <div id="name">
            ${name}
        </div>
        <div id="intro">
            ${intro}
        </div>
        <div id="price">
            <div id="pricetag">价格</div>
            <div id="pricenum">¥${price}</div>
        </div>
        <form id="mainform" action="CartServ" method="post" onsubmit="return check()">
            <input name="url" value="${url}" style="visibility: hidden"/>
        <div id="dest">
            配送至
            <select name="dest" name="dest">
                <option value="上海">上海</option>
                <option value="苏州">苏州</option>
                <option value="杭州">杭州</option>
                <option value="宁波">宁波</option>
                <option value="南京">南京</option>
                <option value="扬州">扬州</option>
            </select>
        </div>
        <div id="buynum">
            <input type="text" value="1" id="num" name="num" oninput="value=value.replace(/[^\d]/g,'')">
            <div id="add">+</div>
            <div id="reduce">-</div>
        </div>
        <script>
            var num=document.querySelector("#num")
            var add=document.querySelector("#add")
            var reduce=document.querySelector("#reduce")
            add.onclick=function (){
                if(parseInt(num.value)<${stock}){
                    num.value=parseInt(num.value)+1
                }
            }
            reduce.onclick=function (){
                if(parseInt(num.value)>1){
                    num.value-=1
                }
            }
        </script>
        <div id="addcart">
            <input type="submit" id="btnaddcart" value="加入购物车">
        </div>
        <div id="stock">
            剩余${stock}件
        </div>
        </form>
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
    var form=document.querySelector("#mainform")
    form.onsubmit=function(){
        if(${stock}==0){
            alert("现在没有存货")
            return false
        }else if(parseInt(num.value)>${stock}||parseInt(num.value)<=0){
            alert("购买数不合法")
            return false
        }else{
            return true
        }
    }
</script>
</body>
</html>
