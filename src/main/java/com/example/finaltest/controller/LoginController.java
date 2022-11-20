package com.example.finaltest.controller;

import com.example.finaltest.pojo.User;
import com.example.finaltest.utils.Jwt;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.finaltest.service.UserService;
import com.example.finaltest.utils.JsonResult;

//import org.mybatis.spring.mapper.MapperScannerConfigurer;
@RestController
public class LoginController {
    //    UserServiceImpl userService=new UserServiceImpl();
    @Autowired
    UserService userService;

    @GetMapping("/")
    public JsonResult<String> Index() {
        return new JsonResult<>("hell");
    }
    @PostMapping("admin/login")
    public ResponseEntity<JsonResult<String>> adminLogin(String name,String pass){
        if(userService.adminLogin(name,pass)!=0){
            HttpHeaders headers = new HttpHeaders();
            String token = Jwt.sign(name);
            headers.add("Authorization", "Bearer " + token);
            return ResponseEntity.ok().headers(headers).body(new JsonResult<>("登录成功"));
        }else{
            return ResponseEntity.status(403).body(new JsonResult<>("123", "密码错误"));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<JsonResult<Login>> Login(@NotNull User user) {


        HttpHeaders headers = new HttpHeaders();
        try {
            System.out.println(userService.Login(user));
            user.setUserId(userService.Login(user));
            user.setAddress(userService.getUserDetail(user.getUserId()).getAddress());
        } catch (Exception e) {
            return ResponseEntity.status(403).body(new JsonResult<>("123", "密码错误"));
        }
        Login login = new Login(user);
        if (login.getUserId() != 0) {
            String token = Jwt.sign(login);
            headers.add("Authorization", "Bearer " + token);
            return ResponseEntity.ok().headers(headers).body(new JsonResult<>(login));
        } else {
            return ResponseEntity.status(403).body(new JsonResult<>("123", "密码错误"));
        }
    }

    @PostMapping("/register")
    public JsonResult<Login> Register(String userName, String userPwd, String address) {
        User user = new User(userName, userPwd);
        user.setAddress(address);
        user.setUserId(userService.Register(user));
        Login login = new Login(user);
        return new JsonResult<>(login);
//        return  true;
    }

}
