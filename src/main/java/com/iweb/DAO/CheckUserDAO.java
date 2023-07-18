package com.iweb.DAO;

import com.iweb.pojo.User;

import java.util.Collection;

public interface CheckUserDAO {
     Collection<User> checkUserAdmin();
     Collection<User> checkUserUser();
     Collection<User> checkUser();


}
