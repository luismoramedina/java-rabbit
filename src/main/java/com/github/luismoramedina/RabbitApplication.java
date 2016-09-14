package com.github.luismoramedina;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.github.luismoramedina.RabbitReceiveConfiguration.QUEUE_NAME;

@SpringBootApplication
public class RabbitApplication {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return strings -> {
			MessageProperties messageProperties = new MessageProperties();
			messageProperties.setContentType("text/plain");
			messageProperties.setHeader("spanTraceId", "boot my id");
			Message msg = new Message("from spring boot".getBytes(), messageProperties);
			rabbitTemplate.convertAndSend(QUEUE_NAME, msg);
		};
	}
}
