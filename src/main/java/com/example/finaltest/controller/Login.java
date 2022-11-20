package com.example.finaltest.controller;

import com.example.finaltest.pojo.User;

public class Login {
    private int userId;
    private String address;
    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;
    public Login(User user){
        this.userId=user.getUserId();
        this.userName=user.getUserName();
        this.address=user.getAddress();
    }

}
