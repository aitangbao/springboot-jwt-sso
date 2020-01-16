package com.aitangbao.sso.service;

import org.springframework.transaction.annotation.Transactional;
import com.aitangbao.sso.entity.TbDomain;

import java.util.List;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description 子系统（域名）管理业务层接口
 */
public interface DomainService {

    /**
     * 查询全部
     * @return list
     */
    @Transactional
    List<TbDomain> selectAll ();

}
