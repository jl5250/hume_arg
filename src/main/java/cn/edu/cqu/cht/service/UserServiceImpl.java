package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.mapper.UserMapper;
import cn.edu.cqu.cht.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 21:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return userMapper.selectAllUser();
    }

    @Override
    public User findUserByUserId(Integer userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public boolean addUser(Integer userId, String userName, String userRealName, String phone, String email, String addr) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserRealName(userRealName);
        user.setPhoneNum(phone);
        user.setEmail(email);
        user.setAddr1(addr);

        return userMapper.updateByUserId(user) == 1;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateByUserId(user) == 1;
    }

    @Override
    public boolean deleteByUserId(Integer userId) {
        return userMapper.deleteByUserId(userId) == 1;
    }

}
