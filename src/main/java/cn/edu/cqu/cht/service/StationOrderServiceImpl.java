package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.mapper.StationOrderMapper;
import cn.edu.cqu.cht.model.StationOrder;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:25
 */
@Service
public class StationOrderServiceImpl implements StationOrderService {

    @Autowired
    private StationOrderMapper stationOrderMapper;

    @Override
    public List<StationOrder> findAllStationOrder(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return stationOrderMapper.selectAllStationOrder();
    }

    @Override
    public List<StationOrder> findByStationId(Integer stationId, int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return stationOrderMapper.selectByStationId(stationId);
    }

    @Override
    public List<StationOrder> findByOrderId(String orderId, int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return stationOrderMapper.selectByOrderId(orderId);
    }

    @Override
    public boolean insertStationOrder(StationOrder stationOrder) {
        return stationOrderMapper.insertStationOrder(stationOrder) == 1;
    }

    @Override
    public boolean updateStationOrder(String orderId, Double salary) {
        List<StationOrder> list = stationOrderMapper.selectByOrderId(orderId);
        return stationOrderMapper.updateByOrderId(orderId, salary) == list.size();
    }

    @Override
    public boolean deleteStationOrder(Integer stationId, Integer orderId) {
        return stationOrderMapper.deleteByStationIdAndOrderId(stationId, orderId) == 1;
    }

    @Override
    public StationOrder findTheOne(Integer stationId, String orderId) {
        return stationOrderMapper.selectByStationIdAndOrderId(stationId, orderId);
    }

    @Override
    public int findAllByOrderNums(String orderId) {
        return stationOrderMapper.selectByOrderId(orderId).size();
    }

}
