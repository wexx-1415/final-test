package com.example.finaltest.dao;

import com.example.finaltest.pojo.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommodityMapper {
    @Select("select * from commodity limit #{arg0} , #{arg1}")
    List<Commodity> AllCommodity(int page, int pageSize);

    @Select("select * from commodity where CommodityId=#{arg0}")
    @Results(
            id = "getCommodityDetail",
            value = {
                    @Result(property = "CommodityIds", column = "CommodityIds"),
                    @Result(property = "CommodityName", column = "CommodityName"),
                    @Result(property = "CommodityDes", column = "CommodityDes"),
                    @Result(property = "CommodityPrice", column = "CommodityPrice"),
            }
    )
    Commodity getCommodityDetail(int id);

    @Select("select * from commodity where commodityName like '%${arg0}%' limit 0,10")
    List<Commodity> searchCommodity(String name);
    @Select("select * from commodity where commodityId=#{arg0}")
    Commodity getCommodityById(int id);
    @Select("select * from commodity where Category=#{arg0} limit #{arg1} , #{arg2}")
    List<Commodity> getCommodityByCategory(String category,int page,int pageSize);
    @Select("select count(Category) from commodity where Category=#{arg0}")
    Integer getCountByCategory(String category);
    @Select("select count(CommodityId) from commodity")
    Integer getCount();
    @Insert("insert into commodity( commodityname, commoditydes, commodityprice, commoditypicpath, nums, category) values (#{CommodityName},#{CommodityDes},#{CommodityPrice},#{commodityPicPath},#{Nums},#{Category})")
    void addCommodity(Commodity commodity);
    @Update("update commodity set commodityname=#{CommodityName}, commoditydes=#{CommodityDes}, commodityprice=#{CommodityPrice}, commoditypicpath=#{commodityPicPath}, nums=#{Nums}, category=#{Category} where CommodityId =#{CommodityId}")
    void updateCommodity(Commodity commodity);
    @Delete("delete from commodity where CommodityId=#{arg0}")
    void deleteCommodity(int commodityId);
}
