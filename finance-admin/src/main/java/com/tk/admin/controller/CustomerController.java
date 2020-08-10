package com.tk.admin.controller;

import com.alibaba.druid.util.StringUtils;
import com.tk.admin.dto.CustomerParam;
import com.tk.admin.service.CustomerService;
import com.tk.admin.util.PatternUtil;
import com.tk.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

   /* *//**
     * 注册  创建用户
     *//*
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
*/

    /**
     * 注册  创建用户
     * @return 是否成功
     */
    @PostMapping("/signIn")
    @ApiOperation(value = "创建用户")
    @ResponseBody
    public CommonResult<Object> signIn(@ModelAttribute CustomerParam param){

        return customerService.signIn(param);
    }

    @PostMapping("/login")
    @ApiOperation("/用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginIn", value = "登录账户", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true,paramType = "query")
    })
    public CommonResult<Object> login(@RequestParam String loginIn, @RequestParam String password, HttpServletRequest request){

        if(password.length() < 6){
            return CommonResult.failed("密码长度小于6");
        }
        return customerService.login(loginIn,password, request);
    }


    @GetMapping("/phoneCode")
    @ApiOperation(value = "获取手机验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机电话", required = true, paramType = "query")
    })
    public CommonResult<String> phoneCode(@RequestParam String mobile){
        if(StringUtils.isEmpty(mobile)){
            return CommonResult.failed("手机号不能为空");
        }
        if(!PatternUtil.isMobile(mobile)){
            return CommonResult.failed("请填写正确手机号");
        }
        return customerService.phoneCode(mobile);
    }

    @GetMapping("/updateCustomer")
    @ApiOperation(value = "更改客户信息")
    @ResponseBody
    public CommonResult<Object> updateCustomer(@ApiIgnore @ModelAttribute CustomerParam param){

        return customerService.updateCustomer(param);
    }

    @GetMapping("/customerList")
    @ApiOperation(value = "客户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "memberId", value = "负责人id", paramType = "query",defaultValue = "0"),
            @ApiImplicitParam(name = "search", value = "search", paramType = "query",defaultValue = ""),
            @ApiImplicitParam(name = "pageNo", value = "第几页", paramType = "query" , defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页行数", paramType = "query",defaultValue = "10")
    })
    @ResponseBody
    public CommonResult<Object> customerList(@RequestParam Integer memberId, @RequestParam String search, @RequestParam Integer pageNo, @RequestParam Integer pageSize){

        return customerService.customerList(memberId,search, pageNo, pageSize);
    }

}
