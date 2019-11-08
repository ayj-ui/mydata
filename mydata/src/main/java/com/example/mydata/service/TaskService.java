package com.example.mydata.service;

import com.example.mydata.dao.TaskMapper;
import com.example.mydata.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface TaskService {

    public void add(Task task);

    public Task select();

}
