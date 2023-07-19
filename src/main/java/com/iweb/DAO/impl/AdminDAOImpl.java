package com.iweb.DAO.impl;

import com.iweb.DAO.AdminDAO;
import com.iweb.pojo.*;
import com.iweb.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public void insertProduct(Product p) {
        String sql ="insert into product(name,originalprice,cid,stock,promoteprice,subtitle,creatDate) value (?,?,?,?,?,?,?) ";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.setDouble(2,p.getOriginalPrice());
            ps.setInt(3,p.getCid());
            ps.setInt(4,p.getStock());
            ps.setDouble(5,p.getPromotePrice());
            ps.setString(6,p.getSubTitle());
            ps.setDate(7,p.getCreateDate());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void delectProduct(Product p) {
        String sql ="delete from product where name=?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProduct(Product p) {
        String sql = "update product set name=? , originalprice=? ,cid=? , stock=? ,promoteprice=? where id=?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.setDouble(2,p.getOriginalPrice());
            ps.setInt(3,p.getCid());
            ps.setInt(4,p.getStock());
            ps.setDouble(5,p.getPromotePrice());
            ps.setInt(6,p.getId());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> listProductAll() {
        List<Product> pds =new ArrayList<>();
        String sql ="select * from product limit ?,?";
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
                Product pd =new Product();
                pd.setId(rs.getInt("id"));
                pd.setName(rs.getString("name"));
                pd.setOriginalPrice(rs.getDouble("originalprice"));
                pd.setPromotePrice(rs.getDouble("promoteprice"));
                pd.setCid(rs.getInt("cid"));
                pd.setStock(rs.getInt("stock"));
                pd.setSubTitle(rs.getString("subtitle"));
                pd.setCreateDate(rs.getDate("creatDate"));
                pds.add(pd);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (pds.isEmpty())?null:pds;
    }

    @Override
    public void insertCategory(Category p) {
        String sql ="insert into category(name) value (?) ";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
                )
        {
            ps.setString(1,p.getName());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void delectCategory(Category p) {
        String sql ="delete from category where name=?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
//根据id修改值
    @Override
    public void updateCategory(Category p) {
        String sql = "update category set name = ? where id = ?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.setInt(2,p.getId());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public List<Category> listCategoryAll() {
        List<Category> ctgs =new ArrayList<>();
        String sql ="select * from category limit ?,?";
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
                Category ctg =new Category();
                ctg.setId(rs.getInt("id"));
                ctg.setName(rs.getString("name"));
                ctgs.add(ctg);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ctgs.isEmpty())?null:ctgs;
    }

    @Override
    public void insertProperty(Property p) {
        String sql ="insert into property(name,cid) value (?,?) ";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.setInt(2,p.getCid());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void delectProperty(Property p) {
        String sql ="delete from property where name=?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProperty(Property p) {
        String sql = "update property set name = ? ,cid = ? where id = ?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getName());
            ps.setInt(2,p.getCid());
            ps.setInt(3,p.getId());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<Property> listPropertyAll() {
        List<Property> ctgs =new ArrayList<>();
        String sql ="select * from property limit ?,?";
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
                Property ctg =new Property();
                ctg.setId(rs.getInt("id"));
                ctg.setCid(rs.getInt("cid"));
                ctg.setName(rs.getString("name"));
                ctgs.add(ctg);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ctgs.isEmpty())?null:ctgs;
    }

    @Override
    public void insertPropertyValue(PropertyValue p) {
        String sql ="insert into propertyvalue(value,pid,ptid) value (?,?,?) ";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getValue());
            ps.setInt(2,p.getPid());
            ps.setInt(3,p.getPtid());
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void delectPropertyValue(PropertyValue p) {
        String sql ="delete from propertyvalue where value=?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getValue());
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePropertyValue(PropertyValue p) {
        String sql = "update property set  `value` = ? ,pid =?,ptid =?  where id = ?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,p.getValue());
            ps.setInt(2,p.getPid());
            ps.setInt(3,p.getPtid());
            ps.setInt(4,p.getId());
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<PropertyValue> listPropertyValueAll() {
        List<PropertyValue> ctgs =new ArrayList<>();
        String sql ="select * from propertyvalue limit ?,?";
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
                PropertyValue ctg =new PropertyValue();
                ctg.setId(rs.getInt("id"));
                ctg.setPid(rs.getInt("pid"));
                ctg.setPtid(rs.getInt("ptid"));
                ctg.setValue(rs.getString("value"));
                ctgs.add(ctg);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ctgs.isEmpty())?null:ctgs;
    }

    @Override
    public List<Order> listOrderAll() {
        List<Order> ctgs =new ArrayList<>();
        String sql ="SELECT * FROM `order`";
        try (
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql);
        )
        {
            ResultSet rs =  ps.executeQuery();
            while (rs.next())
            {
                Order ctg =new Order();
                ctg.setId(rs.getInt("order_id"));
                ctg.setUid(rs.getInt("user_id"));
                ctg.setAddressId(rs.getInt("address_id"));
                ctg.setOrderDate(rs.getDate("order_date"));
                ctg.setOrderStatus(rs.getString("order_status"));
                ctgs.add(ctg);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ctgs.isEmpty())?null:ctgs;
    }

    @Override
    public List<OrderDetail> listOrderDetailAll() {
        List<OrderDetail> ctgs =new ArrayList<>();
        String sql ="select * from order_detail limit ?,?";
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
                OrderDetail ctg =new OrderDetail();
                ctg.setId(rs.getInt("detail_id"));
                ctg.setOid(rs.getInt("oid"));
                ctg.setPid(rs.getInt("pid"));
                ctg.setQuantity(rs.getInt("quantity"));
                ctgs.add(ctg);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return (ctgs.isEmpty())?null:ctgs;
    }
    //更具oid修改订单状态
    public void updateOrder(Order o)
    {
        String sql = "update `order` set order_status= ?  where order_id = ?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
        )
        {
            ps.setString(1,o.getOrderStatus());
            ps.setInt(2,o.getId());
            ps.execute();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
