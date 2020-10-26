package com.example.mydata.controller.uploadfile;

import com.example.mydata.controller.timer.TimerController;
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
import java.io.*;
import java.util.List;


@RestController
@RequestMapping("/uploadFileController")
@Api(value = "测试上传文件",description = "uploadFile")
@Slf4j
public class UploadFileController {

    @Autowired
    UserService userService;

    @Autowired
    TimerController controller;

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
