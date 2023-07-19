package com.iweb.view;

import com.iweb.DAO.InitUserDAO;
import com.iweb.DAO.impl.CheckUserDAOImpl;
import com.iweb.DAO.impl.InitUserDAOImpl;
import com.iweb.controller.MainController;
import com.iweb.pojo.Address;
import com.iweb.pojo.User;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class MainView {
    //创建一个静态Scanner成员变量，使得所有的
    public static Scanner sc =new Scanner(System.in);
 public  static void showView() {
     System.out.println("欢迎来到简易的购物系统");
     System.out.println("  亲选择你想要的功能 ");
     System.out.println("   1.登录账号");
     System.out.println("   2.注册账号");
     String inputValue =sc.nextLine();
     switch (inputValue)
     {
         case "1":
             loginView();
             break;
         case "2":
            registerView();
             break;
         default:
             System.out.println("输入范围有误，请重写输入");
             showView();
     }
 }
 //登录界面
 public static void loginView()
 {
     System.out.println("欢迎来到登录界面");
     System.out.println("1、管理员登录");
     System.out.println("2、非管理原登录");
     System.out.println("请选择1或2");
     String intput =sc.nextLine();
     switch (intput)
     {
         case "1":
             adminLoginView();
             break;
         case "2":
             userLoginView();
             break;
         default:
             System.out.println("输入范围有误，请重写输入");
             loginView();

     }
 }
 public static void adminLoginView()
 {
     System.out.println("欢迎来到管理员登录界面");
     System.out.println("请输入你要登录的账号");
     String inputName = sc.nextLine();
     System.out.println("请输入你要登录的密码");
     String inputpassword = sc.nextLine();
     //检查user表，并将其返还给集合users
     CheckUserDAOImpl ckdi = new CheckUserDAOImpl();
     List<User> users = ckdi.checkUserAdmin();
     //遍历这个集合，判断user表中是否有输入的账号密码
     for (User u : users) {
         if (u.getUserName().equals(inputName) && u.getPassword().equals(inputpassword)) {
             //登录成功页面
             System.out.println("登录成功");
             System.out.println("正在跳转到用户登录成功页面");
             MainView.userLoginSuccessView();
             return;
         }
     }
     System.out.println("未找到该用户，可能你的账户密码有误，请重新输入");
     adminLoginView();
     }
//}

 public  static  void userLoginView() {
     System.out.println("欢迎来到用户登录界面");
     System.out.println("请输入你要登录的账号");
     String inputName = sc.nextLine();
     System.out.println("请输入你要登录的密码");
     String inputpassword = sc.nextLine();
     //检查user表，并将其返还给集合users
     CheckUserDAOImpl ckdi = new CheckUserDAOImpl();
     List<User> users = ckdi.checkUserUser();
     //遍历这个集合，判断user表中是否有输入的账号密码
         for (User u : users) {
             if (u.getUserName().equals(inputName) && u.getPassword().equals(inputpassword)) {
                 //登录成功页面
                 System.out.println("登录成功");
                 System.out.println("正在跳转到用户登录成功页面");
                 MainView.userLoginSuccessView();
                 return;
             }
         }
         System.out.println("未找到该用户，可能你的账户密码有误，请重新输入");
         userLoginView();

}

 //注册界面
    public  static  void registerView()
    {
        //在每次输入完判断格式是否正确
        System.out.println("欢迎来到注册界面");
        System.out.println("请输入你要注册的账号");
        String inputName = sc.nextLine();
        while (true)
        {
            if (inputName==null||inputName.equals(""))
            {
                System.out.println("账号格式有误，请重新输入");
                inputName =sc.nextLine();
            }
            else {
                break;
            }
        }
        System.out.println("请输入你要注册的密码");
        String inputpassword = sc.nextLine();
        while (true)
        {
            if (inputpassword==null||inputpassword.equals(""))
            {
                System.out.println("密码格式有误，请重新输入");
                inputName =sc.nextLine();
            }
            else {
                break;
            }
        }
        System.out.println("请输入你的身份,只能写admin或者user");
        String inputAuthority =sc.nextLine();
        while (true)
        {
            if(inputAuthority==null||inputAuthority.equals("")||!inputAuthority.equals("admin")&&!inputAuthority.equals("user"))
            {
                System.out.println("输入身份格式有误，请重新输入");
                inputAuthority=sc.nextLine();
            }
            else {
                break;
            }
        }
        System.out.println("请输入你的电话号码,11位");
        String inputPhone =sc.nextLine();
        while (true)
        {
            if (inputPhone==null||inputPhone.equals(""))
            {
                System.out.println("账号格式有误，请重新输入");
                inputName =sc.nextLine();
            }
            else {
                break;
            }
        }
        System.out.println("请输入你要充值的钱");
        String st1 =sc.nextLine();
        Double inputMoney =Double.parseDouble(st1);
        System.out.println("请输入你的省份");
        String inputProvince =sc.nextLine();
        System.out.println("请输入你的城市");
        String inputCity =sc.nextLine();
        System.out.println("请输入详细地址");
        String inputDetail = sc.nextLine();
        //检查user表，并将其返还给集合users
        CheckUserDAOImpl ckdi =new CheckUserDAOImpl();
        List<User> users = ckdi.checkUser();
        User u1 =new User();
        u1.setUserName(inputName);
        u1.setPassword(inputpassword);
        u1.setPhone(inputPhone);
        u1.setMoney(inputMoney);
        u1.setAuthority(inputAuthority);
        //遍历这个集合，判断user表中是否有输入的账号密码
        for (User u:users)
        {
            if (u.getUserName().equals(inputName))
            {
                System.out.println("该用户已存在，请重修输入");
                registerView();
            }
    }
        InitUserDAOImpl iudi =new InitUserDAOImpl();
        //添加成功
        iudi.initUser(u1);
        //再次获得user表集合
        users = ckdi.checkUser();
        u1.setId(users.get(users.size()-1).getId());
        Address a =new Address();
        a.setUid(u1.getId());
        a.setProvinceAddr(inputProvince);
        a.setCityAddr(inputCity);
        a.setDetailAddr(inputDetail);
        iudi.initAddress(a);
        System.out.println("注册成功");
        MainView.showView();
}
//管理员登陆成功后的视图
public static void adminLoginSuccessView()
{
    System.out.println("你已进入管理者登录成功页面");
    System.out.println("请选择你的功能");
    System.out.println("1、对商品进行操作");
    System.out.println("2、对商品分类进行操作");
    System.out.println("3、对商品属性进行操作");
    System.out.println("4、对商品值进行操作");
    System.out.println("5、查看订单");
    String inputValue =sc.nextLine();
    MainController.adminLoginSuccessViewController(inputValue);


}
//商品分类视图
public static void categoryView()
{
    System.out.println("欢迎进入到商品分类视图，请选择你的选项");
    System.out.println("1、添加商品类");
    System.out.println("2、删除商品类");
    System.out.println("3、更新商品类");
    System.out.println("4、查看商品类");
    System.out.println("5、返回管理者登录成功页面");
    String inputValue =sc.nextLine();
    MainController.categoryViewController(inputValue);

}
//商品视图
public static void productView()
{
    System.out.println("欢迎进入到商品视图，请选择你的选项");
    System.out.println("1、添加商品");
    System.out.println("2、删除商品");
    System.out.println("3、更新商品");
    System.out.println("4、查看商品");
    String inputValue =sc.nextLine();
    MainController.productViewController(inputValue);
}
//商品属性视图
public static void propertyView()
{
    System.out.println("欢迎进入到商品属性视图，请选择你的选项");
    System.out.println("1、添加商品属性");
    System.out.println("2、删除商品属性");
    System.out.println("3、更新商品属性");
    System.out.println("4、查看商品属性");
    String inputValue =sc.nextLine();
    MainController.propertyViewController(inputValue);
}
//商品属性值视图
public static void propertyValueView()
{
    System.out.println("欢迎进入到商品属性值视图，请选择你的选项");
    System.out.println("1、添加商品属性值");
    System.out.println("2、删除商品属性值");
    System.out.println("3、更新商品属性值");
    System.out.println("4、查看商品属性值");
    String inputValue =sc.nextLine();
    MainController.propertyValueViewController(inputValue);
}
    public static void userLoginSuccessView()
    {
        System.out.println("你已进入用户登录成功页面");
        System.out.println("请选择你的功能");
        System.out.println("1、查看商品");
        System.out.println("2、查看商品类");
        System.out.println("3、查看商品属性");
        System.out.println("4、查看商品属性值");
        String inputValue =sc.nextLine();
        MainController.userLoginSuccessViewController(inputValue);


    }
    //订单视图
    public static void orderView()
    {
        System.out.println("你已进入订单页面，请选择你的功能");
        System.out.println("1、查询订单");
        System.out.println("2、查询订单详情");
        System.out.println("3、对订单进行修改");
        System.out.println("4、返回管理员登录成功页面");
        String inputValue =sc.nextLine();
        MainController.orderViewController(inputValue);

    }


}
