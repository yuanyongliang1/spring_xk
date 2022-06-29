package com.select.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;

/**
 * @author ZhangLei
 */
public class CommonResult extends HashMap<String,Object> {

    //返回方法
    public static CommonResult common(int code, String msg, Object object) {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", code);
        commonResult.put("msg", msg);
        commonResult.put("data", object);
        return commonResult;
    }
    //返回方法
    public static CommonResult common1(int code, String token, Object object) {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", code);
        commonResult.put("token", token);
        commonResult.put("data", object);
        return commonResult;
    }

    //返回方法
    public static CommonResult ok(int code, Object data, String msg) {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", code);
        commonResult.put("data", data);
        commonResult.put("msg", msg);
        return commonResult;
    }



    //返回方法
    public static CommonResult common1(int code) {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", code);
        return commonResult;
    }

    public static CommonResult ok(String msg, Object object){
        return CommonResult.common(HttpStatus.SC_OK,msg,object);
    }

    public static CommonResult notFound(){
        return CommonResult.common1(HttpStatus.SC_NOT_FOUND);
    }

    public static CommonResult error(String msg, Object object){
        return CommonResult.common(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg,object);
    }

    public static CommonResult forbidden(String msg, Object object){
        return CommonResult.common(HttpStatus.SC_FORBIDDEN,msg,object);
    }

    public static CommonResult notAllowed(String msg, Object object){
        return CommonResult.common(HttpStatus.SC_METHOD_NOT_ALLOWED,msg,object);
    }

    public static CommonResult badGateway(String msg, Object object){
        return CommonResult.common(HttpStatus.SC_BAD_GATEWAY,msg,object);
    }

}
