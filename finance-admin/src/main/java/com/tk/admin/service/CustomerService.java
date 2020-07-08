package com.tk.admin.service;

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
}
