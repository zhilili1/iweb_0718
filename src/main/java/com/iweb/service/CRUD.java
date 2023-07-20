package com.iweb.service;

import com.iweb.DAO.impl.AdminDAOImpl;
import com.iweb.pojo.*;
import com.iweb.view.MainView;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CRUD {
    private static Scanner sc =new Scanner(System.in);
    public static AdminDAOImpl a = new AdminDAOImpl();
    //增加Category
    public void insertCategory()
    {
        System.out.println("请输入分类名");
        String inputCategory =sc.nextLine();
        Category c =new Category();
        c.setName(inputCategory);
        a.insertCategory(c);
        System.out.println("已经添加"+c.getName()+"类");
        MainView.categoryView();}
        //删除Category
    public void deleteCategory()
    {
        selectCategory();
        System.out.println("请输入你要删除的分类名");
        String inputCategory =sc.nextLine();
        Category c =new Category();
        c.setName(inputCategory);
        a.delectCategory(c);
        System.out.println("删除成功");
        MainView.categoryView();}

    //更具id修改name
    public void updateCategory()
    {
        selectCategory();
        System.out.println("请输入你更新的类id");
        int inputId =Integer.parseInt(sc.nextLine());
        System.out.println("请输入你要更新的新内容");
        String inputName =sc.nextLine();
        Category c =new Category();
        c.setId(inputId);
        c.setName(inputName);
        a.updateCategory(c);
        System.out.println("修改成功");
        MainView.categoryView();

//查看Category
    }
    public  List<Category> selectCategory()
    {
        List<Category> c =a.listCategoryAll();
        for (Category ctg:c) {
            System.out.println(ctg);
        }
        return c;
    }
    //查看Product
    public  List<Product> selectProduct()
    {
        List<Product> p =a.listProductAll();
        for (Product pd:p) {
            System.out.println(pd);
        }
        return p;
    }
    //增加Product
    public void insertProduct()
    {
        System.out.println("增加的商品名");
        String inputProductName =sc.nextLine();
        System.out.println("请增加商品原价");
        Double inputoriginalPrice =Double.parseDouble(sc.nextLine());
        System.out.println("请增加商品现价");
        Double inputpromotePrice =Double.parseDouble(sc.nextLine());
        System.out.println("请添加商品的cid");
        int inputcId =Integer.parseInt(sc.nextLine());
        System.out.println("请添加商品的总数");
        int inputStock =Integer.parseInt(sc.nextLine());
        System.out.println("请输入广告词");
        String inputsubtitle =sc.nextLine();
        Date date =new Date(System.currentTimeMillis());
        Product c =new Product();
        c.setName(inputProductName);
        c.setCreateDate(date);
        c.setSubTitle(inputsubtitle);
        c.setStock(inputStock);
        c.setCid(inputcId);
        c.setOriginalPrice(inputoriginalPrice);
        c.setPromotePrice(inputpromotePrice);
        a.insertProduct(c);
        System.out.println("已经添加"+c.getName()+"商品");
        MainView.productView();
        }
        //删除
    public void deleteProduct()
    {
        selectProduct();
        System.out.println("请输入商品名");
        String inputProductName=sc.nextLine();
        Product p =new Product();
        p.setName(inputProductName);
        a.delectProduct(p);
        System.out.println("删除成功");
        MainView.productView();

    }
//更新
    public void updateProduct()
    {
        selectProduct();
        System.out.println("输入你要更改的商品id");
        String s5 =sc.nextLine();
        int inputId =Integer.parseInt(s5);
        System.out.println("更改的商品名");
        String inputProductName =sc.nextLine();
        System.out.println("请更改商品原价");
        String s3=sc.nextLine();
        Double inputoriginalPrice =Double.parseDouble(s3);
        System.out.println("请更改商品现价");
        String s4=sc.nextLine();
        Double inputpromotePrice =Double.parseDouble(s3);
        System.out.println("请更改商品的cid");
        String s1 =sc.nextLine();
        int inputcId =Integer.parseInt(s1);
        System.out.println("请更改商品的总数");
        String s2 =sc.nextLine();
        int inputStock =Integer.parseInt(s2);
        Date date =new Date(System.currentTimeMillis());
        System.out.println("请更改广告词");
        String inputsubtitle =sc.nextLine();
        Product c =new Product(inputId,inputProductName,inputsubtitle,inputoriginalPrice,inputpromotePrice,inputStock
        ,inputcId,date);
        a.updateProduct(c);
        MainView.productView();
    }
    //查找
    public  List<Property> selectProperty()
    {
        List<Property> c =a.listPropertyAll();
        for (Property ctg:c) {
            System.out.println(ctg);
        }
        return c;
    }
    //添加
    public  void insertProperty()
    {
        System.out.println("请输入商品属性名");
        String inputProperty =sc.nextLine();
        System.out.println("请输入cid");
        String str1 =sc.nextLine();
        int inputCid = Integer.parseInt(str1);
        Property c =new Property();
        c.setName(inputProperty);
        c.setCid(inputCid);
        a.insertProperty(c);
        System.out.println("已经添加"+c.getName()+"类");
        MainView.propertyView();
    }
    public void deleteProperty()
    {
        selectProperty();
        System.out.println("请输入你要删除的商品属性名");
        String inputPropertyName =sc.nextLine();
        Property c =new Property();
        c.setName(inputPropertyName);
        a.delectProperty(c);
        System.out.println("删除成功");
        MainView.propertyView();
    }
    public void updateProperty()
    {
        selectProperty();
        System.out.println("请输入你要更新的商品id");
        String str1 =sc.nextLine();
        int inputId =Integer.parseInt(str1);
        System.out.println("请输入你要更新的商品属性名");
        String inputPropertyName =sc.nextLine();
        System.out.println("请输入你要更新的商品cid");
        String str2 =sc.nextLine();
        int inputCid =Integer.parseInt(str2);
        Property c =new Property(inputId,inputCid,inputPropertyName);
        a.updateProperty(c);
        System.out.println("更新成功");
        MainView.propertyView();
    }
   public List<PropertyValue> selectpropertyValue()
   {
       List<PropertyValue> c =a.listPropertyValueAll();
       for (PropertyValue ctg:c) {
           System.out.println(ctg);
       }
       return c;
   }
   public void insertpropertyValue()
   {
       System.out.println("请输入商品属性值");
       String inputPropertyvalue =sc.nextLine();
       System.out.println("请输入pid");
       String str1 =sc.nextLine();
       int inputPid = Integer.parseInt(str1);
       System.out.println("请输入ptid");
       String str2 =sc.nextLine();
       int inputptid = Integer.parseInt(str2);
       PropertyValue c =new PropertyValue();
       c.setValue(inputPropertyvalue);
       c.setPid(inputPid);
       c.setPtid(inputptid);
       a.insertPropertyValue(c);
       System.out.println("已经添加"+c.getValue()+"属性值");
       MainView.propertyValueView();

   }
   public void deletepropertyValue()
   {
       selectpropertyValue();
       System.out.println("请输入商品值");
       String inputPropertyValue=sc.nextLine();
       PropertyValue p =new PropertyValue();
       p.setValue(inputPropertyValue);
       a.delectPropertyValue(p);
       System.out.println("删除成功");
       MainView.propertyValueView();
   }
   public void updatepropertyValue()
   {
       selectpropertyValue();
       System.out.println("请输入你要更新的商品值id");
       String str1 =sc.nextLine();
       int inputId =Integer.parseInt(str1);
       System.out.println("请输入你要更新的商品属性值");
       String inputPropertyValue =sc.nextLine();
       System.out.println("请输入你要更新的商品pid");
       String str2 =sc.nextLine();
       int inputPid =Integer.parseInt(str2);
       System.out.println("请输入你要更新的商品ptid");
       String str3 =sc.nextLine();
       int inputPtid =Integer.parseInt(str3);
       PropertyValue c =new PropertyValue(inputId,inputPid,inputPtid,inputPropertyValue);
       a.updatePropertyValue(c);
       System.out.println("更新成功");
       MainView.propertyValueView();
   }
   public List<Order> selectOrder()
   {
       List<Order> c =a.listOrderAll();
       for (Order ctg:c) {
           System.out.println(ctg);
       }
       return c;
   }
   public void updateOrder()
   {
       selectOrder();
       System.out.println("请选择你要修改的订单编号");
       String str1 =sc.nextLine();
       int inputOrderId =Integer.parseInt(str1);
       System.out.println("请选择对此订单的状态的处理,填写已发货或者未发货");
       String inputOrderStatus =sc.nextLine();
       while (true){
       if (!(inputOrderStatus.equals("已发货")||inputOrderStatus.equals("未发货")))
       {
           System.out.println("订单状态输入有误，请重修输入");
           inputOrderStatus =sc.nextLine();
       }
       else
       {
           break;
       }
       }
       Order o =new Order();
       o.setId(inputOrderId);
       o.setOrderStatus(inputOrderStatus);
       a.updateOrder(o);
       System.out.println("已将订单id为"+o.getId()+"的订单状态修改为"+o.getOrderStatus());


   }

   public  List<OrderDetail> selectOrderDetail()
   {
       List<OrderDetail> c =a.listOrderDetailAll();
       for (OrderDetail ctg:c) {
           System.out.println(ctg);
       }
       return c;
   }


}
