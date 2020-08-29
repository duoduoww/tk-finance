package com.tk.admin.controller;

import com.tk.admin.model.TransDataModel;
import com.tk.admin.service.KafkaService;
import com.tk.common.result.CommonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @program: tk-finance
 * @description:
 * @author: kzc
 * @create: 2020-08-29 15:32
 **/
@RestController
@RequestMapping("/kafkaTest")
public class KafkaLogController {

    @Autowired
    KafkaService kafkaService;

    /*@GetMapping(value = "/test")
    @ApiOperation(value = "新增客户基金")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "标题",required = true, paramType = "query"),
            @ApiImplicitParam(name = "content",value = "内容",required = true, paramType = "query"),
            @ApiImplicitParam(name = "type",value = "类型",required = true, paramType = "query")
    })
    public CommonResult<Object> test(String title, String content, String type) {
        return kafkaService.doTrans(title, content, type);
    }*/

    @GetMapping(value = "/test")
    @ApiOperation(value = "消息发送测试")
    public CommonResult<TransDataModel> test(@ModelAttribute TransDataModel seccondMqModel) {
        return CommonResult.success(kafkaService.doTrans(seccondMqModel));
    }

    @GetMapping(value = "/test2")
    public CommonResult<TransDataModel> test2(@ModelAttribute TransDataModel seccondMqModel) {
        return CommonResult.success(kafkaService.doTrans(seccondMqModel));
    }
}
