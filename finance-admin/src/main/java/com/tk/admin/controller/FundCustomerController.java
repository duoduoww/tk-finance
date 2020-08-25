package com.tk.admin.controller;

import com.tk.admin.service.FundCustomerService;
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
 * @description: 客户持有基金
 * @author: kzc
 * @create: 2020-07-13 15:53
 **/
@RestController
@Slf4j
@Api(tags = "客户基金管理")
@RequestMapping("/customer")
public class FundCustomerController {

    @Autowired
    private FundCustomerService fundCustomerService;

    @PostMapping("/insert")
    @ApiOperation(value = "新增客户基金")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId",value = "客户id",required = true, paramType = "query"),
            @ApiImplicitParam(name = "fundId",value = "基金Id",required = true, paramType = "query"),
            @ApiImplicitParam(name = "memberId",value = "操作人id",required = true, paramType = "query")
    })
    public CommonResult<Object> addFundCustomer(@RequestParam Integer customerId, @RequestParam Integer fundId, @RequestParam Integer memberId){
        if(customerId == null || customerId <= 0){
            return CommonResult.failed("客户id不能为空");
        }
        if(fundId == null || fundId <= 0){
            return CommonResult.failed("基金id不能为空");
        }
        return fundCustomerService.addFundCustomer(customerId, fundId, memberId);
    }

    @GetMapping("/list")
    @ApiOperation(value = "客户基金列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户id", paramType = "query"),
            @ApiImplicitParam(name = "fundId", value = "基金id", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "search", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "第几页", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页行数", paramType = "query")
    })
    @ResponseBody
    public CommonResult<Object> fundCustomerList(Integer customerId, Integer fundId, String search, Integer pageNo, Integer pageSize){

        return fundCustomerService.fundCustomerList(customerId, fundId, search, pageNo, pageSize);
    }

}
