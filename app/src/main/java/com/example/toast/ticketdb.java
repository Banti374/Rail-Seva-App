package com.example.toast;

public class ticketdb {
    String Ticket_name;
    String Train_Name;
    String Train_Station;
    String Train_Time;
    String Train_day;
    String Ticket_No;
    String Ticket_Price;


    public ticketdb(String Name, String trainname,  String trainstation, String traintime, String trainday, String Ticket_No, String priceT) {

        this.Ticket_name = Name;
        this.Train_Name = trainname;
        this.Train_Station = trainstation;
        this.Train_Time = traintime;
        this.Train_day = trainday;
        this.Ticket_No = Ticket_No;
        this.Ticket_Price = priceT;



    }

    public String getTicket_name() {
        return Ticket_name;
    }

    public String getTrain_Name() {
        return Train_Name;
    }

    public String getTrain_Station() {
        return Train_Station;
    }

    public String getTrain_Time() {
        return Train_Time;
    }

    public String getTrain_day() {
       return Train_day;
    }

    public String getTicket_No() {
        return Ticket_No;
    }

    public String getTicket_Price() {
        return Ticket_Price;
    }




}

