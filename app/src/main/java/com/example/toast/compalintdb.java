package com.example.toast;

public class compalintdb {
    String name;
    String email;
    String complaint;
    String city;

    public compalintdb(String name, String email, String complaint,String city) {
        this.name = name;
        this.email = email;
        this.complaint = complaint;
        this.city = city;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComplaint() {
        return complaint;
    }

    public String getCity() {
        return city;
    }
}
