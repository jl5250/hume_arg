package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.function.CalculatePrice;
import cn.edu.cqu.cht.mapper.OrderlistMapper;
import cn.edu.cqu.cht.model.Orderlist;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:11
 */
@Service
public class OrderlistServiceImpl implements OrderlistService {

    @Autowired
    private OrderlistMapper orderMapper;

    @Override
    public List<Orderlist> findAllOrders(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return orderMapper.selectAllOrder();
    }

    @Override
    public List<Orderlist> findActiveOrders(String province, String city, String area, int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return orderMapper.selectActiveOrder(province, city, area);
    }

    @Override
    public List<Orderlist> findByRecipientPhone(String recipientPhone, int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return orderMapper.selectByRecipientPhone(recipientPhone);
    }

    @Override
    public Orderlist findByOrderId(String orderId) {
        return orderMapper.selectByOrderId(orderId);
    }

    @Override
    public boolean insertOrder(Orderlist order) {
        return orderMapper.insertOrder(order) == 1;
    }

    @Override
    public boolean addOrder(String orderId, Integer userId, String senderName, String senderPhone,
                            String senderProvince, String senderCity, String senderArea, String senderAddr, String recipientName,
                            String recipientPhone, String recipientProvince, String recipientCity, String recipientArea,
                            String recipientAddr, String kind, Double weight, String notes) {
        Orderlist order = new Orderlist();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setSenderName(senderName);
        order.setSenderPhone(senderPhone);
        order.setSenderProvince(senderProvince);
        order.setSenderCity(senderCity);
        order.setSenderArea(senderArea);
        order.setSenderAddr(senderAddr);
        order.setRecipientName(recipientName);
        order.setRecipientPhone(recipientPhone);
        order.setRecipientProvince(recipientProvince);
        order.setRecipientCity(recipientCity);
        order.setRecipientArea(recipientArea);
        order.setRecipientAddr(recipientAddr);
        order.setKind(kind);
        order.setWeight(weight);
        order.setMoney(CalculatePrice.getInstance().init2(weight, senderProvince, senderCity, senderArea,
                recipientProvince, recipientCity, recipientArea));
        order.setNotes(notes);
        order.setCurrentProvince(senderProvince);
        order.setCurrentCity(senderCity);
        order.setCurrentArea(senderArea);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setTime(format.format(new Date()));
        return orderMapper.insertOrder(order) == 1;
    }

    @Override
    public boolean updateOrder(Orderlist order) {
        return orderMapper.updateByOrderId(order) == 1;
    }

    @Override
    public boolean deleteByOrderId(Integer orderId) {
        return orderMapper.deleteByOrderId(orderId) == 1;
    }

    @Override
    public ArrayList<String> showLogistics(String logisticsState) {
        StringBuilder temp = new StringBuilder();
        ArrayList<String> logistics = new ArrayList<>();
        for (int i = 0; i < logisticsState.length(); i++) {
            if (logisticsState.charAt(i) != '-') {
                temp.append(logisticsState.charAt(i));
            } else {
                logistics.add(temp.toString());
                temp = new StringBuilder();
            }
        }
        return logistics;
    }

    @Override
    public List<Orderlist> findByUserId(Integer userId, int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return orderMapper.selectByUserId1(userId);
    }

}
