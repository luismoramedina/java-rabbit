package com.github.luismoramedina;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luismoramedina
 */
@Configuration
public class RabbitReceiveConfiguration {
    public static final String QUEUE_NAME = "hello";

    @Bean
    Queue queue() {
         return new Queue(QUEUE_NAME, false);
    }

    @Bean
    Receiver receiver() {
        return new Receiver();
    }

}
