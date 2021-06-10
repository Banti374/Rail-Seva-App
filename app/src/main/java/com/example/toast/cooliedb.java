package com.example.toast;

public class cooliedb {
    String name;
    String phone;
    String email;
    String coach;
    String ticketNumber;
    String date;
    String coolie__No;

    public cooliedb(String name, String phone,String email, String coach, String ticket_Number, String date, String coolie_No){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.coach = coach;
        this.ticketNumber = ticket_Number;
        this.date = date;
        this.coolie__No = coolie_No;
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public String getCoach() {
        return coach;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getdate() {
        return date;
    }
    public String getCoolie_No() {
        return coolie__No;
    }
}
