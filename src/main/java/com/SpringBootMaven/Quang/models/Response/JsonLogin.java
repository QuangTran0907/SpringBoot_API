package com.SpringBootMaven.Quang.models.Response;

public class JsonLogin {
    private int id;
    private String email;
    private String roleid;
    private String firstName;
    private String lastName;

    public JsonLogin(int id, String email, String roleid, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.roleid = roleid;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
