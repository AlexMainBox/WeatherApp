package com.alexapp.dao;

import com.alexapp.entity.User;

public interface UserDAO {

    void addUser(String name, String password, String email);

    int updateUser(User user);


}
