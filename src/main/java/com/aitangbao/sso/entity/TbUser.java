package com.aitangbao.sso.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description 用户实体类：13个属性
 */
@Data
@TableName("tb_user")
public class TbUser implements Serializable {

    private int id;
    /**
     * 用户名：邮箱
     */
    private String username;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;


}
