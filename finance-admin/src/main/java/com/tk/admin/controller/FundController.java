package com.tk.admin.controller;

import com.alibaba.druid.util.StringUtils;
import com.tk.admin.service.FundService;
import com.tk.common.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            @ApiImplicitParam(name = "fundNo",value = "基金编号",required = true, paramType = "query"),
            @ApiImplicitParam(name = "fundName",value = "基金名称",required = true, paramType = "query"),
            @ApiImplicitParam(name = "memberId",value = "操作人id",required = true, paramType = "query")
    })
    @ResponseBody
    public CommonResult<Object> insertFund(@RequestParam String fundNo, @RequestParam String fundName, @RequestParam Integer memberId){
        if(StringUtils.isEmpty(fundNo)){
            return CommonResult.failed("基金编号不能为空");
        }
        if(StringUtils.isEmpty(fundName)){
            return CommonResult.failed("基金名称不能为空");
        }
        return fundService.insertFund(fundNo, fundName,memberId);
    }

    /**
     * 基金列表
     */
    @ApiOperation(value = "基金列表")
    @PostMapping("/fundList")
    public CommonResult<Object> FundList(){

        return fundService.FundList();
    }

}
