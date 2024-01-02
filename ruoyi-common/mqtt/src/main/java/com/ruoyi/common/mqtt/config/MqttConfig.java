package com.ruoyi.common.mqtt.config;

import com.ruoyi.common.mqtt.MqttConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description : 启动服务的时候开启监听客户端
 * @Author : Sherlock
 * @Date : 2023/12/7 15:02
 */
@Configuration
public class MqttConfig {
    @Autowired
    private MqttConsumer mqttConsumer;

    /**
     * 订阅mqtt
     *
     * @return
     */
    @Conditional(MqttCondition.class)
    @Bean
    public MqttConsumer getMqttConsumer() {
        mqttConsumer.connect();
        return mqttConsumer;
    }

}
