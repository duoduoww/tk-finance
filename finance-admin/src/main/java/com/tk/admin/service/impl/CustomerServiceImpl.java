package com.tk.admin.service.impl;

import com.tk.admin.domain.Customer;
import com.tk.admin.mapper.CustomerMapper;
import com.tk.admin.service.CustomerService;
import com.tk.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
