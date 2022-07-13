package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.Courier;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年6月1日 11:48
 */
public class CourierMapperTest extends BaseTest {

    @Test
    public void selectAllTest() {
        SqlSession session = getSqlSession();
        try {
            CourierMapper courierMapper = session.getMapper(CourierMapper.class);
            List<Courier> courierList = courierMapper.selectAllCourier();
            TestCase.assertNotNull(courierList);
            TestCase.assertTrue(courierList.size() > 0);
        } finally {
            session.close();
        }
    }

    //courier为null
    @Test
    public void selectByCourierIdTest() {
        SqlSession session = getSqlSession();
        try {
            CourierMapper courierMapper = session.getMapper(CourierMapper.class);
            Courier courier = courierMapper.selectByCourierId(2);
            TestCase.assertNotNull(courier);
            //TestCase.assertEquals("cht", courier.getCourierName());
        } finally {
            session.close();
        }
    }
}
