package com.example.mydata.controller;

import com.example.mydata.model.Task;
import com.example.mydata.service.TaskService;

import com.sun.jmx.snmp.tasks.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Controller
public class MyTaskController {

    @Autowired
    TaskService taskServer;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String Add(String task1){

        System.out.println("task1="+task1);
        Task task = new Task();
        Date date = new Date();
        task.setTime(date);
        task.setDescription(task1);
        taskServer.add(task);
        System.out.println("ddddddar3");
        return "aa";
    }


}
