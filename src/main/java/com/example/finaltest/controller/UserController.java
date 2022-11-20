package com.example.finaltest.controller;

import com.example.finaltest.pojo.User;
import com.example.finaltest.service.UserService;
import com.example.finaltest.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/all")
    JsonResult<List<User>> getAllUser(Integer page,Integer pageSize){
        return new JsonResult<>( userService.getAllUser(page*pageSize,pageSize));
    }
    @PostMapping("user/update")
    JsonResult<Boolean> updateUser(User user){
        userService.updateUser(user);
        return new JsonResult<Boolean>(true);
    }
    @PostMapping("/user/delete")
    JsonResult<Boolean> deleteUser(Integer userId){
        try {
            userService.deleteUser(userId);
            return new JsonResult<>(true);
        }catch (Exception e){
            System.err.println(e);
            return new JsonResult<>(false);
        }
    }

}
