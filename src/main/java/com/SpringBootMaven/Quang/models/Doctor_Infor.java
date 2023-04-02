package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Table(name = "doctor_infor")
@Entity
public class Doctor_Infor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int doctorid;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priceid", referencedColumnName = "keyMap",insertable = false, updatable = false,nullable = false)
    private AllCode priceTypeData;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provinceid", referencedColumnName = "keyMap",insertable = false, updatable = false,nullable = false)
    private AllCode provinceTypeData;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentid", referencedColumnName = "keyMap",insertable = false, updatable = false,nullable = false)
    private AllCode paymentTypeData;
    private String addressClinic;
    private String nameClinic;
    private String note;
    private int count;
    private String createdAt;
    private String updatedAt;

    public Doctor_Infor() {
    }

    public Doctor_Infor(int id, int doctorid, AllCode priceTypeData, AllCode provinceTypeData, AllCode paymentTypeData, String addressClinic, String nameClinic, String note, int count, String createdAt, String updatedAt) {
        this.id = id;
        this.doctorid = doctorid;
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

    @Override
    public String toString() {
        return "Doctor_Infor{" +
                "id=" + id +
                ", doctorid=" + doctorid +
                ", priceTypeData=" + priceTypeData +
                ", provinceTypeData=" + provinceTypeData +
                ", paymentTypeData=" + paymentTypeData +
                ", addressClinic='" + addressClinic + '\'' +
                ", nameClinic='" + nameClinic + '\'' +
                ", note='" + note + '\'' +
                ", count=" + count +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
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
