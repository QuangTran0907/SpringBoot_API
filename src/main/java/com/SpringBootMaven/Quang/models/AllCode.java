package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "allcodes")
public class AllCode {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "keyMap",unique = true,nullable = false)
    private String keyMap;
    @Column(name = "type")
    private String type;

    @JsonView({Views.Public.class,Views.Custom.class})
    @Column(name = "valueVi")
    private String valueVi;
    @JsonView({Views.Public.class,Views.Custom.class})
    @Column(name = "valueEn")
    private String valueEn;
    @Column
    private String createdAt;
    @Column
    private String updateAt;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "positionData")
    private List<User> userByPosition;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genderData")
    private List<User> userByGender;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roleData")
    private List<User> userByRole;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "priceTypeData")
    private List<Doctor_Infor> doctorByPrice;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provinceTypeData")
    private List<Doctor_Infor> doctorByProvince;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentTypeData")
    private List<Doctor_Infor> doctorByPayment;







    public AllCode() {
    }

    public AllCode(int id, String keyMap, String type, String valueVi, String valueEn, String createdAt, String updateAt, List<User> userByGender, List<User> userByPosition, List<User> userByRole) {
        this.id = id;
        this.keyMap = keyMap;
        this.type = type;
        this.valueVi = valueVi;
        this.valueEn = valueEn;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.userByGender = userByGender;
        this.userByPosition = userByPosition;
        this.userByRole = userByRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(String keyMap) {
        this.keyMap = keyMap;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValueVi() {
        return valueVi;
    }

    public void setValueVi(String valueVi) {
        this.valueVi = valueVi;
    }

    public String getValueEn() {
        return valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public List<User> getUserByGender() {
        return userByGender;
    }

    public void setUserByGender(List<User> userByGender) {
        this.userByGender = userByGender;
    }

    public List<User> getUserByPosition() {
        return userByPosition;
    }

    public void setUserByPosition(List<User> userByPosition) {
        this.userByPosition = userByPosition;
    }

    public List<User> getUserByRole() {
        return userByRole;
    }

    public void setUserByRole(List<User> userByRole) {
        this.userByRole = userByRole;
    }
}
