package com.tk.admin.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * f_fund_customer
 */
@TableName(value = "f_fund_customer")
@Alias("fundCustomer")
@Data
public class FundCustomer implements Serializable {
    /**
     * 主键
     */
    @Id
    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getLastUser() {
        return lastUser;
    }

    public void setLastUser(Integer lastUser) {
        this.lastUser = lastUser;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
}