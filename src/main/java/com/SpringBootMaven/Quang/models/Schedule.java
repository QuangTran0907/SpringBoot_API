package com.SpringBootMaven.Quang.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int currentNumber;
    private int maxNumber;
    private Date date;
    private String timeType;
    private int doctorId;
    private Date createdAt;
    private Date updatedAt;

    public Schedule() {
    }

    public Schedule(int id, int currentNumber, int maxNumber, Date date, String timeType, int doctorId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.currentNumber = currentNumber;
        this.maxNumber = maxNumber;
        this.date = date;
        this.timeType = timeType;
        this.doctorId = doctorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", currentNumber=" + currentNumber +
                ", maxNumber=" + maxNumber +
                ", date=" + date +
                ", timeType='" + timeType + '\'' +
                ", doctorId=" + doctorId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
