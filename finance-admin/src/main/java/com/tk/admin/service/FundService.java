package com.tk.admin.service;

import com.tk.common.result.CommonResult;

/**
 * @author kzc
 */
public interface FundService {


    /**
     * 新增基金
     * @param fundNo 基金编号
     * @param fundName 基金名称
     * @param memberId 创建人id
     * @return 新增成功
     */
    CommonResult<Object> insertFund(String fundNo, String fundName, Integer memberId);

    /**
     * @return 基金列表
     */
    CommonResult<Object> FundList();
}
