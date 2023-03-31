package com.SpringBootMaven.Quang.models;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "histories")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientid;
    private int doctorid;
    private String description;
    private String file;
    private Date createdAt;
    private Date updatedAt;

    public History() {
    }

    public History(int id, int patientid, int doctorid, String description, String file, Date createdAt, Date updatedAt) {
        this.id = id;
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.description = description;
        this.file = file;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
        return "History{" +
                "id=" + id +
                ", patientid=" + patientid +
                ", doctorid=" + doctorid +
                ", description='" + description + '\'' +
                ", file='" + file + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
