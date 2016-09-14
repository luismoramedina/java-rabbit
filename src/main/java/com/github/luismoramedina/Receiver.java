package com.github.luismoramedina;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;

import static com.github.luismoramedina.RabbitReceiveConfiguration.QUEUE_NAME;

/**
 * @author luismoramedina
 */
public class Receiver {

    @RabbitListener(queues = QUEUE_NAME)
    public void receiveMessage(@Header("spanTraceId") String tracer, String message) {
        System.out.println("message body: " + message);
        System.out.println("header -> tracer:" + tracer);
    }

}