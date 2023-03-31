package com.SpringBootMaven.Quang.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Json_Response_Users {
    private int errCode;
    private String message;
    private List<User> users;

    public Json_Response_Users() {
    }

    public Json_Response_Users(int errCode, String message, List<User> users) {
        this.errCode = errCode;
        this.message = message;
        this.users = users;
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
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "status='" + errCode + '\'' +
                ", message='" + message + '\'' +
                ", data='" + users + '\'' +
                '}';
    }
}
