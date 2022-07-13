package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.model.Orderlist;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 21:14
 */
public interface PlacePriceService {
    public Double findPlaceToPrice(Orderlist order);
}
