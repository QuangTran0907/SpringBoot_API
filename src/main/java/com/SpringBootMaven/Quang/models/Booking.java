package com.SpringBootMaven.Quang.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String statusId;
    private int doctorId;
    private int patientId;
    private String date;
    private String timeType;
    private String createdAt;
    private String updateAt;
    private String token;
    public Booking() {
    }

    public Booking(int id, String statusId, int doctorId, int patientId, String date, String timeType, String createdAt, String updateAt, String token) {
        this.id = id;
        this.token = token;
        this.statusId = statusId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.timeType = timeType;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
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

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", statusId='" + statusId + '\'' +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", date='" + date + '\'' +
                ", timeType='" + timeType + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updateAt='" + updateAt + '\'' +
                '}';
    }
}
