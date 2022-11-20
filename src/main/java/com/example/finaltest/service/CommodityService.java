package com.example.finaltest.service;

import com.example.finaltest.pojo.Commodity;
import com.example.finaltest.pojo.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommodityService {
    List<Commodity> AllCommodity(int page,int pageSize);
    List<Commodity> searchCommodity(String name);
    Commodity getCommodityById(int id);
    List<Commodity> getCommodityByCategory(String category,int page,int pageSize);
    Integer getCountByCategory(String category);
    Integer getPageSizeByCategory(String category,Integer size);
    void addCommodity(Commodity commodity);
    boolean saveFile(MultipartFile file);
    void updateCommodity(Commodity commodity);
    void deleteCommodity(int commodityId);
    Integer getCount();
}
