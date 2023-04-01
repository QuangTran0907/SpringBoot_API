package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Date;


@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonView({Views.Public.class,Views.Custom.class})
    @Column
    private String email;
    @Column
    @JsonView(Views.Custom.class)
    private String password;

    @JsonView({Views.Public.class,Views.Custom.class})
    @Column
    private String firstName;
    @Column
    @JsonView({Views.Public.class, Views.Custom.class})
    private String lastName;
    @JsonView(Views.Public.class)
    @Column
    private  String address;
    @JsonView(Views.Public.class)
    @Column
    private  String phonenumber;
    @Column
    @JsonView(Views.Internal.class)
    private String image;
    @JsonView({Views.Public.class, Views.Custom.class})
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "positionid", referencedColumnName = "keyMap",insertable = false, updatable = false,nullable = false)
    private AllCode positionData;
    @JsonView({Views.Public.class, Views.Custom.class})
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender", referencedColumnName = "keyMap",insertable = false, updatable = false,nullable = false)
    private AllCode genderData;
    @JsonView({Views.Public.class, Views.Custom.class})
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleid", referencedColumnName = "keyMap",insertable = false, updatable = false,nullable = false)
    private AllCode roleData;



    @Column
    private String createdAt;

    @Column
    private String updatedAt;


    public User() {
    }

    public User(String email, String hashpw, String firstName, String lastName, String address, String phonenumber, AllCode genderData, String image, AllCode roleData, AllCode positionData, String createdAt, String updatedAt) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phonenumber = phonenumber;
        this.image = image;
        this.positionData = positionData;
        this.genderData = genderData;
        this.roleData = roleData;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
    @JsonView({Views.Public.class,Views.Custom.class})

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public AllCode getPositionData() {
        return positionData;
    }

    public void setPositionData(AllCode positionData) {
        this.positionData = positionData;
    }

    public AllCode getGenderData() {
        return genderData;
    }

    public void setGenderData(AllCode genderData) {
        this.genderData = genderData;
    }

    public AllCode getRoleData() {
        return roleData;
    }

    public void setRoleData(AllCode roleData) {
        this.roleData = roleData;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
