package com.ruiwang.younthpalace.util;

import java.util.List;

public class ResultMap<T> {
    private Integer code;
    private String msg;
    private T  data;

    public Integer getCode() {
        return code;
    }

    public ResultMap() {
    }


    public ResultMap(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public Object getData() {
        return data;
    }


    @Override
    public String toString() {
        return "ResultMap{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public void setData(T data) {
        this.data = data;
    }
}
