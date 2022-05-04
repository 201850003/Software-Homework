package model.vo;

import com.ic.secondhandshoppingmall.entity.Commodity;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CommodityVO {

    @Autowired
    private Commodity commodity;

    private String name = commodity.getName();
    private String id = commodity.getId();
    private int num = commodity.getNum();
    private int price = commodity.getPrice();

}
