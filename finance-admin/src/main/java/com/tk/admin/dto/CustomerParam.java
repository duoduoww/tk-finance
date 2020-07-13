package com.tk.admin.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.tk.admin.util.PatternUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * @program: tk-finance
 * @description: 客户修改信息
 * @author: kzc
 * @create: 2020-07-11 16:07
 **/
@Data
@ApiModel("/客户类")
public class CustomerParam {


    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 登录账户
     */
    @ApiModelProperty(value = "登录账户", required = true)
    private String loginIn;

    /**
     * 登录密码
     */

    @ApiModelProperty(value = "登录密码", required = true)
    @Length(min = 6,max = 25,message = "密码长度应该在6-25的长度之间")
    private String password;

    @ApiModelProperty(value = "验证码", required = true)
    @Length(max = 6 , min = 6 , message = "验证码只能是6位数")
    private String code;

    @ApiModelProperty(value = "客户名称")
    private String roleName;

    @ApiModelProperty(value = "电话号码",required = true)
    @Pattern(regexp = PatternUtil.PAR_MOBILE)
    private String mobile;

    @ApiModelProperty(value = "客户地址")
    private String address;

    @ApiModelProperty(value = "客户职位")
    private String position;

    @ApiModelProperty(value = "负责人id")
    private Integer memberId;

    @ApiModelProperty(value = "省份id")
    private Integer province;

    @ApiModelProperty(value = "城市id")
    private Integer city;

    @ApiModelProperty(value = "地域id")
    private Integer region;

}
