package com.example.finaltest.service;

import com.example.finaltest.dao.BillMapper;
import com.example.finaltest.pojo.Bill;
import com.example.finaltest.pojo.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BillService {
    String addBill(Bill bill);
    List<Bill> getBillById(int id);
    List<BillDetail> getAllBill(int page, int pageSize);
    void updateBill(String address,String id);
    void deleteBill(String id);
    Integer getCount();
}
