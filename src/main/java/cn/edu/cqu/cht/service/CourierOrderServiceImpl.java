package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.mapper.CourierOrderMapper;
import cn.edu.cqu.cht.model.CourierOrder;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 19:33
 */
@Service
public class CourierOrderServiceImpl implements CourierOrderService {

    @Autowired
    private CourierOrderMapper courierOrderMapper;

    @Override
    public List<CourierOrder> findCourierOrderByCourierId(Integer courierId, int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return courierOrderMapper.selectByCourierId(courierId);
    }

    @Override
    public boolean addCourierOrder(CourierOrder courierOrder) {
        return courierOrderMapper.insertCourierOrder(courierOrder) == 1;
    }

    @Override
    public boolean updateCourierOrder(String orderId, Double salary) {
        List<CourierOrder> list = courierOrderMapper.selectByOrderId(orderId);
        return courierOrderMapper.updateByOrderId(orderId, salary) == list.size();
    }

    @Override
    public boolean delete(Integer courierId, Integer orderId) {
        return courierOrderMapper.deleteByCourierIdAndOrderId(courierId, orderId) == 1;
    }

    @Override
    public int findByOrderIdNums(String orderId) {
        return courierOrderMapper.selectByOrderId(orderId).size();
    }

}
