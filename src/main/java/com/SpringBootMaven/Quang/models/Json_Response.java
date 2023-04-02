package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonView;

public class Json_Response {

    @JsonView(Views.Public.class)
    private int errCode;

    @JsonView(Views.Public.class)
    private String message;

    @JsonView(Views.Public.class)
    private Object data;

    public Json_Response() {
    }

    public Json_Response(int errCode, String message, Object data) {
        this.errCode = errCode;
        this.message = message;
        this.data = data;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "status='" + errCode + '\'' +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
