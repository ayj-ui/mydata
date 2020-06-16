package com.example.mydata.controller;

import com.example.mydata.model.User;
import com.example.mydata.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;


@RestController
@RequestMapping("/testController")
@Api(value = "测试",description = "cc")
@Slf4j
public class TestController1 {

    @Autowired
    UserService userService;

    //添加
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加user")
    public String insertUser(@RequestBody User user){
      userService.user(user);
      return "OK";
    }

    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    @ApiOperation(value = "user")
    public User findUserById(int id){
        return userService.user(id);
    }

    /*
    * 单个文件上传
    *
    * */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ApiOperation(value = "uploadFile")
    public String uploadFile(MultipartFile file) throws IOException {
        String path="E:\\myfile";
        String fileName=file.getOriginalFilename();

        File file1 = new File(path,fileName);
        file.transferTo(file1);

       return "ok";
    }

    /*
    *
    * 多文件上传
    *
    * */

    @RequestMapping(value = "/uploadFiles",method = RequestMethod.POST)
    @ApiOperation(value = "uploadFiles")
    public String uploadFiles(@RequestBody List<MultipartFile> fileList) throws IOException {
        String filePath = "E:\\myfile";
        String fileName="";
        for(MultipartFile file : fileList){
            fileName=file.getOriginalFilename();
            File file1=new File(filePath,fileName);
            file.transferTo(file1);
        }
        //throw new IOException();
        throw new  FileNotFoundException();
        //return "ok";
    }
}
