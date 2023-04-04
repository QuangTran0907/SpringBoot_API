package com.SpringBootMaven.Quang.models.Response;

public class Json_Patient_Request {
    private String email;
    private String fullName;
    private String time;
    private String doctorName;
    private String language;
    private String doctorid;

    private String selectedGender;
    private String address;
    private String phonenumber;
    private String timeType;
    private String date;
    private String token;

    public Json_Patient_Request() {
    }

    public Json_Patient_Request(String email, String fullName, String time, String doctorName, String language, String doctorid, String selectedGender, String address, String phonenumber,String date,String timeType,String token) {
        this.token = token;
        this.date = date;
        this.timeType = timeType;
        this.email = email;
        this.fullName = fullName;
        this.time = time;
        this.doctorName = doctorName;
        this.language = language;
        this.doctorid = doctorid;
        this.selectedGender = selectedGender;
        this.address = address;
        this.phonenumber = phonenumber;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(String doctorid) {
        this.doctorid = doctorid;
    }

    public String getSelectedGender() {
        return selectedGender;
    }

    public void setSelectedGender(String selectedGender) {
        this.selectedGender = selectedGender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Json_Patient_Request{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", time='" + time + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", language='" + language + '\'' +
                ", doctorid='" + doctorid + '\'' +
                ", selectedGender='" + selectedGender + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }




}
