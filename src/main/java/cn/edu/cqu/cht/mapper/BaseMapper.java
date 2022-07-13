package cn.edu.cqu.cht.mapper;

import cn.edu.cqu.cht.model.Base;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 19:13
 */
public interface BaseMapper {
    /**
     * 通过id查询注册用户
     *
     * @param id
     * @return
     */
    Base selectById(Integer id);

    Base selectByAccount(String account);

    List<Base> selectAllBase();


    /**
     * 单纯的插入
     *
     * @param base
     * @return
     */
    int insertBase(Base base);

    /**
     * 返回主键的插入
     *
     * @param base
     * @return
     */
    int insertBase2(Base base);

    /**
     * 修改密码用
     *
     * @param base
     * @return
     */
    int updateByAccount(Base base);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

}
