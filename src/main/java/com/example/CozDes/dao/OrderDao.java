package com.example.CozDes.dao;

import com.example.CozDes.po.Cartitem;
import com.example.CozDes.po.Goodbean;
import com.example.CozDes.po.Orderitem;
import com.example.CozDes.util.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao implements IOrderDao{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public boolean insertOrder(Cartitem item, String orderid) {
        String sql="insert into cozorderi(id,gid,oid,uprice,num,tprice,dest) values(?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        try {
            conn=DButil.getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, item.getId());
            ps.setString(2, String.valueOf(item.getGood().getId()));
            ps.setString(3, orderid);
            ps.setString(4, String.valueOf(item.getPrice()));
            ps.setString(5,String.valueOf(item.getNum()));
            ps.setString(6,String.valueOf(item.getPrice()*item.getNum()));
            ps.setString(7,item.getDest());
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ps.close();
                DButil.closeAll(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }

    @Override
    public boolean createOrder(String orderid, String phone) {
        String sql="insert into cozorder(id,phone,odate,status) values(?,?,?,'已下单')";
        PreparedStatement ps=null;
        try {
            conn=DButil.getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, orderid);
            ps.setString(2, phone);
            ps.setTimestamp(3,new Timestamp(new Date().getTime()));
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                ps.close();
                DButil.closeAll(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
            return true;
        }
    }

    @Override
    public List<Orderitem> getAllOrder(String phone) {
        List<Orderitem> orders=new ArrayList<Orderitem>();
        String sql="select * from cozorder where phone='"+phone+"'";
        System.out.println(sql);
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Orderitem order=new Orderitem(rs.getString("id"),rs.getDate("odate"),rs.getString("status"));
                orders.add(order);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DButil.closeAll(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return orders;
    }

    @Override
    public List<Cartitem> getOrder(String id) {
        List<Cartitem> cart=new ArrayList<Cartitem>();
        String sql="select * from cozorderi where oid='"+id+"'";
        System.out.println(sql);
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Cartitem c=new Cartitem(rs.getInt("gid"),rs.getInt("num"),rs.getString("dest"),rs.getString("id"));
                cart.add(c);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DButil.closeAll(conn, ps, rs);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return cart;
    }
}
