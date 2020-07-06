package com.tk.mbg.dao;

import com.tk.mbg.entity.CustomerOperationLog;

public interface CustomerOperationLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerOperationLog record);

    int insertSelective(CustomerOperationLog record);

    CustomerOperationLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerOperationLog record);

    int updateByPrimaryKey(CustomerOperationLog record);
}