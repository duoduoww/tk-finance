package com.tk.admin.service.impl;

import com.tk.admin.domain.Fund;
import com.tk.admin.mapper.FundMapper;
import com.tk.admin.service.FundService;
import com.tk.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: tk-finance
 * @description: 基金业务类
 * @author: kzc
 * @create: 2020-07-08 16:50
 **/
public class FundServiceImpl implements FundService {

    @Autowired
    private FundMapper fundMapper;

    @Override
    public CommonResult<Object> insertFund(String fundNo, String fundName, Integer memberId) {
        Fund fund = new Fund(fundNo,fundName);
        fund.setCreateUser(memberId);
        fundMapper.insert(fund);
        return CommonResult.success("新增成功");
    }

    @Override
    public CommonResult<Object> FundList() {

        List<Fund> fundList = fundMapper.selectList(null);
        return CommonResult.success(fundList);
    }


}
