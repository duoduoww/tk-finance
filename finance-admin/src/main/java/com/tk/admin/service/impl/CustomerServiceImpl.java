package com.tk.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.tk.admin.domain.Customer;
import com.tk.admin.dto.CustomerParam;
import com.tk.admin.mapper.CustomerMapper;
import com.tk.admin.service.CustomerService;
import com.tk.common.result.CommonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author kzc
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CommonResult<Object> signIn(String mobile, String loginIn, String pwd, String roleName, Integer code) {
        Customer c = new Customer();
        c.setMobile(mobile);
        c.setRoleName(roleName);
        c.setLoginIn(loginIn);
        c.setPassword(pwd);
        customerMapper.insert(c);
        return CommonResult.success("创建成功");
    }

    @Override
    public CommonResult<String> phoneCode(String mobile) {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++ ) {
            sb.append(ran.nextInt(10));
        }
        return CommonResult.success(sb.toString());
    }

    @Override
    public CommonResult<Object> updateCustomer(CustomerParam param) {
        Customer c = new Customer();
        BeanUtils.copyProperties(param, c);
        customerMapper.updateById(c);
        return CommonResult.success("更改成功");
    }

    @Override
    public CommonResult<String> customerList(Integer memberId, String search, Integer pageNo, Integer pageSize) {
        Page<Customer> page = new Page<>(pageNo,pageSize);
        customerMapper.queryProductList(page, memberId, search);
        return null;
    }
}
