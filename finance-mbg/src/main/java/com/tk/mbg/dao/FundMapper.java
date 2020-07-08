package com.tk.mbg.dao;

import com.tk.mbg.entity.Fund;

public interface FundMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fund record);

    int insertSelective(Fund record);

    Fund selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
}