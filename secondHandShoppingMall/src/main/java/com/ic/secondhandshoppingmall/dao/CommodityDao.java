package com.ic.secondhandshoppingmall.dao;

import com.ic.secondhandshoppingmall.entity.Commodity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommodityDao {

    @Insert("INSERT INTO commodity VALUES (#{name},#{id},#{num},#{price})")
    void insertCommodity(String name, String id, int num, int price);

    @Delete("DELETE FROM commodity WHERE id=#{id}")
    void deleteById(String id);

    @Update("UPDATE commodity SET price=#{price} WHERE id=#{id}")
    void updatePriceById(String id, int price);

    @Select("SELECT * FROM commodity where id = #{id}")
    Commodity findById(String id);

    @Select("SELECT * FROM commodity")
    List<Commodity> getAll();



}
