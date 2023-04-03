package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeType", referencedColumnName = "keyMap",insertable = true, updatable = true,nullable = true)
    private AllCode timeTypeData;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "id",insertable = true, updatable = true,nullable = true)
    private User doctorData;
    private String createdAt;
    private String updatedAt;

    public Schedule() {
    }

    public Schedule(int id, int currentNumber, int maxNumber, String date, AllCode timeTypeData, User doctorData, String createdAt, String updatedAt) {
        this.id = id;
        this.currentNumber = currentNumber;
        this.maxNumber = maxNumber;
        this.date = date;
        this.timeTypeData = timeTypeData;
        this.doctorData = doctorData;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public AllCode getTimeTypeData() {
        return timeTypeData;
    }

    public void setTimeTypeData(AllCode timeTypeData) {
        this.timeTypeData = timeTypeData;
    }

    public User getDoctorData() {
        return doctorData;
    }

    public void setDoctorData(User doctorData) {
        this.doctorData = doctorData;
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

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", currentNumber=" + currentNumber +
                ", maxNumber=" + maxNumber +
                ", date='" + date + '\'' +
                ", timeTypeData=" + timeTypeData +
                ", doctorData=" + doctorData +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
