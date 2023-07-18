package com.iweb.DAO;

import com.iweb.pojo.*;

import java.util.List;
import java.util.Properties;

//声明管理员所拥有的权限
public interface AdminDAO {
    //增加商品
    void insertProduct(Product p);
    //删除商品
    void delectProduct(Product p);
    //更新商品
    void  updateProduct(Product p);
    //查看商品
    List<Product>  listProductAll();
    //增加商品类
    void insertCategory(Category p);
    //删除商品类
    void delectCategory(Category p);
    //更新商品类
    void  updateCategory(Category p);
    //查看商品类
    List<Category>  listCategoryAll();
    //增加属性
    void insertProperty(Property p);
    //删除属性
    void delectProperty(Property p);
    //更新属性
    void  updateProperty(Property p);
    //查看属性
    List<Property>  listPropertyAll();
    //增加属性值
    void insertPropertyValue(PropertyValue p);
    //删除属性值
    void delectPropertyValue(PropertyValue p);
    //更新属性值
    void  updatePropertyValue(PropertyValue p);
    //查看属性值
    List<PropertyValue>  listPropertyValueAll();
    //查看订单
    List<Order> listOrderAll();
    //查看订单详情表
    List<OrderDetail> listOrderDetailAll();





}
