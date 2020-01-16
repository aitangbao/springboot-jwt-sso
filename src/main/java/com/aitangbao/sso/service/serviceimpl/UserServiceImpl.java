package com.aitangbao.sso.service.serviceimpl;

import com.aitangbao.sso.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aitangbao.sso.dao.UserDao;
import com.aitangbao.sso.entity.TbUser;
import com.aitangbao.sso.util.MD5Utils;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description 用户业务类
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean insertUser(TbUser tbUser) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", tbUser.getUsername());
        TbUser user = userDao.selectOne(queryWrapper);
        if (user != null) {
            return false;
        }
        userDao.insert(tbUser);
        return true;
    }

    @Override
    public TbUser login(String username, String password) {
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        TbUser user = userDao.selectOne(queryWrapper);
        if (user == null) {
            return null;
        }
        System.out.println(MD5Utils.Encrypt(password,true));
        if (!MD5Utils.Encrypt(password,true).equals(user.getPassword())) {
            return null;
        }
        return user;
    }
}
