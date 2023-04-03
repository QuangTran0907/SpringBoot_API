package com.SpringBootMaven.Quang.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

@Entity
@Table(name = "Markdown")
public class Markdown {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonView(Views.Custom.class)
    private String contentHTML;
    @JsonView(Views.Custom.class)
    private String contentMarkdown;
    @JsonView(Views.Custom.class)
    private String description;


    @OneToOne
    @JoinColumn(name = "doctorid", referencedColumnName = "id")
    private User doctor;

    private int specialtyid;
    private int clinicid;

    private String createdAt;
    private String updatedAt;

    public Markdown() {
    }

    public Markdown(int id, String contentHTML, String contentMarkdown, String description, User doctor, int specialtyid, int clinicid, String createdAt, String updatedAt) {
        this.id = id;
        this.contentHTML = contentHTML;
        this.contentMarkdown = contentMarkdown;
        this.description = description;
        this.doctor = doctor;
        this.specialtyid = specialtyid;
        this.clinicid = clinicid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
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

    public String getContentHTML() {
        return contentHTML;
    }

    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }

    public String getContentMarkdown() {
        return contentMarkdown;
    }

    public void setContentMarkdown(String contentMarkdown) {
        this.contentMarkdown = contentMarkdown;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return doctor;
    }

    public void setUser(User doctor) {
        this.doctor = doctor;
    }

    public int getSpecialtyid() {
        return specialtyid;
    }

    public void setSpecialtyid(int specialtyid) {
        this.specialtyid = specialtyid;
    }

    public int getClinicid() {
        return clinicid;
    }

    public void setClinicid(int clinicid) {
        this.clinicid = clinicid;
    }

    @Override
    public String toString() {
        return "Markdown{" +
                "contentHTML='" + contentHTML + '\'' +
                ", contentMarkdown='" + contentMarkdown + '\'' +
                ", description='" + description + '\'' +
                ", doctor=" + doctor +
                ", specialtyid=" + specialtyid +
                ", clinicid=" + clinicid +
                '}';
    }
}
