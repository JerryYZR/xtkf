package com.zjgsu.studyweb.msg;

import lombok.Data;

@Data
public class ResponseData {
    private boolean status;

    private int code;

    private String message;

    private Object data;

    public ResponseData(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseData(int code , Object data){
        this.code = code ;
        this.data = data;
        this.message = "";
    }

}
