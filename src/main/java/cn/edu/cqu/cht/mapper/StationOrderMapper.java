package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.StationOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WJL
 * @date 创建时间：2022年5月31日 20:25
 * @version 1.0
 */
public interface StationOrderMapper {

    /**
     * 查询所有快递站的订单
     *
     * @return
     */
    List<StationOrder> selectAllStationOrder();

    /**
     * 根据快递站id查询
     *
     * @param stationId
     * @return
     */
    List<StationOrder> selectByStationId(Integer stationId);

    /**
     * 根据快递单号查询
     *
     * @param orderId
     * @return
     */
    List<StationOrder> selectByOrderId(String orderId);

    /**
     * 根据快递站id和订单号查询
     *
     * @param stationId
     * @param orderId
     * @return
     */
    StationOrder selectByStationIdAndOrderId(Integer stationId, String orderId);

    /**
     * 添加订单号
     *
     * @param stationOrder
     * @return
     */
    int insertStationOrder(StationOrder stationOrder);

    /**
     * 修改订单号和工资
     *
     * @param orderId
     * @param salary
     * @return
     */
    int updateByOrderId(@Param("orderId") String orderId, @Param("salary") Double salary);

    /**
     * 删除订单号和快递站id
     *
     * @param stationId
     * @param orderId
     * @return
     */
    int deleteByStationIdAndOrderId(@Param("stationId") Integer stationId, @Param("orderId") Integer orderId);

}
