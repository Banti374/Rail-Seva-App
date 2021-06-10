package com.example.toast;

public class wheelchairdb {
    String name;
    String phone;
    String coach;
    String trainName;
    String date;

    public wheelchairdb(String name, String phone, String coach, String Train_Name, String date) {
        this.name = name;
        this.phone = phone;
        this.coach = coach;
        this.trainName = Train_Name;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCoach() {
        return coach;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getdate() {
        return date;
    }
}


