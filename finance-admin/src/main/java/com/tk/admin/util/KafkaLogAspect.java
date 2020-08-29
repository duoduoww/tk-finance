package com.tk.admin.util;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.tk.admin.model.KafkaLogModel;


/**
 * @program: tk-finance
 * @description: kafka日志
 * @author: kzc
 * @create: 2020-08-29 15:22
 **/

@Aspect
@Component
@PropertySource({"classpath:kafka.properties"})
public class KafkaLogAspect {
    @Autowired
    private KafkaTemplate<String, KafkaLogModel> kafkaTemplate;

    @Value("${kafka.topics.log}")
    private String logTopics;

    private Logger log = LoggerFactory.getLogger(KafkaLogAspect.class);

    @Around("execution(public * com.tk.admin.service.KafkaService.doTrans(..))")
    public Object doAroundService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        KafkaLogModel kafkaLogModel = new KafkaLogModel();
        kafkaLogModel.setLogType("SERVICE");
        Object[] objs = proceedingJoinPoint.getArgs();
        kafkaLogModel.setReqContent(objs);
        Object obj = proceedingJoinPoint.proceed();
        kafkaLogModel.setResContent(obj);

        log.info("开始发送给kafka，数据{}", kafkaLogModel.toString());
        ProducerRecord<String, KafkaLogModel> record = new ProducerRecord<String, KafkaLogModel>(logTopics,
                kafkaLogModel);
        ListenableFuture<SendResult<String, KafkaLogModel>> future = kafkaTemplate.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, KafkaLogModel>>() {
            @Override
            public void onSuccess(SendResult<String, KafkaLogModel> result) {
                int partition = result.getRecordMetadata().partition();
                log.info("kafka存储partition为{}", partition);
            }

            @Override
            public void onFailure(Throwable ex) {

            }
        });

        log.info("开始发送给kafka，数据{}", kafkaLogModel.toString());
        return obj;
    }

    @Around("execution(public * com.tk.admin.service.KafkaService.*(..))")
    public Object doAroundController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        KafkaLogModel kafkaLogModel = new KafkaLogModel();
        kafkaLogModel.setLogType("CONTROLLER");
        Object[] objs = proceedingJoinPoint.getArgs();
        kafkaLogModel.setReqContent(objs);
        Object obj = proceedingJoinPoint.proceed();
        kafkaLogModel.setResContent(obj);

        log.info("开始发送给kafka，数据{}", kafkaLogModel.toString());
        ProducerRecord<String, KafkaLogModel> record = new ProducerRecord<>(logTopics,
                kafkaLogModel);
        kafkaTemplate.send(record);

        log.info("开始发送给kafka，数据{}", kafkaLogModel.toString());
        return obj;
    }
}