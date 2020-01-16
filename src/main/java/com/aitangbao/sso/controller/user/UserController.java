package com.aitangbao.sso.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aitangbao.sso.entity.TbUser;
import com.aitangbao.sso.service.UserService;
import com.aitangbao.sso.util.Result.Result;
import com.aitangbao.sso.util.Result.ResultCodeEnum;

/**
 * @author aitangbao
 * @date 20120/1/14 15:34
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public Result insertUser (TbUser tbUser) {
        boolean boo = userService.insertUser(tbUser);
        if (boo) {
            return new Result(ResultCodeEnum.INSERTSUCCESS,"添加成功");
        }
        return new Result(ResultCodeEnum.INSERTFAIL,"用户已存在");
    }
}
