package com.example.mydata.service.impl;


import com.example.mydata.dao.TaskMapper;
import com.example.mydata.model.Task;
import com.example.mydata.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public void add(Task task) {
        taskMapper.insert(task);
    }

    /*@Override
    public Task select(Integer id) {
        return taskMapper.selectByPrimaryKey(id);
    }*/
}
