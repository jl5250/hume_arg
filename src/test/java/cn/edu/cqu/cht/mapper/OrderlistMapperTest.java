package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.Orderlist;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年6月1日 11:51
 */
public class OrderlistMapperTest extends BaseTest {

    @Test
    public void selectAllOrderTest() {
        SqlSession session = getSqlSession();
        try {
            List<Orderlist> ordersLsit = session.selectList("selectAllOrder");
            TestCase.assertTrue(ordersLsit.size() > 0);
        } finally {
            session.close();
        }
    }

    @Test
    public void selectByRecipientPhoneTest() {
        SqlSession session = getSqlSession();
        try {
            OrderlistMapper orderMapper = session.getMapper(OrderlistMapper.class);
            Orderlist orders = orderMapper.selectByOrderId("20180516041224246374");
            TestCase.assertEquals("18034830302", orders.getRecipientPhone());
        } finally {
            session.close();
        }
    }
}
