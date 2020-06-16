package com.example.mydata.service;

import com.example.mydata.model.User;

public interface UserService {

    User user(int id);

    void user(User user);

}
