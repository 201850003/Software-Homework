package com.ic.secondhandshoppingmall.controller;

import com.ic.secondhandshoppingmall.entity.Commodity;
import com.ic.secondhandshoppingmall.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @PostMapping()
    public void insertCommodity(@RequestParam String name, String id, int num, int price) {
        commodityService.insertCommodity(name,id,num,price);
    }


    @PutMapping("/{id}")
    public void updatePriceById(@PathVariable String id, @RequestParam int price) {
        commodityService.updatePriceById(id, price);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        commodityService.deleteById(id);
    }

    @GetMapping("/{id}")
    public String getAllById(@PathVariable String id) {
        return commodityService.findById(id).toString();
    }

    @GetMapping("/all")
    public String getAll() {
        List<Commodity> list = commodityService.getAll();
        StringBuilder str = new StringBuilder("Commodity List").append("\n");
        for (Commodity c: list) {
            str.append(c.toString()).append("\n");
        }
        return str.substring(0,str.length()-1);
    }

}
