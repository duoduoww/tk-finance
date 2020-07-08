package com.tk.admin.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;
import java.util.Date;

/**
 * f_customer
 * @author kzc
 */
@TableName(value = "f_customer")
@Alias("customer")
@Data
public class Customer {
    /**
     * 
     */
    @Id
    @TableField(value = "id")
    private Integer id;

    /**
     * 客户名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 别名
     */
    @TableField(value = "alias")
    private String alias;

    /**
     * 手机号码
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 职位
     */
    @TableField(value = "position")
    private String position;

    /**
     * 信用额度
     */
    @TableField(value = "quota")
    private Double quota;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 负责人ID
     */
    @TableField(value = "member_id")
    private Long memberId;

    /**
     * '省份id'
     */
    @TableField(value = "province")
    private Integer province;

    /**
     * '城市id'
     */
    @TableField(value = "city")
    private Integer city;

    /**
     * 地域id
     */
    @TableField(value = "region")
    private Integer region;

    /**
     * 状态（0：正常， 1：停用)
     */
    @TableField(value = "status")
    private Boolean status;

    /**
     * 初始值
     */
    @TableField(value = "initial_value")
    private String initialValue;

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