package com.example.mydata.controller;

import com.example.mydata.EnumUtil.WeatherEnum;
import com.example.mydata.common.JsonResult;
import com.example.mydata.model.Task;
import com.example.mydata.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@Api(value = "添加", description = "添加")
public class MyTaskController {

    @Autowired
    TaskService taskServer;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "入口方法", notes = "将token、apiCode、version、businessParams组合为Map(Json)类型参数")
    public JsonResult Add(String task ,WeatherEnum weather){

        Task task1 = new Task();
        Date date = new Date();
        task1.setTime(date);
        task1.setDescription(task);
        //System.out.println("w="+WeatherEnum.valueOf(weather.toUpperCase()));
        task1.setWeatherEnum(weather);
        taskServer.add(task1);
        return new JsonResult(task1,"操作成功");
    }
}