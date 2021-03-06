package com.tk.admin.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.tk.admin.domain.Customer;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author kzc
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

    List<Customer> queryProductList(Pagination page, @Param("memberId") Integer memberId, @Param("search")  String search);

    String checkName(@Param("loginIn") String loginIn);

    Customer login(@Param("loginIn") String loginIn, @Param("password") String password);
}