package com.tk.admin.controller;

import com.tk.admin.service.FundService;
import com.tk.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tk-finance
 * @description: 基金管理
 * @author: kzc
 * @create: 2020-07-11 17:29
 **/
@RestController
@Slf4j
@Api(tags = "基金管理")
@RequestMapping("/fund")
public class FundController {

    @Autowired
    private FundService fundService;

    /**
     * 新增基金
     */
    @PostMapping("/insert")
    @ApiOperation(value = "新增基金")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fundNo",value = "手机电话",required = true),
            @ApiImplicitParam(name = "fundName",value = "登录账号",required = true),
            @ApiImplicitParam(name = "memberId",value = "操作人id",required = true)
    })
    @ResponseBody
    public CommonResult<Object> insertFund(String fundNo, String fundName, Integer memberId){

        return fundService.insertFund(fundNo, fundName,memberId);
    }

    /**
     * 基金列表
     */
    @PostMapping("/fundList")
    public CommonResult<Object> FundList(){

        return fundService.FundList();
    }

}
