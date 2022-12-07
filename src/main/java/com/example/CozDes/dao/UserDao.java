package com.example.CozDes.dao;

import com.example.CozDes.po.Userbean;
import com.example.CozDes.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements IUserDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public Userbean selectBysome(String phone, String password) {
        Userbean user=null;
        String sql="select * from cozuser where phone='"+phone+"' and password='"+password+"'";
        System.out.println(sql);
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()) {
                user=new Userbean();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
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
        return user;
    }

    @Override
    public boolean addUser(Userbean user) {
        String sql="insert into cozuser(uname,password,phone) values(?,?,?)";
        PreparedStatement ps=null;
        try {
            conn=DButil.getCon();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhone());
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
    public Userbean findByPhone(String phone) {
        Userbean user=null;
        String sql="select * from cozuser where phone='"+phone+"'";
        try {
            conn= DButil.getCon();
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()) {
                user=new Userbean();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
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
        return user;
    }
}
