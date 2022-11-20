package com.example.finaltest.controller;

import com.example.finaltest.pojo.Commodity;
import com.example.finaltest.service.CommodityService;
import com.example.finaltest.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class CommodityController {
    @Autowired
    CommodityService commodityService;

    @GetMapping("/commodities")
    public JsonResult<List<Commodity>> getCommodityDetail(Integer page, Integer pageSize) {
        return new JsonResult<>(commodityService.AllCommodity(page * pageSize, pageSize));
    }

    @GetMapping("/search")
    public JsonResult<List<Commodity>> search(String name) {
        return new JsonResult<>(commodityService.searchCommodity(name));
    }

    @GetMapping("/commodity")
    public Commodity getCommodityById(int id) {
        return commodityService.getCommodityById(id);
    }

    @GetMapping("/commodity/category")
    JsonResult<List<Commodity>> getCommodityByCategory(String category, Integer page, Integer pageSize) {
        System.out.println(category);
        System.out.println(page);
        System.out.println(pageSize);
        return new JsonResult<>(commodityService.getCommodityByCategory(category, page * pageSize, pageSize));
    }

    @GetMapping("/commodity/category/max")
    JsonResult<Integer> getPageSizeByCategory(String category, Integer size) {
        return new JsonResult<>(commodityService.getPageSizeByCategory(category, size));
    }

    @PostMapping("/commodity/add")
    JsonResult<Boolean> addCommodity(@RequestParam("file") MultipartFile file, Commodity commodity) {
        System.out.println(commodity);
        System.out.println(file.getOriginalFilename());
        commodity.setCommodityPicPath(file.getOriginalFilename());
        commodityService.addCommodity(commodity);
        commodityService.saveFile(file);
        return new JsonResult<>(true);
    }

    @PostMapping("/commodity/update")
    JsonResult<Boolean> updateCommodity(MultipartFile file, Commodity commodity) {
        System.out.println(commodity);
        try {

            if (file != null) {
                commodity.setCommodityPicPath(file.getOriginalFilename());
                commodityService.saveFile(file);
            } else {
                commodity.setCommodityPicPath(commodityService.getCommodityById(commodity.getCommodityId()).getCommodityPicPath());
            }

            commodityService.updateCommodity(commodity);
            return new JsonResult<>(true);
        } catch (Exception e) {
            return new JsonResult<>(false);
        }
    }

    @PostMapping("/commodity/delete")
    JsonResult<Boolean> deleteCommodity(int commodityId) {
        try {
            commodityService.deleteCommodity(commodityId);
            return new JsonResult<>(true);
        } catch (Exception e) {
            return new JsonResult<>(false);
        }
    }
    @GetMapping("/commodity/count")
    JsonResult<Integer> getCount(){
        return new JsonResult<>(commodityService.getCount());
    }
}
