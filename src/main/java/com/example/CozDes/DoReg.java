package com.example.CozDes;

import com.example.CozDes.po.Userbean;
import com.example.CozDes.service.IUserService;
import com.example.CozDes.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DoReg", value = "/DoReg")
public class DoReg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String uname=request.getParameter("user");
        String password=request.getParameter("pass");
        String phone=request.getParameter("phone");
        String ccode=request.getParameter("code");
        String scode=session.getAttribute("checkcode").toString();
        session.setAttribute("user",uname);
        session.setAttribute("pass",password);
        session.setAttribute("phone",phone);
        PrintWriter out=response.getWriter();
        Userbean userbean=null;
        userbean=new Userbean(uname,password,phone);
        IUserService us=new UserService();
        if(ccode.equals(scode)){
            session.setAttribute("checkflag","true");
            if(us.regisUser(userbean)==true) {
                Cookie userphone=new Cookie("userphone",userbean.getPhone());
                Cookie username=new Cookie("username",userbean.getUname());
                userphone.setMaxAge(10*24*60*60);
                username.setMaxAge(10*24*60*60);
                response.addCookie(userphone);
                response.addCookie(username);
                response.sendRedirect("index.jsp");
            }else {
                out.println("<div style=\"height: auto;position: relative;text-align: center;background-color: indianred;color: white;\">注册失败，请检查注册信息是否正确</div>");
                request.getRequestDispatcher("register.jsp").include(request, response);
            }
            out.close();
        }else {
            session.setAttribute("checkflag","false");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
