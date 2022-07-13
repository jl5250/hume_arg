package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.User;

import java.util.List;

/**
 * @author Wjl
 * @version 1.0
 * @date 创建时间：2022年5月31日 20:43
 */
public interface UserMapper {

    /**
     * 通过id查询用户
     *
     * @param userId
     * @return
     */
    User selectByUserId(Integer userId);

    /**
     * 查询所有会员
     *
     * @return
     */
    List<User> selectAllUser();

    /**
     * 添加会员
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 修改会员
     *
     * @param user
     * @return
     */
    int updateByUserId(User user);

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    int deleteByUserId(Integer userId);
}
