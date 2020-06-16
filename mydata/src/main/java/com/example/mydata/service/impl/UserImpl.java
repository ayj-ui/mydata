package com.example.mydata.service.impl;

import com.example.mydata.dao.UserMapper;
import com.example.mydata.model.User;
import com.example.mydata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserMapper userMapper ;

    @Override
    public User user(int id) {
        Object object = userMapper.selectById(id);
        return null;
    }

    @Override
    public void user(User user) {
        userMapper.insert(user);
    }
}
