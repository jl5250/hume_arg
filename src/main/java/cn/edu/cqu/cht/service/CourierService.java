package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.model.Courier;
import cn.edu.cqu.cht.model.Orderlist;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 19:24
 */
public interface CourierService {
    //查找所有快递员
    List<Courier> findAllCourier(int offset, int limit);

    //根据id查找快递员
    Courier findByCourierId(Integer courierId);

    //根据姓名查找快递员
    List<Courier> findByCourierName(String courierName);

    //根据地区查找快递员
    List<Courier> findCouriers(String province, String city, String area);

    //根据快递站查找快递员
    List<Courier> findByStationId(Integer stationId);

    //添加快递员
    boolean addCourier(Courier courier);

    //修改快递员
    boolean updateCourier(Courier courier);

    //删除快递员
    boolean deleteCourier(Integer courierId);

    //全手动输入添加快递员
    boolean addCourier(Integer courierId, String courierName, String courierPhone, String province, String city, String area);

    //查看可接收的快递
    List<Orderlist> findMyOrders(Integer courierId);

    //精准查找可接收快递
    List<Orderlist> findOrders(Integer stationId, String stationName);
}
