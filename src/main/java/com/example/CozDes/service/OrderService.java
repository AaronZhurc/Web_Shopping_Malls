package com.example.CozDes.service;

import com.example.CozDes.dao.IOrderDao;
import com.example.CozDes.dao.OrderDao;
import com.example.CozDes.po.Cartitem;
import com.example.CozDes.po.Orderitem;

import java.util.List;

public class OrderService implements IOrderService{
    private IOrderDao odao;

    public OrderService() {
        odao=new OrderDao();
    }

    @Override
    public boolean insertItem(Cartitem item, String orderid) {
        return odao.insertOrder(item,orderid);
    }

    @Override
    public boolean createOrder(String orderid, String phone) {
        return odao.createOrder(orderid,phone);
    }

    @Override
    public List<Orderitem> queryOrder(String phone) {
        return odao.getAllOrder(phone);
    }

    @Override
    public List<Cartitem> queryItem(String id) {
        return odao.getOrder(id);
    }
}
