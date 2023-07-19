package com.iweb.DAO;

import com.iweb.pojo.Address;
import com.iweb.pojo.User;

public interface InitUserDAO {
    void initUser(User us);
    void initAddress(Address address);
}
