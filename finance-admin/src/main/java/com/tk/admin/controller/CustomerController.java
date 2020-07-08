package com.tk.admin.controller;

import com.tk.admin.service.CustomerService;
import com.tk.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author kzc
 */
@RestController
@Slf4j
@Api(tags = "客户管理")
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    /**
     * 注册  创建用户
     */
    @PostMapping("/signIn")
    @ApiOperation(value = "创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile",value = "手机电话",required = true),
            @ApiImplicitParam(name = "name",value = "登录账号",required = true),
            @ApiImplicitParam(name = "pwd",value = "密码",required = true),
            @ApiImplicitParam(name = "alias",value = "用户名称",required = true),
            @ApiImplicitParam(name = "code",value = "验证码",required = true)
    })
    @ResponseBody
    public CommonResult<Object> signIn(String mobile,String name,String pwd,String alias,Integer code){

        return customerService.signIn(mobile, name, pwd, alias, code);
    }

}
