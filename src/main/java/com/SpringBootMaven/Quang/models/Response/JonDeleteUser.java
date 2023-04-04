package com.SpringBootMaven.Quang.models.Response;

public class JonDeleteUser {
    String id;

    public JonDeleteUser(String id) {
        this.id = id;
    }

    public JonDeleteUser() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JonDeleteUser{" +
                "id='" + id + '\'' +
                '}';
    }
}
