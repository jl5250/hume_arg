package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.model.CourierOrder;

import java.util.List;

/**
 * @author WJL
 * @date 创建时间：2022年5月31日 20:23
 * @version 1.0
 */
public interface CourierOrderService {
    List<CourierOrder> findCourierOrderByCourierId(Integer courierId, int offset, int limit);

    boolean addCourierOrder(CourierOrder courierOrder);

    boolean updateCourierOrder(String orderId, Double salary);

    boolean delete(Integer courierId, Integer orderId);

    int findByOrderIdNums(String orderId);
}
