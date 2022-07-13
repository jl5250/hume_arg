package cn.edu.cqu.cht.service;

import cn.edu.cqu.cht.function.MD5;
import cn.edu.cqu.cht.mapper.BaseMapper;
import cn.edu.cqu.cht.model.Base;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WJL
 * @version 1.0
 * @date 创建时间：2022年5月31日 19:12
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseMapper baseMapper;

    @Override
    public Base findById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Base findByAccount(String account) {
        return baseMapper.selectByAccount(account);
    }

    @Override
    public List<Base> findAllBase(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return baseMapper.selectAllBase();
    }

    @Override
    public boolean checkLogin(String account, String password, String type) {
        if (account.equals("root")) {
            return baseMapper.selectByAccount(account).getPassword().equals(MD5.getInstance().getMD5(password));
        } else {
            switch (type) {
                case "u":
                    account = "u" + account;
                    if (baseMapper.selectByAccount(account) == null) {
                        return false;
                    } else {
                        return baseMapper.selectByAccount(account).getPassword().equals(MD5.getInstance().getMD5(password));
                    }
                case "c":
                    account = "c" + account;
                    if (baseMapper.selectByAccount(account) == null) {
                        return false;
                    } else {
                        return baseMapper.selectByAccount(account).getPassword().equals(MD5.getInstance().getMD5(password));
                    }
                case "s":
                    account = "s" + account;
                    if (baseMapper.selectByAccount(account) == null) {
                        return false;
                    } else {
                        return baseMapper.selectByAccount(account).getPassword().equals(MD5.getInstance().getMD5(password));
                    }
            }
        }
        return false;
    }

    @Override
    public boolean addNewBase(Base base) {
        return baseMapper.insertBase2(base) == 1;
    }

    @Override
    public boolean updatePassword(Base base) {
        return baseMapper.updateByAccount(base) == 1;
    }

    @Override
    public boolean deleteById(Integer id) {
        return baseMapper.deleteById(id) == 1;
    }
}
