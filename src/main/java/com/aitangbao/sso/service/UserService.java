package com.aitangbao.sso.service;

import org.springframework.transaction.annotation.Transactional;
import com.aitangbao.sso.entity.TbUser;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description 用户业务层接口
 */
public interface UserService {


    /**
     * 添加用户
     * @param tbUser 用户信息
     * @return 当添加成功时返回true
     */
    @Transactional
    boolean insertUser(TbUser tbUser);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 如果用户存在返回user，反之为null
     */
    TbUser login(String username, String password);
}
