package com.example.mydata.service;


import com.example.mydata.model.Task;

public interface TaskService {

    void add(Task task);

    Task select(Integer id);

}
