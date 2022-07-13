package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.model.StationOrder;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:24
 */
public interface StationOrderService {
    List<StationOrder> findAllStationOrder(int offset, int limit);

    List<StationOrder> findByStationId(Integer stationId, int offset, int limit);

    List<StationOrder> findByOrderId(String orderId, int offset, int limit);

    int findAllByOrderNums(String orderId);

    StationOrder findTheOne(Integer stationId, String orderId);

    boolean insertStationOrder(StationOrder stationOrder);

    boolean updateStationOrder(String orderId, Double salary);

    boolean deleteStationOrder(Integer stationId, Integer orderId);
}
