package com.tk.admin.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;
import java.util.Date;

/**
 * f_finance_coustomer
 * @author kzc
 */
@TableName(value = "f_finance_customer")
@Alias("financeCustomer")
@Data
public class FinanceCustomer {
    /**
     * 主键
     */
    @Id
    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 收款单号
     */
    @TableField(value = "order_no")
    private String orderNo;

    /**
     * 客户id
     */
    @TableField(value = "customer_id")
    private Integer customerId;

    /**
     * 基金id
     */
    @TableField(value = "fund_id")
    private Integer fundId;

    /**
     * 金额
     */
    @TableField(value = "amount")
    private Double amount;

    /**
     * 本单金额
     */
    @TableField(value = "arrears")
    private Double arrears;

    /**
     * 累计金额
     */
    @TableField(value = "total_arrears")
    private Double totalArrears;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 单据类型（ 1：入账 2：出账 ）
     */
    @TableField(value = "type")
    private Boolean type;

    /**
     * =-1删除,=1有效 =0撤销
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private Integer createUser;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private Date createDate;

    /**
     * 最后更新人
     */
    @TableField(value = "last_user")
    private Integer lastUser;

    /**
     * 最后更新时间
     */
    @TableField(value = "last_date")
    private Date lastDate;
}