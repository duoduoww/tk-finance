package com.tk.mbg.dao;

import com.tk.mbg.entity.FundCustomer;

public interface FundCustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FundCustomer record);

    int insertSelective(FundCustomer record);

    FundCustomer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FundCustomer record);

    int updateByPrimaryKey(FundCustomer record);
}