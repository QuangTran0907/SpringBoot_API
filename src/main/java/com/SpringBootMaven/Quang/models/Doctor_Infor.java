package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name = "doctor_infor")
@Entity
public class Doctor_Infor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Custom.class)
    @JoinColumn(name = "priceid", referencedColumnName = "keyMap",insertable = true, updatable = true,nullable = true)
    private AllCode priceTypeData;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Custom.class)
    @JoinColumn(name = "provinceid", referencedColumnName = "keyMap",insertable = true, updatable = true,nullable = true)
    private AllCode provinceTypeData;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonView(Views.Custom.class)
    @JoinColumn(name = "paymentid", referencedColumnName = "keyMap",insertable = true, updatable = true,nullable = true)
    private AllCode paymentTypeData;
    @JsonView(Views.Custom.class)
    private String addressClinic;
    @JsonView(Views.Custom.class)
    private String nameClinic;
    @JsonView(Views.Custom.class)
    private String note;
    @JsonView(Views.Custom.class)
    private int count;
    @JsonView(Views.Custom.class)
    private String createdAt;
    @JsonView(Views.Custom.class)
    private String updatedAt;

    public Doctor_Infor() {
    }


    public Doctor_Infor(int id, User user, AllCode priceTypeData, AllCode provinceTypeData, AllCode paymentTypeData, String addressClinic, String nameClinic, String note, int count, String createdAt, String updatedAt) {
        this.id = id;
        this.user = user;
        this.priceTypeData = priceTypeData;
        this.provinceTypeData = provinceTypeData;
        this.paymentTypeData = paymentTypeData;
        this.addressClinic = addressClinic;
        this.nameClinic = nameClinic;
        this.note = note;
        this.count = count;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public AllCode getPriceTypeData() {
        return priceTypeData;
    }

    public void setPriceTypeData(AllCode priceTypeData) {
        this.priceTypeData = priceTypeData;
    }

    public AllCode getProvinceTypeData() {
        return provinceTypeData;
    }

    public void setProvinceTypeData(AllCode provinceTypeData) {
        this.provinceTypeData = provinceTypeData;
    }

    public AllCode getPaymentTypeData() {
        return paymentTypeData;
    }

    public void setPaymentTypeData(AllCode paymentTypeData) {
        this.paymentTypeData = paymentTypeData;
    }

    public String getAddressClinic() {
        return addressClinic;
    }

    public void setAddressClinic(String addressClinic) {
        this.addressClinic = addressClinic;
    }

    public String getNameClinic() {
        return nameClinic;
    }

    public void setNameClinic(String nameClinic) {
        this.nameClinic = nameClinic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
