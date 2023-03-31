package com.SpringBootMaven.Quang.models;

public class Json_Response {
    private int errCode;
    private String message;
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
