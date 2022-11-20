package com.example.finaltest.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.finaltest.pojo.Bill;
import com.example.finaltest.pojo.BillDetail;
import com.example.finaltest.service.BillService;
import com.example.finaltest.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    BillService billService;

    @PostMapping("/buy")
    String addBill( @RequestParam(value = "CommodityIds") String CommodityIds
            , @RequestParam(value = "UserId") Integer UserId,
                   @RequestParam(value = "Nums") String Nums,
                   @RequestParam(value = "Address")String Address) {
        Bill bill=new Bill();
        JSONObject Ids= JSON.parseObject(CommodityIds);
        JSONObject nums=JSON.parseObject(Nums);
        bill.setCommodityIds(Ids);
        bill.setNums(nums);
        System.out.println(Ids);
        System.out.println(Ids.get("Ids"));
        System.out.println(JSON.parseArray(Ids.get("Ids").toString()));
        bill.setAddress(Address);
        bill.setUserId(UserId);
        return billService.addBill(bill);
    }
    @GetMapping("/user/bills")
    JsonResult<List< Bill>> getBillById(int UserId){
        return new JsonResult<>(billService.getBillById(UserId));

    }
    @GetMapping("/bill/all")
    JsonResult<List<BillDetail>> getAllBill(int page,int pageSize){
        return new JsonResult<>(billService.getAllBill(page*pageSize, pageSize));
    }
    @PostMapping("/bill/delete")
    JsonResult<Boolean> deleteBill(String billId){
        try {
            billService.deleteBill(billId);
            return new JsonResult<>(true);
        }catch (Exception e){
            return new JsonResult<>(false);
        }
    }
    @PostMapping("/bill/update")
    JsonResult<Boolean> updateBill(String address,String billId){
        try {
            billService.updateBill(address, billId);
            return new JsonResult<>(true);
        }catch (Exception e){
            return new JsonResult<>(false);
        }
    }
    @PostMapping("/bill/cancel")
    JsonResult<Boolean> cancelBill(String billId){
        try {
            billService.deleteBill(billId);
            return new JsonResult<>(true);
        }catch (Exception e){
            return new JsonResult<>(false);
        }
    }
}
