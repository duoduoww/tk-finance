package com.tk.admin.security;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tk.admin.model.KafkaLogModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: tk-finance
 * @description:
 * @author: kzc
 * @create: 2020-08-29 15:29
 **/
@Component
@PropertySource({"classpath:kafka.properties"})
public class KafkaLogConsumer {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = { "${kafka.topics.log}" })
    public void consumer(String message) {
        ObjectMapper mapper = new ObjectMapper();
        KafkaLogModel kafkaLogModel;
        try {
            kafkaLogModel = mapper.readValue(message, KafkaLogModel.class);
            log.info("收到消息：{}", kafkaLogModel.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
