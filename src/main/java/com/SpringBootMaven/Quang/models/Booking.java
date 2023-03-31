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
    private Date date;
    private String timeType;
    private Date createdAt;
    private Date updateAt;

    public Booking() {
    }

    public Booking(int id, String statusId, int doctorId, int patientId, Date date, String timeType, Date createdAt, Date updateAt) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
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
        return "Booking{" +
                "id=" + id +
                ", statusId='" + statusId + '\'' +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", date=" + date +
                ", timeType='" + timeType + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
