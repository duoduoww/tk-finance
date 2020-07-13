package com.tk.admin.service;

import com.tk.admin.dto.CustomerParam;
import com.tk.common.result.CommonResult;

/**
 * @author kzc
 */
public interface CustomerService {
    /**
     * 创建用户
     * @param mobile 手机号
     * @param name 登录账户
     * @param pwd  密码
     * @param alias 账户名称
     * @param code 验证码
     * @return
     */
    CommonResult<Object> signIn(String mobile, String name, String pwd, String alias, Integer code);

    CommonResult<Object> signIn(CustomerParam param);

    /**
     * 手机号验证码
     * @param mobile 手机号
     * @return 验证码
     */
    CommonResult<String> phoneCode(String mobile);

    /**
     * 修改客户信息
     * @param param 客户信息
     * @return 修改成功
     */
    CommonResult<Object> updateCustomer(CustomerParam param);

    /**
     * 客户列表
     * @param memberId 负责人id
     * @return 客户列表
     */
    CommonResult<String> customerList(Integer memberId, String search, Integer pageNo, Integer pageSize);
}
