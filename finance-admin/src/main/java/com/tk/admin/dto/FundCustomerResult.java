package com.tk.admin.dto;

import com.tk.admin.domain.FundCustomer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: tk-finance
 * @description: 客户基金列表返回
 * @author: kzc
 * @create: 2020-07-13 18:05
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class FundCustomerResult extends FundCustomer {

    /**
     * 客户名称
     */
    private String roleName;

    /**
     * 基金编号
     */
    private String fundNo;

    /**
     * 基金名称
     */
    private String fundName;

    /**
     * 信用额度
     */
    private BigDecimal quota;

}
