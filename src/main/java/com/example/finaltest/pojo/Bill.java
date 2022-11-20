package com.example.finaltest.pojo;

import com.alibaba.fastjson2.JSONObject;

import java.util.Date;
public class Bill {
    private String BillId;
    private JSONObject commodityNames;
    private JSONObject Nums;
    private double totalPrice;

    @Override
    public String toString() {
        return "Bill{" +
                "BillId='" + BillId + '\'' +
                ", commodityNames=" + commodityNames +
                ", Nums=" + Nums +
                ", totalPrice=" + totalPrice +
                ", CommodityIds=" + CommodityIds +
                ", UserId=" + UserId +
                ", TransactionPrice=" + TransactionPrice +
                ", Address='" + Address + '\'' +
                ", TransactionTime=" + TransactionTime +
                '}';
    }

    public JSONObject getNums() {
        return Nums;
    }

    public void setNums(JSONObject nums) {
        Nums = nums;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCommodityNames(JSONObject commodityNames) {
        this.commodityNames = commodityNames;
    }

    public JSONObject getCommodityNames() {
        return commodityNames;
    }
    private JSONObject CommodityIds;
    private int UserId;
    private JSONObject TransactionPrice;
    private String Address;
//    private int BusinessId;
    private Date TransactionTime;

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public JSONObject getCommodityIds() {
        return CommodityIds;
    }

    public void setCommodityIds(JSONObject commodityIds) {
        CommodityIds = commodityIds;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public JSONObject getTransactionPrice() {
        return TransactionPrice;
    }

    public void setTransactionPrice(JSONObject transactionPrice) {
        TransactionPrice = transactionPrice;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

//    public int getBusinessId() {
//        return BusinessId;
//    }

//    public void setBusinessId(int businessId) {
//        BusinessId = businessId;
//    }

    public Date getTransactionTime() {
        return TransactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        TransactionTime = transactionTime;
    }
}
