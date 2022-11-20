package com.example.finaltest.service;

import com.example.finaltest.pojo.User;

import java.util.List;

public interface UserService {
    public int  Register(User user);
    public int Login(User user);
    public User getUserDetail(int id);
    List<User> getAllUser(int page, int pageSize);
    void updateUser(User user);
    void deleteUser(int id);
    int adminLogin(String name,String pass);
}
