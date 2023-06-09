package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonView;

public class Json_Response_User {

    @JsonView({Views.Public.class,Views.Custom.class})
    private int errCode;

    @JsonView({Views.Public.class,Views.Custom.class})
    private String message;
    @JsonView({Views.Public.class,Views.Custom.class})
    private Object user;

    public Json_Response_User() {
    }

    public Json_Response_User(int errCode, String message, Object user) {
        this.errCode = errCode;
        this.message = message;
        this.user = user;
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

    public Object getUsers() {
        return user;
    }

    public void setUsers(Object user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "status='" + errCode + '\'' +
                ", message='" + message + '\'' +
                ", data='" + user + '\'' +
                '}';
    }
}