package com.example.mydata.common;

/*
*
* 返回类定义
*
* @date 2019/11/8
*
* */

import lombok.Data;

@Data
public class JsonResult {

    private final static String CODE_SUCCESS="success";

    private final static String CODE_ERROR = "error";

    private String code=CODE_SUCCESS;

    private Object data;

    private String msg="操作成功";

    private Long time = System.currentTimeMillis();


    public JsonResult(Object data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public JsonResult(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    /*
    *
    * 初始化
    *
    * */
    public JsonResult(String code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
