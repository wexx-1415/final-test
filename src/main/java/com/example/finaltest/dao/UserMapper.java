package com.example.finaltest.dao;

import com.example.finaltest.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper  {
    @Insert("insert ignore into final.user(userName, userPwd) values(#{userName},#{userPwd})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "id")
    int Register(User user);

    @Select("select  * from user where userName=#{userName} and userPwd=#{userPwd}")
    @Results(id = "login",
            value = {
                    @Result(property = "userId", column = "id"),
                    @Result(property = "userName", column = "userName"),
                    @Result(property = "userPwd", column = "userPwd")}
    )
    User Login(User user);
    @Select("select * from user where id=#{arg0}")
    User getUserDetail(int id);
    @Select("select * from user limit #{arg0},#{arg1}")
    @Results(id = "allUser",
            value = {
                    @Result(property = "userId", column = "id"),
                    @Result(property = "userName", column = "userName"),
                    @Result(property = "userPwd", column = "userPwd")}
    )
    List<User> getAllUser(int page, int pageSize);
    @Update("update user set userName=#{userName},userPwd=#{userPwd},address=#{address} where id=#{userId}")
    void updateUser(User user);
    @Delete("delete from user where id =#{arg0}")
    void deleteUser(int id);
    @Select("select COUNT(#{arg0}) from admin where pass=#{arg1}")
    int adminLogin(String name,String pass);
}
