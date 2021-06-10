package com.example.toast;

public class user {

    public String Name, phonenumber,surname, email, password;

    public user(){

    }


    public user(String Name, String phonenumber, String email, String Password) {
        this.email = email;
        this.Name = Name;
        this.password = Password;
        this.phonenumber = phonenumber;
    }

}
