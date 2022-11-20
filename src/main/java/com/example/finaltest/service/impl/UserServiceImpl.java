package com.example.finaltest.service.impl;

import com.example.finaltest.dao.UserMapper;
import com.example.finaltest.pojo.User;
import com.example.finaltest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int Register(User user) {
       userMapper.Register(user);
       return user.getUserId();

    }

    @Override
    public int Login(User user) {
        User LoginUser=userMapper.Login(user);
        if(LoginUser==null){
            return 0;
        }
        return LoginUser.getUserId() ;
    }

    @Override
    public User getUserDetail(int id) {
        return userMapper.getUserDetail(id);
    }

    @Override
    public List<User> getAllUser(int page, int pageSize) {
        return userMapper.getAllUser(page,pageSize);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public int adminLogin(String name, String pass) {
        return userMapper.adminLogin(name, pass);
    }

}
