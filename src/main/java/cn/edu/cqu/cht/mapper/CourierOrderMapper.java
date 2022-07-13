package cn.edu.cqu.cht.mapper;
/**
 * @author CHT
 * @date 创建时间：2018年5月2日 下午3:53:56
 * @version 1.0
 */

import cn.edu.cqu.cht.model.CourierOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourierOrderMapper {

    /**
     * 查找所有快递员接收的快递单号
     *
     * @return
     */
    List<CourierOrder> selectAllCourierOrder();

    /**
     * 根据id查找快递员的信息
     *
     * @param courierId
     * @return
     */
    List<CourierOrder> selectByCourierId(Integer courierId);

    /**
     * 根据订单号查找
     *
     * @param orderId
     * @return
     */
    List<CourierOrder> selectByOrderId(String orderId);

    /**
     * 添加订单号
     *
     * @param courierOrder
     * @return
     */
    int insertCourierOrder(CourierOrder courierOrder);

    /**
     * 更新订单号以及薪水
     *
     * @param orderId
     * @param salary
     * @return
     */
    int updateByOrderId(@Param("orderId") String orderId, @Param("salary") Double salary);

    /**
     * 删除订单号以及快递员的id
     *
     * @param courierId
     * @param orderId
     * @return
     */
    int deleteByCourierIdAndOrderId(@Param("courierId") Integer courierId, @Param("orderId") Integer orderId);
}
