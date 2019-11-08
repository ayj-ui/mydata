package com.example.mydata.controller;

import com.example.mydata.common.JsonResult;
import com.example.mydata.model.Task;
import com.example.mydata.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public JsonResult Add(String task1){

        Task task = new Task();
        Date date = new Date();
        task.setTime(date);
        task.setDescription(task1);
        taskServer.add(task);
        return new JsonResult(task,"操作成功");
    }
}