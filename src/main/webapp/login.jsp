<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<link rel="stylesheet" href="css/login.css" type="text/css" />
</head>
<body>
<div id="head">
    <a href="index.jsp"><img src="img/logo.png" id="logo"></a>
        <img src="img/l-icon.png" id="licon">
        <a href="" id="quest"><img src="img/q-icon.png" id="qlogo">登录页面，调查问卷</a>
    </div>
    <div id="warn">
        <p class="warnw"><img src="img/tips.png" id="tipslogo">依据《网络安全法》，为保障您的账户安全和正常使用，请尽快完成手机号验证！ 新版
            <a href="" class="warnw">《大秦隐私政策》</a>
            已上线，将更有利于保护您的个人隐私。
        </p>
    </div>
    <div id="mid">
        <img src="img/bg.jpg">
        <div id="loginbox">
            <div id="lwarn">
                大秦不会以任何理由要求您转账汇款，谨防诈骗。
            </div>
            <div id="btnqrlogin" class="slogin">
                扫码登录
            </div>
            <div id="btnalogin" class="slogin">
                账户登录
            </div>
            <div id="lmid">
                <div id="qrlogin" style="visibility: hidden;">
                    <div><img src="img/QRcode.jpg" height="150px" width="150px"></div>
                    <div id="qrloginb">打开<a href="">手机大秦</a> 扫描二维码 </div>
                </div>
                <div id="alogin">
                <form action="DoLog" method="post">
                    <div>
                        <div id="dusername">
                            <div id="pusername"></div>
                            <input type="text" name="username" placeholder="唯一指定手机" class="input" id="text">
                        </div>
                        <div id="dpassword">
                            <div id="ppassword"></div>
                            <input type="password" name="password" placeholder="密码" class="input" id="pass">
                        </div>
                    </div>
                    <a href="" id="forgot">忘记密码</a>
                    <div id="warn2"></div>
                    <div id="loginb">
                        <input type="submit" value="登录">
                    </div>
                    </form>
                </div>
            </div>
            <script>
                var btnqrlogin=document.querySelector("#btnqrlogin")
                var btnalogin=document.querySelector("#btnalogin")
                var qrlogin=document.querySelector("#qrlogin")
                var alogin=document.querySelector("#alogin")
                var warn2=document.querySelector("#warn2")
                btnqrlogin.onclick=function(){
                    alogin.style.visibility="hidden"
                    qrlogin.style.visibility="visible"
                }
                btnalogin.onclick=function(){
                    qrlogin.style.visibility="hidden"
                    alogin.style.visibility="visible"
                }
                window.onload=function (){
                    <%if(session.getAttribute("logflag")!=null){
                        if(session.getAttribute("logflag")=="false"){%>
                            warn2.innerHTML="<p style='color:orangered'>手机号或密码错误</p>"
                        <%}else{%>
                            warn2.innerHTML=""
                        <%}
                    }%>
                }
            </script>
            <div id="lbottom">
                <div id="lb">
                    <a href="https://www.acfun.cn" class="lbl">bilibili</a>
                </div>
                <a href="register.jsp" id="regis">立即注册</a>
            </div>
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