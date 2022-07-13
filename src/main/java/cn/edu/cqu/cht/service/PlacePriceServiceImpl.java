package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.function.CalculatePrice;
import cn.edu.cqu.cht.mapper.PlacePriceMapper;
import cn.edu.cqu.cht.model.Orderlist;
import cn.edu.cqu.cht.model.PlacePrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 21:15
 */
@Service
public class PlacePriceServiceImpl implements PlacePriceService {
    @Autowired
    private PlacePriceMapper placePriceMapper;

    @Override
    public Double findPlaceToPrice(Orderlist order) {
        PlacePrice one = placePriceMapper.selectByProvinceAndCityAndArea(order.getSenderProvince(), order.getSenderCity(), order.getSenderArea());
        PlacePrice two = placePriceMapper.selectByProvinceAndCityAndArea(order.getRecipientProvince(), order.getRecipientCity(), order.getRecipientArea());
        return CalculatePrice.getInstance().init(order.getWeight(), one.getpLevel(), two.getpLevel(), one.getcLevel(), two.getcLevel(), one.getaLevel(), two.getaLevel());
    }


}
