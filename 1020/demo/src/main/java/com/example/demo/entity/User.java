package com.example.demo.entity;

public class User {

    private String userID;
    private String Username;

    private String password;

    public User(String userID, String username, String password){
        this.userID = userID;
        this.Username = username;
        this.password = password;
    }

    //register
    public boolean register(String username, String password)
    {
        return false;
    }

}
