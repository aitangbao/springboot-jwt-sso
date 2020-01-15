package com.aitangbao.sso.dao;

import com.aitangbao.sso.entity.TbDomain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zjg
 * @date 2018/8/14 15:23
 * @Description 子系统（域名）管理数据接口层
 */
@Mapper
@Repository
public interface DomainDao extends BaseMapper<TbDomain> {


}
