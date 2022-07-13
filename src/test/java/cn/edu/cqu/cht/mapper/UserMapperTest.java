package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.User;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年6月1日 11:53
 */
public class UserMapperTest extends BaseTest {
    //为null
    @Test
    public void selectByUserIdTest() {
        SqlSession sqlSession = getSqlSession();
        try {
            User user = sqlSession.selectOne("selectByUserId", 2);
            //System.out.println(user.getPhoneNum());
            TestCase.assertEquals("chttttttt", user.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectAllUserTest() {
        SqlSession session = getSqlSession();
        try {
            List<User> usersList = session.selectList("selectAllUser");
            TestCase.assertTrue(usersList.size() > 0);
        } finally {
            session.close();
        }
    }

}
