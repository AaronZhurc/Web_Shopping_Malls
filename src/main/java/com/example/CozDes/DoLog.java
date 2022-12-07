package com.example.CozDes;

import com.example.CozDes.po.Userbean;
import com.example.CozDes.service.IUserService;
import com.example.CozDes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoLog", value = "/DoLog")
public class DoLog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String phone=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(request);
        IUserService us=new UserService();
        Userbean userbean=us.checkUser(phone, password);
        if(userbean!=null) {
            session.setAttribute("logflag","true");
            Cookie userphone=new Cookie("userphone",userbean.getPhone());
            Cookie username=new Cookie("username",userbean.getUname());
            userphone.setMaxAge(10*24*60*60);
            username.setMaxAge(10*24*60*60);
            response.addCookie(userphone);
            response.addCookie(username);
            response.sendRedirect("index.jsp");
        }else {
            session.setAttribute("logflag","false");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
