package com.tk.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    @ApiModelProperty(value = "客户名称")
    private String roleName;

    @ApiModelProperty(value = "电话号码")
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
