package com.example.finaltest.pojo;

import com.alibaba.fastjson2.JSONObject;

public class BillDetail extends Bill {
    private String UserName;

    @Override
    public String toString() {
        return "BillDetail{" +
                "UserName='" + UserName + '\'' +
                '}';
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
