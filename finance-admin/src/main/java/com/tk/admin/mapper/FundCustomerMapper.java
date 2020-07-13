package com.tk.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tk.admin.domain.FundCustomer;
import com.tk.admin.dto.FundCustomerResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kzc
 */
public interface FundCustomerMapper extends BaseMapper<FundCustomer> {

    List<FundCustomerResult> queryFundCustomrList(Page<FundCustomer> page, @Param("customerId") Integer customerId, @Param("fundId")  Integer fundId, @Param("search") String search);
}