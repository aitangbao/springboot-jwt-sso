package com.aitangbao.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description 子系统（域名）管理
 */
@Data
@TableName("tb_domain")
public class TbDomain implements Serializable {

    private int id;
    /**
     * 域名
     */
    private String domain;

    /**
     * 备份字段
     */
    private String remark;

    public TbDomain(String domain, String describe, String remark) {
        this.domain = domain;
        this.remark = remark;
    }

    public TbDomain () {}
}
