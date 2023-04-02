package com.SpringBootMaven.Quang.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Markdown")
public class Markdown {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contentHTML;
    private String contentMarkdown;
    private String description;

    @OneToOne
    @JoinColumn(name = "doctorid", referencedColumnName = "id")
    private User doctor;

    private int specialtyid;
    private int clinicid;

    public Markdown() {
    }

    public Markdown(String contentHTML, String contentMarkdown, String description, User doctor, int specialtyid, int clinicid) {
        this.contentHTML = contentHTML;
        this.contentMarkdown = contentMarkdown;
        this.description = description;
        this.doctor = doctor;
        this.specialtyid = specialtyid;
        this.clinicid = clinicid;
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
