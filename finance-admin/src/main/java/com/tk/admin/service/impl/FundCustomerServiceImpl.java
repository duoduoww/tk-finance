package com.tk.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.tk.admin.domain.Customer;
import com.tk.admin.domain.FundCustomer;
import com.tk.admin.dto.FundCustomerResult;
import com.tk.admin.mapper.FundCustomerMapper;
import com.tk.admin.service.FundCustomerService;
import com.tk.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: tk-finance
 * @description: 客户持有基金
 * @author: kzc
 * @create: 2020-07-13 15:55
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class FundCustomerServiceImpl implements FundCustomerService {

    @Autowired
    private FundCustomerMapper fundCustomerMapper;


    @Override
    public CommonResult<Object> addFundCustomer(Integer customerId, Integer fundId, Integer memberId) {
        FundCustomer fc = new FundCustomer();
        fc.setCustomerId(customerId);
        fc.setFundId(fundId);
        fc.setCreateUser(memberId);
        fundCustomerMapper.insert(fc);
        return CommonResult.failed("新增成功");
    }

    @Override
    public CommonResult<Object> fundCustomerList(Integer customerId, Integer fundId, String search, Integer pageNo, Integer pageSize) {
        Page<FundCustomer> page = new Page<>(pageNo,pageSize);
        List<FundCustomerResult> resultList = fundCustomerMapper.queryFundCustomrList(page,customerId,fundId,search);
        return CommonResult.success(resultList);
    }
}
