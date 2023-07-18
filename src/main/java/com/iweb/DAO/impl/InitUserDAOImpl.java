package com.iweb.DAO.impl;

import com.iweb.DAO.InitUserDAO;
import com.iweb.pojo.User;
import com.iweb.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InitUserDAOImpl implements InitUserDAO {
    @Override
    public void initUser(User us) {
        String sql = "insert into user(username,password,authority,phone,money) values(?,?,?,?,?)";
        try(Connection c =DButil.getConnection();
            PreparedStatement ps =c.prepareStatement(sql);
         )
        {
            ps.setString(1,us.getUserName());
            ps.setString(2,us.getPassword());
            ps.setString(3,us.getAuthority());
            ps.setString(4,us.getPhone());
            ps.setDouble(5,us.getMoney());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
