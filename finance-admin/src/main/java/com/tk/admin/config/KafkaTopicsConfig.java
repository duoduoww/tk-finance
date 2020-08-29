package com.tk.admin.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: tk-finance
 * @description:
 * @author: kzc
 * @create: 2020-08-29 15:21
 **/
@Configuration
public class KafkaTopicsConfig {

    @Bean
    public NewTopic logCenter() {
        return new NewTopic("logCenter", 2, (short) 2);
    }

    @Bean
    public NewTopic logTest() {
        return new NewTopic("logCenter_test", 2, (short) 2);
    }
}
