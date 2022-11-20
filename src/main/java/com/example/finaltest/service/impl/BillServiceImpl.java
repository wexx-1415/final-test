package com.example.finaltest.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.example.finaltest.dao.BillMapper;
import com.example.finaltest.dao.CommodityMapper;
import com.example.finaltest.dao.UserMapper;
import com.example.finaltest.pojo.Bill;
import com.example.finaltest.pojo.BillDetail;
import com.example.finaltest.pojo.Commodity;
import com.example.finaltest.service.BillService;
import com.example.finaltest.utils.Utils;
import org.intellij.lang.annotations.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommodityMapper commodityMapper;
    @Override
    public String addBill(Bill bill) {
        String NanoId=Utils.NanoId();
        bill.setBillId(NanoId);
        bill.setTransactionTime(new Date());
        List<Double> Prices = new ArrayList<Double>();
        List<String> Names=new ArrayList<>();
        List<Integer> Nums=new ArrayList<>();
        List<Integer> Ids= (List<Integer>) bill.getCommodityIds().get("Ids");
        for (Integer id : Ids) {
            System.out.println(Ids.get(0));
            double p = commodityMapper.getCommodityDetail(id).getCommodityPrice();
            String name=commodityMapper.getCommodityDetail(id).getCommodityName();
            Prices.add(p);
            Names.add("\""+name+"\"");
        }
        System.out.println(Names);
        double totalPrice=Prices.stream().reduce(Double::sum).orElse( 0.0);
        bill.setTransactionPrice(JSON.parseObject("{\"price\": "+ Prices +"}"));
        bill.setCommodityNames(JSON.parseObject("{\"Names\": "+ Names +"}"));
        bill.setTotalPrice(totalPrice);
//        bill.setBusinessId(commodityMapper.getCommodityDetail(Integer.parseInt(String.valueOf(Ids.get(0)))).getBusinessId());
        System.out.println(bill);
        billMapper.addBill(bill);
        return NanoId;
    }

    @Override
    public List<Bill> getBillById(int id) {
        return billMapper.getBillById(id);
    }

    @Override
    public List<BillDetail> getAllBill(int page, int pageSize) {
        List<BillDetail> billDetails=billMapper.getAllBill(page,pageSize);

        for (BillDetail billDetail:billDetails){
            billDetail.setUserName(userMapper.getUserDetail(billDetail.getUserId()).getUserName());
        }
        return billDetails;
    }

    @Override
    public void updateBill(String address, String id) {
        billMapper.updateBill(address, id);
    }

    @Override
    public void deleteBill(String id) {
        billMapper.deleteBill(id);
    }

    @Override
    public Integer getCount() {
        return commodityMapper.getCount();
    }


}
