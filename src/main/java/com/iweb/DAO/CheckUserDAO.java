package com.iweb.DAO;

import com.iweb.pojo.User;

import java.util.Collection;
import java.util.List;

public interface CheckUserDAO {
     Collection<User> checkUserAdmin();
     Collection<User> checkUserUser();
     List<User> checkUser();


}
