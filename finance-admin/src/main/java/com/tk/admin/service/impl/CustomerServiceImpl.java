package com.tk.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.tk.admin.domain.Customer;
import com.tk.admin.dto.CustomerParam;
import com.tk.admin.mapper.CustomerMapper;
import com.tk.admin.service.CustomerService;
import com.tk.admin.util.AESUtil;
import com.tk.admin.util.MyRedisUtils;
import com.tk.admin.util.SecurityUtils;
import com.tk.common.result.CommonResult;
import com.tk.admin.security.JwtAuthenticatioToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author kzc
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private MyRedisUtils.redisString redisString;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public CommonResult<Object> signIn(String mobile, String loginIn, String pwd, String roleName, Integer code) {
        String rCode = (String)redisString.get(mobile);
        if(rCode == null || !rCode.equals(code)){
            return CommonResult.failed("验证码错误");
        }
        Customer c = new Customer();
        c.setMobile(mobile);
        c.setRoleName(roleName);
        c.setLoginIn(loginIn);
        c.setPassword(AESUtil.AESEncode(pwd));
        customerMapper.insertAllColumn(c);
        return CommonResult.success("创建成功");
    }

    @Override
    public CommonResult<Object> signIn(CustomerParam param){
        String rCode = (String)redisString.get(param.getMobile());
        if(rCode == null || !rCode.equals(param.getCode())){
            return CommonResult.failed("验证码错误");
        }

        String name = customerMapper.checkName(param.getLoginIn());
        if(name != null){
            return CommonResult.failed("登录账户名已存在");
        }
        Customer c = new Customer();
        BeanUtils.copyProperties(param,c);
        c.setPassword(AESUtil.AESEncode(param.getPassword()));
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
        redisString.set(mobile,sb.toString(),300);
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
    public CommonResult<Object> customerList(Integer memberId, String search, Integer pageNo, Integer pageSize) {
        Page<Customer> page = new Page<>(pageNo,pageSize);
        customerMapper.queryProductList(page, memberId, search);
        return CommonResult.success(page);
    }

    @Override
    public Customer findByUsername(String username) {
        Customer c = new Customer();
        c.setLoginIn(username);
        return customerMapper.selectOne(c);
    }

    @Override
    public CommonResult<Object> login(String loginIn, String password, HttpServletRequest request) {
        password = AESUtil.AESEncode(password);
        Customer c = customerMapper.login(loginIn,password);
        if(c == null){
            return CommonResult.failed("账户或密码错误");
        }

        JwtAuthenticatioToken token = SecurityUtils.login(request, loginIn, password, authenticationManager);
        return CommonResult.success(token);
    }
}
