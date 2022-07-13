package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.Courier;
import cn.edu.cqu.cht.model.Orderlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WJL
 * @date 创建时间：2022年5月31日 20:39
 * @version 1.0
 */
public interface CourierMapper {

    Courier selectByCourierId(Integer courierId);

    List<Courier> selectByCourierName(String courierName);

    List<Courier> selectAllCourier();

    List<Courier> selectCourier(@Param("province") String province,
                                       @Param("city") String city, @Param("area") String area);

    List<Courier> selectByStationId(Integer stationId);

    int insertCourier(Courier courier);

    int insertCourier2(Courier courier);

    int updateByCourierId(Courier courier);

    int deleteByCourierId(Integer courierId);


    List<Orderlist> findMyOrders(Integer courierId);

    List<Orderlist> findOrders(@Param("stationId") Integer stationId, @Param("stationName") String currentName);
}
