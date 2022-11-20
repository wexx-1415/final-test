package com.example.finaltest.dao;

import com.example.finaltest.pojo.Bill;
import com.example.finaltest.pojo.BillDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BillMapper {
    @Insert("insert into bill values(#{BillId},(#{CommodityIds}),#{UserId},(#{TransactionPrice}),#{Address},#{TransactionTime},#{commodityNames},#{totalPrice},#{Nums})")
    void addBill(Bill bill);
    @Select("select * from bill where UserId=#{arg0}")
    List<Bill> getBillById(int id);
    @Select("select * from bill limit #{arg0},#{arg1}")
    List<BillDetail> getAllBill(int page, int pageSize);
    @Update("update bill set Address=#{arg0} where BillId=#{arg1}")
    void updateBill(String address,String id);
    @Delete("delete from bill where BillId=#{arg0}")
    void deleteBill(String id);
}
