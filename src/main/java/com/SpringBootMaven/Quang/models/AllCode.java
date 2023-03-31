package com.SpringBootMaven.Quang.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "allcodes")
public class AllCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "_key")
    private String key;
    @Column(name = "type")
    private String type;
    @Column(name = "valueVi")

    private String valueVi;
    @Column(name = "valueEn")

    private String valueEn;
    private Date createdAt;
    private Date updateAt;

    public AllCode() {
    }

    public AllCode(int id, String key, String type, String valueVi, String valueEn, Date createdAt, Date updateAt) {
        this.id = id;
        this.key = key;
        this.type = type;
        this.valueVi = valueVi;
        this.valueEn = valueEn;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "AllCode{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", type='" + type + '\'' +
                ", valueVi='" + valueVi + '\'' +
                ", valueEn='" + valueEn + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
