package com.example.CozDes.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DButil {
    static Connection conn;
    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
        String username="root";
        String password="db120325";
        //if(conn==null) {
        conn=DriverManager.getConnection(url,username,password);
        //}
        return conn;
    }
    public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException {
        if(rs!=null) {
            rs.close();
        }
        if(ps!=null) {
            ps.close();
        }
        if(conn!=null) {
            conn.close();
        }
    }
}
