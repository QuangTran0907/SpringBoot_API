package com.SpringBootMaven.Quang.models.Response;

public class JsonEmail {
    private String language;
    private String patientName;
    private String time;
    private String doctorName;
    private String redirectLink;
    private String reciverEmail;

    public JsonEmail() {
    }

    public JsonEmail(String language, String patientName, String time, String doctorName, String redirectLink,String reciverEmail) {
        this.language = language;
        this.patientName = patientName;
        this.time = time;
        this.doctorName = doctorName;
        this.redirectLink = redirectLink;
        this.reciverEmail = reciverEmail;
    }

    public String getReciverEmail() {
        return reciverEmail;
    }

    public void setReciverEmail(String reciverEmail) {
        this.reciverEmail = reciverEmail;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
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

    public String getRedirectLink() {
        return redirectLink;
    }

    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }

    @Override
    public String toString() {
        return "JsonEmail{" +
                "language='" + language + '\'' +
                ", patientName='" + patientName + '\'' +
                ", time='" + time + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", redirectLink='" + redirectLink + '\'' +
                ", reciverEmail='" + reciverEmail + '\'' +
                '}';
    }
}
