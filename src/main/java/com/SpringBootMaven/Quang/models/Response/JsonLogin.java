package com.SpringBootMaven.Quang.models.Response;

import com.SpringBootMaven.Quang.models.Views;
import com.fasterxml.jackson.annotation.JsonView;

public class JsonLogin {
    @JsonView(Views.Public.class)
    private int id;
    @JsonView(Views.Public.class)
    private String email;
    @JsonView(Views.Public.class)
    private String roleid;
    @JsonView(Views.Public.class)
    private String firstName;
    @JsonView(Views.Public.class)
    private String lastName;

    public JsonLogin(int id, String email, String roleid, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.roleid = roleid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public JsonLogin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
