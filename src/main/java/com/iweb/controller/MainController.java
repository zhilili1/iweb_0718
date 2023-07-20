package com.iweb.controller;

import com.iweb.DAO.impl.AdminDAOImpl;
import com.iweb.service.CRUD;
import com.iweb.view.MainView;

public class MainController {
    //管理员登录成功控制器，根据key值不同，跳转到不同的view视图
    private static CRUD crud =new CRUD();

    public static void adminLoginSuccessViewController(String key)
    {
        switch (key)
        {

            case "1":
                System.out.println("正在跳转到商品视图");
                MainView.productView();
                break;
            case"2":
                System.out.println("正在跳转到商品分类视图");
                MainView.categoryView();
                break;
            case "3":
                System.out.println("正在跳转到商品属性视图");
                MainView.propertyView();
                break;
            case "4":
                System.out.println("正在跳转到商品属性值视图");
                MainView.propertyValueView();
                break;
            case "5":
                System.out.println("正在跳转到订单视图");
                MainView.orderView();
                break;

            default:
                System.out.println("输入范围有误");
                break;
        }

    }
    public static void categoryViewController(String key)
    {
        switch (key)
        {
            case "1":
                crud.insertCategory();
                break;
            case"2":
                crud.deleteCategory();
                break;
            case"3":
                crud.updateCategory();
                break;
            case "4":
                crud.selectCategory();
                MainView.categoryView();
                break;
            case "5":
                MainView.adminLoginSuccessView();
                break;
        }

    }
    public static void productViewController(String key)
    {

        switch (key)
        {
            case "1":
                crud.insertProduct();
                break;
            case"2":
                crud.deleteProduct();
                break;
            case"3":
                crud.updateProduct();
                break;
            case "4":
                crud.selectProduct();
                MainView.productView();
                break;
            case "5":
                MainView.adminLoginSuccessView();
                break;
        }

    }
    public static void propertyViewController(String key)
    {
        switch (key)
        {

            case "1":
               crud.insertProperty();
                break;
            case"2":
                crud.deleteProperty();
                break;
            case"3":
                crud.updateProperty();
                break;
            case "4":
                crud.selectProperty();
                MainView.propertyView();
                break;
            case "5":
                MainView.adminLoginSuccessView();
                break;
        }

    }
    public static void propertyValueViewController(String key)
    {

        switch (key)
        {

            case "1":
               crud.insertpropertyValue();
                break;
            case"2":
                crud.deletepropertyValue();
                break;
            case"3":
                crud.updatepropertyValue();
                break;
            case "4":
                crud.selectpropertyValue();
                MainView.propertyValueView();
                break;
            case "5":
                MainView.adminLoginSuccessView();
                break;
        }


    }
    public static void userLoginSuccessViewController(String key)
    {

        switch (key)
        {
            case "1":
                crud.selectProduct();
                MainView.userLoginSuccessView();
                break;
            case "2":
                crud.selectCategory();
                MainView.userLoginSuccessView();
                break;
            case"3":
                crud.selectProperty();
                MainView.userLoginSuccessView();
                break;
            case "4":
                crud.selectpropertyValue();
                MainView.userLoginSuccessView();
                break;
            default:
                MainView.loginView();
        }
    }
    public static void orderViewController(String key)
    {

        switch (key)
        {
            case"1":
                crud.selectOrder();
                MainView.orderView();
                break;
            case "2":
                crud.selectOrderDetail();
                MainView.orderView();
                break;
            case "3":
                crud.updateOrder();
                MainView.orderView();
                break;

            case"4":
                MainView.adminLoginSuccessView();
                break;
        }
    }
}
