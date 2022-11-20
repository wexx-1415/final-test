package com.example.finaltest;


import com.example.finaltest.dao.UserMapper;
import com.example.finaltest.pojo.User;
import com.example.finaltest.utils.Jwt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FinalTestApplicationTests {
//    @Autowired
//    private UserMapper userMapper;
    @Test
    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
////        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
//    }
//       User user=new User("s","s");
//        String string = Jwt.sign(user);
        Jwt.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzZXJpYWxQZXJzaXN0ZW50RmllbGRzIjoiW0xqYXZhLmlvLk9iamVjdFN0cmVhbUZpZWxkO0AxNGQwMWFhNCIsIkNBU0VfSU5TRU5TSVRJVkVfT1JERVIiOiJqYXZhLmxhbmcuU3RyaW5nJENhc2VJbnNlbnNpdGl2ZUNvbXBhcmF0b3JAM2UwMDI0NTMiLCJzZXJpYWxWZXJzaW9uVUlEIjoiLTY4NDk3OTQ0NzA3NTQ2Njc3MTAiLCJleHAiOjE2Njc5ODk1NjYsInZhbHVlIjoiW0NANDY1ZjdhYSIsImhhc2giOiI5MjY2ODc1MSJ9.AKVnFNTjF6Da652zTpRYbCyhEO0o4kJphc0ZNPcvSSc");
//        System.out.println(string);
    }

}
