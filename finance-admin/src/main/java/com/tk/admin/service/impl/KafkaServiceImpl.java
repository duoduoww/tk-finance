package com.tk.admin.service.impl;

import com.tk.admin.model.TransDataModel;
import com.tk.admin.service.KafkaService;
import com.tk.common.result.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @program: tk-finance
 * @description:
 * @author: kzc
 * @create: 2020-08-29 15:33
 **/
@Service
public class KafkaServiceImpl implements KafkaService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /*@Override
    public CommonResult<Object> doTrans(String title, String content, String type) {

        log.info("处理消息{}", title +"  "+ content + "  " +type);

        return CommonResult.success("1111");
    }*/

    @Override
    public TransDataModel doTrans(TransDataModel seccondMqModel) {

        log.info("处理消息{}", seccondMqModel);

        seccondMqModel.setType("1111");

        return seccondMqModel;
    }
}
