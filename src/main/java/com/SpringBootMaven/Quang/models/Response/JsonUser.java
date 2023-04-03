package com.SpringBootMaven.Quang.models.Response;

public class JsonUser {
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String phonenumber;
    private String gender;
    private String roleid;
    private String positionid;
    private String avatar;

    public JsonUser() {
    }

    public JsonUser(int id, String email, String password, String firstname, String lastname, String address, String phonenumber, String gender, String roleid, String positionid, String avatar) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.gender = gender;
        this.roleid = roleid;
        this.positionid = positionid;
        this.avatar = avatar;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return roleid;
    }

    public void setRole(String roleid) {
        this.roleid = roleid;
    }

    public String getPosition() {
        return positionid;
    }

    public void setPosition(String positionid) {
        this.positionid = positionid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
