package com.iweb.DAO.impl;

import com.iweb.DAO.InitUserDAO;
import com.iweb.pojo.Address;
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

    @Override
    public void initAddress(Address address) {
        String sql = "insert into address(uid,province_addr,city_addr,detail_addr)values(?,?,?,?)";
        try(Connection c =DButil.getConnection();
            PreparedStatement ps =c.prepareStatement(sql);
        )
        {
            ps.setInt(1,address.getUid());
            ps.setString(2,address.getProvinceAddr());
            ps.setString(3,address.getCityAddr());
            ps.setString(4,address.getDetailAddr());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
