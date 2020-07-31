package com.wenba.http;

/**
 * @description: 客户端响应实体类
 * @author: tongrongbing
 * @date: 2020-07-30 16:51
 **/
public class ApiResponse<T> {

    private T data;

    private Integer code;

    private String message;

    public ApiResponse(T data, Integer code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
