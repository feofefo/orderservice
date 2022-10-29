package com.example.common;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;
    public static <T>R<T> Success(T object){
        R<T> r = new R<T>();
        r.code = 1;
        r.msg = "success";
        r.data = object;
        return  r;
    }
    public static <T>R<T> Failed(T object) {
        R<T> r = new R<T>();
        r.code=0;
        r.msg = "failed";
        r.data = null;
        return  r;
    }
}
