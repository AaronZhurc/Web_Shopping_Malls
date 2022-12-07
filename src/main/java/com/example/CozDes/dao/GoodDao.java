package com.example.CozDes.dao;

import com.example.CozDes.po.Goodbean;
import com.example.CozDes.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodDao implements IGoodDao{
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public List<Goodbean> getGoods() {
        List<Goodbean> goods=new ArrayList<Goodbean>();
        String sql="select * from cozgood";
        System.out.println(sql);
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Goodbean good=new Goodbean(rs.getInt("id"),rs.getString("gname"),rs.getDouble("price"),rs.getString("img"),rs.getString("url"));
                goods.add(good);
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
        return goods;
    }

    @Override
    public List<Goodbean> getGoods(String name) {
        List<Goodbean> goods=new ArrayList<Goodbean>();
        String sql="select * from cozgood where gname like '%"+name+"%'";
        System.out.println(sql);
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                Goodbean good=new Goodbean(rs.getInt("id"),rs.getString("gname"),rs.getDouble("price"),rs.getString("img"),rs.getString("url"));
                goods.add(good);
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
        return goods;
    }

    @Override
    public Goodbean getGood(String url) {
        Goodbean good=null;
        String sql="select * from cozgood where url='"+url+"'";
        System.out.println(sql);
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()) {
                good=new Goodbean();
                good.setId(rs.getInt("id"));
                good.setImg(rs.getString("img"));
                good.setIntro(rs.getString("intro"));
                good.setPrice(rs.getDouble("price"));
                good.setName(rs.getString("gname"));
                good.setUrl(rs.getString("url"));
                good.setStock(rs.getInt("stock"));
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
        return good;
    }

    @Override
    public Goodbean getGood(int id) {
        Goodbean good=null;
        String sql="select * from cozgood where id='"+id+"'";
        System.out.println(sql);
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()) {
                good=new Goodbean();
                good.setId(rs.getInt("id"));
                good.setImg(rs.getString("img"));
                good.setIntro(rs.getString("intro"));
                good.setPrice(rs.getDouble("price"));
                good.setName(rs.getString("gname"));
                good.setUrl(rs.getString("url"));
                good.setStock(rs.getInt("stock"));
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
        return good;
    }
}
