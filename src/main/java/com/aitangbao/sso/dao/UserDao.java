package com.aitangbao.sso.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.aitangbao.sso.entity.TbUser;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description 用户数据接口层
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<TbUser> {



}
