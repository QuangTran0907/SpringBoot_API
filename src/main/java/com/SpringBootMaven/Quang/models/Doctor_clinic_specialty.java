package com.SpringBootMaven.Quang.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Doctor_clinic_specialty")
public class Doctor_clinic_specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int doctorId;
    private int clinicId;
    private int specialtyId;
    private Date createdAt;
    private Date updatedAt;

    public Doctor_clinic_specialty() {
    }

    public Doctor_clinic_specialty(int id, int doctorId, int clinicId, int specialtyId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.doctorId = doctorId;
        this.clinicId = clinicId;
        this.specialtyId = specialtyId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
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
        return "doctor_clinic_specialty{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", clinicId=" + clinicId +
                ", specialtyId=" + specialtyId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
