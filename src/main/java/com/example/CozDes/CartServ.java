package com.example.CozDes;

import com.example.CozDes.po.Cartitem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServ", value = "/CartServ")
public class CartServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String dest=request.getParameter("dest");
        int num=Integer.parseInt(request.getParameter("num"));
        String url=request.getParameter("url");
        Cartitem item=new Cartitem(url,num,dest);
        List<Cartitem> cart=(List)session.getAttribute("cart");
        if(cart==null) {
            cart=new ArrayList<Cartitem>();
            session.setAttribute("cart", cart);
        }
        cart.add(item);
        response.sendRedirect("cart.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
