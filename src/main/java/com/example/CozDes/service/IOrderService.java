package com.example.CozDes.service;

import com.example.CozDes.po.Cartitem;
import com.example.CozDes.po.Orderitem;

import java.util.List;

public interface IOrderService {
    boolean insertItem(Cartitem item,String orderid);
    boolean createOrder(String orderid,String phone);
    List<Orderitem> queryOrder(String phone);
    List<Cartitem> queryItem(String id);
}
