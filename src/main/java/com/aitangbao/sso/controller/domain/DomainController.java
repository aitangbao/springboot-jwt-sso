package com.aitangbao.sso.controller.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aitangbao.sso.entity.TbDomain;
import com.aitangbao.sso.service.DomainService;
import com.aitangbao.sso.util.Result.Result;
import com.aitangbao.sso.util.Result.ResultCodeEnum;

import java.util.List;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description 子系统(域名)管理控制层
 */
@Slf4j
@RestController
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @GetMapping
    public Result<List<TbDomain>> getAllDomain () {
        List<TbDomain> domainList = domainService.selectAll();
        return new Result<>(ResultCodeEnum.SELECTSUCCESS,null,domainList);
    }

}
