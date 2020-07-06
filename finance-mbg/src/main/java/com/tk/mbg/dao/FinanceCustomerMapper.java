package com.tk.mbg.dao;

import com.tk.mbg.entity.FinanceCustomer;

public interface FinanceCustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FinanceCustomer record);

    int insertSelective(FinanceCustomer record);

    FinanceCustomer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FinanceCustomer record);

    int updateByPrimaryKey(FinanceCustomer record);
}