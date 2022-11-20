package com.example.finaltest.pojo;

public class User {
    public User(String userName, String userPwd) {
        this.userPwd=userPwd;
        this.userName=userName;
    }

    public String getUserName() {
        return userName;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    private String address;
    private String userName;

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private int userId;
    private String userPwd;

}
