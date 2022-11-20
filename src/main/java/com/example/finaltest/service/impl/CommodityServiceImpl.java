package com.example.finaltest.service.impl;

import com.example.finaltest.dao.CommodityMapper;
import com.example.finaltest.pojo.Commodity;
import com.example.finaltest.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
@Service
public class CommodityServiceImpl implements CommodityService {
@Autowired
    CommodityMapper commodityMapper;
    @Override
    public List<Commodity> AllCommodity(int page, int pageSize) {
        return commodityMapper.AllCommodity(page,pageSize);
    }

    @Override
    public List<Commodity> searchCommodity(String name) {
        return commodityMapper.searchCommodity(name);
    }

    @Override
    public Commodity getCommodityById(int id) {
        return commodityMapper.getCommodityById(id);
    }

    @Override
    public List<Commodity> getCommodityByCategory(String category,int page,int pageSize) {
        return commodityMapper.getCommodityByCategory(category,page,pageSize);
    }

    @Override
    public Integer getCountByCategory(String category) {
        return commodityMapper.getCountByCategory(category);
    }

    @Override
    public Integer getPageSizeByCategory(String category, Integer size) {
        return (int)Math.ceil( commodityMapper.getCountByCategory(category)/size);
    }

    @Override
    public void addCommodity(Commodity commodity) {
        commodityMapper.addCommodity(commodity);
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        if (file.isEmpty()){
            return false;
        }
        String filename = file.getOriginalFilename(); //获取上传文件原来的名称
        String filePath = "D:\\学习\\编程\\html练习\\.vscode\\boot\\final\\public\\pic\\";
        File temp = new File(filePath);
        if (!temp.exists()){
            temp.mkdirs();
        }

        File localFile = new File(filePath+filename);
        try {
            file.transferTo(localFile); //把上传的文件保存至本地
            System.out.println(file.getOriginalFilename()+" 上传成功");
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void updateCommodity(Commodity commodity) {
        commodityMapper.updateCommodity(commodity);
    }

    @Override
    public void deleteCommodity(int commodityId) {
        commodityMapper.deleteCommodity(commodityId);
    }

    @Override
    public Integer getCount() {
        return commodityMapper.getCount();
    }

}
