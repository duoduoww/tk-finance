package com.tk.admin.service;

import com.tk.admin.model.TransDataModel;
import com.tk.common.result.CommonResult;

/**
 * @program: tk-finance
 * @author: kzc
 * @create: 2020-08-29 15:33
 **/
public interface KafkaService {

   // CommonResult<Object> doTrans(String title, String content, String type);

    // CommonResult<TransDataModel> doTrans(TransDataModel seccondMqModel);

    TransDataModel doTrans(TransDataModel seccondMqModel);
}
