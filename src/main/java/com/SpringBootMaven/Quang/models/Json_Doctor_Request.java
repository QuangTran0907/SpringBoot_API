package com.SpringBootMaven.Quang.models;

public class Json_Doctor_Request {
    private String doctorid;
    private String contentHTML;
    private String contentMarkdown;
    private String description;
    private String action;
    private String selectedPrice;
    private String selectedPayment;
    private String selectedProvince;
    private String nameClinic;
    private String note;
    private String clinicid;
    private String addressClinic;
    private String specialtyid;


    public Json_Doctor_Request() {
    }

    public Json_Doctor_Request(String doctorid, String contentHTML, String contentMarkdown, String description, String action, String selectedPrice, String selectedPayment, String selectedProvince, String nameClinic, String note, String clinicid, String addressClinic, String specialtyid) {
        this.doctorid = doctorid;
        this.contentHTML = contentHTML;
        this.contentMarkdown = contentMarkdown;
        this.description = description;
        this.action = action;
        this.selectedPrice = selectedPrice;
        this.selectedPayment = selectedPayment;
        this.selectedProvince = selectedProvince;
        this.nameClinic = nameClinic;
        this.note = note;
        this.clinicid = clinicid;
        this.addressClinic = addressClinic;
        this.specialtyid = specialtyid;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSelectedPrice() {
        return selectedPrice;
    }

    public void setSelectedPrice(String selectedPrice) {
        this.selectedPrice = selectedPrice;
    }

    public String getSelectedPayment() {
        return selectedPayment;
    }

    public void setSelectedPayment(String selectedPayment) {
        this.selectedPayment = selectedPayment;
    }

    public String getSelectedProvince() {
        return selectedProvince;
    }

    public void setSelectedProvince(String selectedProvince) {
        this.selectedProvince = selectedProvince;
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

    public String getClinicid() {
        return clinicid;
    }

    public void setClinicid(String clinicid) {
        this.clinicid = clinicid;
    }

    public String getAddressClinic() {
        return addressClinic;
    }

    public void setAddressClinic(String addressClinic) {
        this.addressClinic = addressClinic;
    }

    public String getSpecialtyid() {
        return specialtyid;
    }

    public void setSpecialtyid(String specialtyid) {
        this.specialtyid = specialtyid;
    }

    @Override
    public String toString() {
        return "Json_Doctor_Request{" +
                "doctorid='" + doctorid + '\'' +
                ", contentHTML='" + contentHTML + '\'' +
                ", contentMarkdown='" + contentMarkdown + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                ", selectedPrice='" + selectedPrice + '\'' +
                ", selectedPayment='" + selectedPayment + '\'' +
                ", selectedProvince='" + selectedProvince + '\'' +
                ", nameClinic='" + nameClinic + '\'' +
                ", note='" + note + '\'' +
                ", clinicid='" + clinicid + '\'' +
                ", addressClinic='" + addressClinic + '\'' +
                ", specialtyid='" + specialtyid + '\'' +
                '}';
    }
}
