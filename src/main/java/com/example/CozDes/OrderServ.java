package com.example.CozDes;

import com.example.CozDes.po.Cartitem;
import com.example.CozDes.service.IOrderService;
import com.example.CozDes.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "OrderServ",value = "/OrderServ")
public class OrderServ extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        List<Cartitem> cart=(List)session.getAttribute("cart");
        Cookie[] cookies=null;
        cookies=request.getCookies();
        String userphone=null;
        IOrderService os=new OrderService();
        for(int i=0;i< cookies.length;i++){
            if(cookies[i].getName().equals("userphone")){
                userphone=cookies[i].getValue();
            }
        }
        String orderid=userphone+new Date().getTime();
        if(cart.size()==0){
            response.sendRedirect("cart.jsp");
        }else{
            os.createOrder(orderid,userphone);
            for (Cartitem c:cart){
                os.insertItem(c,orderid);
            }
            cart.clear();
            session.setAttribute("cart", cart);
            response.sendRedirect("order.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
