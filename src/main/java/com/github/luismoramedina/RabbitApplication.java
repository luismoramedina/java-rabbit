package com.github.luismoramedina;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import static com.github.luismoramedina.RabbitReceiveConfiguration.QUEUE_NAME;

@SpringBootApplication
public class RabbitApplication {

	@Autowired
	RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitApplication.class, args);
	}

	@EventListener
	public void sendMessages(final ApplicationReadyEvent event) {
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return strings -> {
            rabbitTemplate.convertAndSend(QUEUE_NAME, "from spring boot");
            rabbitTemplate.convertAndSend(QUEUE_NAME, "from spring boot 2");
        };
	}
}
