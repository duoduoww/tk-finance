package com.tk.admin.service;

import com.tk.common.result.CommonResult;

/**
 * @program: tk-finance
 * @author: kzc
 * @create: 2020-07-13 15:54
 **/
public interface FundCustomerService {

    /**
     * 新增客户基金
     * @param customerId 客户id
     * @param fundId 基金id
     * @return 是否成功
     */
    CommonResult<Object> addFundCustomer(Integer customerId, Integer fundId, Integer memberId);

    /**
     * 客户基金列表
     * @param customerId 客户id
     * @param search 关键字
     * @return 客户基金列表
     */
    CommonResult<Object> fundCustomerList(Integer customerId, Integer fundId, String search, Integer pageNo, Integer pageSize);
}
