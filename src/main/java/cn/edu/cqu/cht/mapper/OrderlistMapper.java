package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.Orderlist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:40
 */
public interface OrderlistMapper {

    /**
     * 查询所有订单号
     *
     * @return
     */
    List<Orderlist> selectAllOrder();

    /**
     * 根据id查询订单号
     *
     * @param orderId
     * @return
     */
    Orderlist selectByOrderId(String orderId);

    /**
     * 根据电话号码查询订单号
     *
     * @param recipientPhone
     * @return
     */
    List<Orderlist> selectByRecipientPhone(String recipientPhone);

    /**
     * 根据地区查询订单号
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    List<Orderlist> selectActiveOrder(
            @Param("province") String province,
            @Param("city") String city,
            @Param("area") String area
    );

    /**
     * 根据会员id查询
     *
     * @param userId
     * @return
     */
    List<Orderlist> selectByUserId1(Integer userId);

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    int insertOrder(Orderlist order);

    /**
     * 修改订单
     *
     * @param order
     * @return
     */
    int updateByOrderId(Orderlist order);

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    int deleteByOrderId(Integer orderId);
}
