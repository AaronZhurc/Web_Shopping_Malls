<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="css/register.css" type="text/css" />
</head>
<body>
    <div id="head">
        <a href="index.jsp"><img src="img/logo.png" id="logo"></a>
        <p id="licon">用户注册</p>
        <p id="has">已有账号？<a href="login.jsp">请登录></a></p>
    </div>
    <div id="mid">
    <form action="DoReg" method="post" onsubmit="return check()">
        <div id="phone" class="input">
            <p>中国 +86</p>
            <input type="text" name="phone" id="iphone" placeholder="请填写常用手机号，也是您的登陆账户">
        </div>
        <div id="warn1" class="warn"></div>
        <div id="user" class="input">
            <p>用户名</p>
            <input type="text" name="user" id="iuser" placeholder="您的用户名">
        </div>
        <div id="warn4" class="warn"></div>
        <div id="pass" class="input">
            <p>设置密码</p>
            <input type="password" name="pass" id="ipass" placeholder="两种及两种以上字符组合,长度8-16">
        </div>
        <div id="warn2" class="warn"></div>
        <div id="pass2" class="input">
            <p>再输入密码</p>
            <input type="password" name="pass2" id="ipass2" placeholder="请再输入一次密码">
        </div>
        <div id="warn3" class="warn"></div>
        <div id="code" class="input">
            <p>验证码</p>
            <input type="text" name="code" id="icode" placeholder="输入验证码">
            <div id="ccode"><img src="CheckServ"></div>
        </div>
        <div id="warn5" class="warn"></div>
        <div id="check">
            <input type="checkbox" name="check" id="icheck">
            我已阅读并同意<a href="">《大秦用户注册协议》</a>
        </div>
        <div id="regis">
            <input type="submit" id="btnregis" value="注册">
        </div>
    </form>
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
    <script type="text/javascript" src="js/register.js"></script>
    <script>
        window.onload=function (){
            <%if(session.getAttribute("user")!=null){%>
                txt4.value = '<%=session.getAttribute("user")%>'
            <%}
            if(session.getAttribute("pass")!=null) {%>
                txt2.value = '<%=session.getAttribute("pass")%>'
                txt3.value = '<%=session.getAttribute("pass")%>'
            <%}
            if(session.getAttribute("phone")!=null) {%>
                txt1.value = '<%=session.getAttribute("phone")%>'
            <%}
            if(session.getAttribute("checkflag")!=null){
                if(session.getAttribute("checkflag").equals("false")) {%>
                    sp5.innerHTML = "<p style='color:orangered'>验证码错误</p>"
                    sp5.style.visibility = "visible"
                <%}
            }%>
        }
    </script>
</body>
</html>