package com.example.finaltest.pojo;

import com.alibaba.fastjson2.JSONObject;
import com.example.finaltest.utils.JsonResult;

public class Commodity {
    private int CommodityId;

    public String getCategory() {
        return Category;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "CommodityId=" + CommodityId +
                ", CommodityName='" + CommodityName + '\'' +
                ", Category='" + Category + '\'' +
                ", CommodityDes='" + CommodityDes + '\'' +
                ", Nums=" + Nums +
                ", CommodityPrice=" + CommodityPrice +
                ", CommodityPicPath='" + CommodityPicPath + '\'' +
                '}';
    }

    public void setCategory(String category) {
        Category = category;
    }

    private String CommodityName;
    private String Category;
    public int getNums() {
        return Nums;
    }

    public void setNums(int nums) {
        Nums = nums;
    }

    private String CommodityDes;
    private int Nums;

//    public JSONObject getModels() {
//        return Models;
//    }

//    public void setModels(JSONObject models) {
//        Models = models;
//    }

    private double CommodityPrice;
//    private JSONObject Models;

//    private int BusinessId;

//    public int getBusinessId() {
//        return BusinessId;
//    }

//    public void setBusinessId(int businessId) {
//        BusinessId = businessId;
//    }

    public int getCommodityId() {
        return CommodityId;
    }

    public void setCommodityId(int commodityId) {
        CommodityId = commodityId;
    }

    private String CommodityPicPath;

    public String getCommodityName() {
        return CommodityName;
    }

    public void setCommodityName(String commodityName) {
        CommodityName = commodityName;
    }

    public String getCommodityDes() {
        return CommodityDes;
    }

    public void setCommodityDes(String commodityDes) {
        CommodityDes = commodityDes;
    }

    public double getCommodityPrice() {
        return CommodityPrice;
    }

    public void setCommodityPrice(double commodityPrice) {
        CommodityPrice = commodityPrice;
    }

    public String getCommodityPicPath() {
        return CommodityPicPath;
    }

    public void setCommodityPicPath(String commodityPicPath) {
        CommodityPicPath = commodityPicPath;
    }
}
