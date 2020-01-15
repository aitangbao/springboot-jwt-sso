package com.aitangbao.sso.service.serviceimpl;

import com.aitangbao.sso.service.DomainService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aitangbao.sso.dao.DomainDao;
import com.aitangbao.sso.entity.TbDomain;

import java.util.List;

/**
 * @author zjg
 * @date 2018/8/14 15:21
 * @Description 子系统（域名）管理业务层实现类
 */
@Service
public class DomainServiceimpl implements DomainService {

    @Autowired
    private DomainDao domainDao;

    @Override
    public List<TbDomain> selectAll() {
        return domainDao.selectList(new QueryWrapper<>());
    }
}
