package com.iweb.DAO.impl;

import com.iweb.DAO.CheckUserDAO;
import com.iweb.pojo.User;
import com.iweb.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CheckUserDAOImpl implements CheckUserDAO {
    //按照身份查询用户表
    @Override
    public List<User> checkUserAdmin() {
        List<User> users =new ArrayList<>();
        String sql ="select * from user where authority = ?";
        try (
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql);
        )
        {
            ps.setString(1,"admin");
            ResultSet rs =  ps.executeQuery();
            while (rs.next())
            {
                User u =new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setAuthority(rs.getString("authority"));
                u.setPhone(rs.getString("phone"));
                u.setMoney(rs.getDouble("money"));
                users.add(u);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (users.isEmpty())?null:users;
    }

    @Override
    public List<User> checkUserUser() {
        List<User> users =new ArrayList<>();
        String sql ="select * from user where authority = ?";
        try (
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql);
        )
        {
            ps.setString(1,"user");
            ResultSet rs =  ps.executeQuery();
            while (rs.next())
            {
                User u =new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setAuthority(rs.getString("authority"));
                u.setPhone(rs.getString("phone "));
                u.setMoney(rs.getDouble("money"));
                users.add(u);
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (users.isEmpty())?null:users;

    }

    @Override
    public List<User> checkUser() {
        List<User> users =new ArrayList<>();
        String sql ="select * from user limit ?,?";
        try (
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql);
        )
        {
            ps.setInt(1,0);
            ps.setInt(2,Integer.MAX_VALUE);
            ResultSet rs =  ps.executeQuery();
            while (rs.next())
            {
                User u =new User();
                u.setId(rs.getInt("id"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setAuthority(rs.getString("authority"));
                u.setPhone(rs.getString("phone"));
                u.setMoney(rs.getDouble("money"));
                users.add(u);
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (users.isEmpty())?null:users;


    }
}
