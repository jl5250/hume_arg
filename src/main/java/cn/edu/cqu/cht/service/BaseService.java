package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.model.Base;

import java.util.List;

/**
 * @author WJL
 * @date 创建时间：2022年5月31日 19:09
 * @version 1.0
 */
public interface BaseService {
    //查找ID
    Base findById(Integer id);

    //查找用户名
    Base findByAccount(String account);

    //查找全部用户
    List<Base> findAllBase(int offset, int limit);

    //验证登录
    boolean checkLogin(String account, String password, String type);

    //添加用户
    boolean addNewBase(Base base);

    //修改用户
    boolean updatePassword(Base base);

    //删除用户
    boolean deleteById(Integer id);
}
