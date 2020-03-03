package com.example.mydata.controller;

import com.example.mydata.common.JsonResult;
import com.example.mydata.model.Task;
import com.example.mydata.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.logging.Logger;

@Controller
@Api(value = "测试1", description = "测试1")
public class MyController {

    @Autowired
    TaskService taskServer;


    @RequestMapping(value = "/ex1",method = RequestMethod.GET)
    @ApiOperation(value = "异常")
    @ResponseBody
    public String a() throws SocketTimeoutException{
       throw  new SocketTimeoutException();
    }
}