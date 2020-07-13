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
 * f_fund
 */
@TableName(value = "f_fund")
@Alias("fund")
@Data
public class Fund {
    /**
     * 主键
     */
    @Id
    @TableField(value = "id")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 基金编码
     */
    @TableField(value = "fund_no")
    private String fundNo;

    /**
     * 基金名称
     */
    @TableField(value = "fund_name")
    private String fundName;

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


    public Fund(){}

    public Fund(String fundNo, String fundName){
        this.fundNo = fundNo;
        this.fundName = fundName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundNo() {
        return fundNo;
    }

    public void setFundNo(String fundNo) {
        this.fundNo = fundNo;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
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