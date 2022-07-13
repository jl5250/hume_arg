package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.model.User;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 19:24
 */
public interface UserService {
    //查找所有的会员
    List<User> findAllUsers(int offset, int limit);

    //根据id查找会员
    User findUserByUserId(Integer userId);

    //添加会员
    boolean addUser(Integer userId, String userName, String userRealName, String phone, String email, String addr);

    //修改会员
    boolean updateUser(User user);

    //删除会员
    boolean deleteByUserId(Integer userId);
}
