package com.example.mydata.controller;

import com.example.mydata.common.JsonResult;
import com.example.mydata.model.Task;
import com.example.mydata.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Controller
@Api(value = "测试", description = "测试")
@Slf4j
public class MyTaskController {

    @Autowired
    TaskService taskServer;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/addTest")
    public String add(){
        return "add";
    }

    @RequestMapping(value = "/ex",method = RequestMethod.GET)
    @ApiOperation(value = "异常")
    public String a() throws SocketTimeoutException{
        throw new SocketTimeoutException();
    }

    @RequestMapping(value = "/logger",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "日志打印")
    public void a1(){
        Logger logger= Logger.getLogger("");
        logger.warning("hello world");

    }


    @RequestMapping(value = "/time",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加时间")
    public void atime(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Long i=System.currentTimeMillis();
        System.out.println("ti="+dateFormat.format(String.valueOf(System.currentTimeMillis())));

        System.out.println("time="+System.currentTimeMillis());
        System.out.println("date="+new Date());
        System.out.println("he="+new Date(System.currentTimeMillis()));
        System.out.println("he="+new Date(System.currentTimeMillis()-1000));


    }



    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "入口方法", notes = "将token、apiCode、version、businessParams组合为Map(Json)类型参数")
    public JsonResult Add(Task task){
        System.out.println("date="+new Date());
        taskServer.add(task);
        return new JsonResult(task,"操作成功");
    }
    @ApiOperation("导出excel")
    @RequestMapping(value = "/exportExcel",method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response){
        HSSFWorkbook book  = new HSSFWorkbook();
        Sheet sheet = book.createSheet("表格1");
        Row row=sheet.createRow(0);
        row.createCell(0).setCellValue("id");

        Row row1=sheet.createRow(1);
        row1.createCell(0).setCellValue("111");

        response.setCharacterEncoding("utf-8");
        response.setContentType("application/octet-stream; charset=utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + "电风扇"+".xls");
        try {
            response.flushBuffer();
            book.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Value("${name}")
    private String name;

    @ApiOperation("获取yml/properties内容")
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    @ResponseBody
    public void getName1(){
        log.info("pro="+name);

    }
}