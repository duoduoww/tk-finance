package com.tk.admin.controller;

import com.tk.admin.dto.CustomerParam;
import com.tk.admin.service.CustomerService;
import com.tk.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

    @GetMapping("/phoneCode")
    @ApiOperation(value = "获取手机验证码")
    @ApiImplicitParam(name = "mobile",value = "手机电话",required = true)
    @ResponseBody
    public CommonResult<String> phoneCode(String mobile){

        return customerService.phoneCode(mobile);
    }

    @GetMapping("/updateCustomer")
    @ApiOperation(value = "更改客户信息")
    @ApiImplicitParam(name = "mobile",value = "手机电话",required = true)
    @ResponseBody
    public CommonResult<Object> updateCustomer(@ApiIgnore @RequestBody CustomerParam param){

        return customerService.updateCustomer(param);
    }

    @GetMapping("/customerList")
    @ApiOperation(value = "客户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "负责人id", required = true),
            @ApiImplicitParam(name = "search", value = "search", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "第几页", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页行数", required = false, paramType = "query")
    })
    @ResponseBody
    public CommonResult<String> customerList(Integer memberId, String search, Integer pageNo, Integer pageSize){

        return customerService.customerList(memberId,search, pageNo, pageSize);
    }

}
