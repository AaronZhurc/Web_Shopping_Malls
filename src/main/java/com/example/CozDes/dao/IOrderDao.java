package com.example.CozDes.dao;

import com.example.CozDes.po.Cartitem;
import com.example.CozDes.po.Orderitem;

import java.util.List;

public interface IOrderDao {
    public boolean insertOrder(Cartitem item, String orderid);
    public boolean createOrder(String orderid,String phone);
    public List<Orderitem> getAllOrder(String phone);
    public List<Cartitem> getOrder(String id);
}
