package com.tk.admin.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.Id;
import java.util.Date;

/**
 * f_customer_operation_log
 * @author kzc
 */
@TableName(value = "f_customer_operation_log")
@Alias("customerOperationLog")
@Data
public class CustomerOperationLog {
    /**
     * 主键
     */
    @Id
    @TableField(value = "id")
    private Integer id;

    /**
     * 客户id
     */
    @TableField(value = "customer_id")
    private Integer customerId;

    /**
     * 操作人
     */
    @TableField(value = "member_id")
    private Integer memberId;

    /**
     * 执行的操作
     */
    @TableField(value = "record")
    private String record;

    /**
     * 操作记录备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * =-1删除,=1有效 =0撤销
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

}