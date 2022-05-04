package com.ic.secondhandshoppingmall.service;

import com.ic.secondhandshoppingmall.dao.CommodityDao;
import com.ic.secondhandshoppingmall.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {

    @Autowired
    private CommodityDao commodityDao;


    public void insertCommodity(String name, String id, int num, int price) {
        commodityDao.insertCommodity(name,id,num,price);
    }

    public void deleteById(String id) {
        commodityDao.deleteById(id);
    }

    public void updatePriceById(String id, int price) {
        commodityDao.updatePriceById(id, price);
    }

    public Commodity findById(String id) {
        return commodityDao.findById(id);
    }

    public List<Commodity> getAll() {
        return commodityDao.getAll();
    }




}
