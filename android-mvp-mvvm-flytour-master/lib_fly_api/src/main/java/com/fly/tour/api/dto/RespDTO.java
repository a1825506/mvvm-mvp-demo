package com.fly.tour.api.dto;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;

import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * Description: <RespDTO><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
public class RespDTO<T> implements Serializable{

    public int status ;
    public String message = "";

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T data;

    @Override
    public String toString() {
        return "RespDTO{" +
                "code=" + message +
                ", error='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public void setCode(int status) {
        this.status = status;
    }

    public void setError(String error) {
        this.message = message;
    }
}
