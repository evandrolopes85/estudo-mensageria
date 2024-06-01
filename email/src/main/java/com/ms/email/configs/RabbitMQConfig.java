package com.ms.email.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RabbitMQConfig {

	@Value("${broker.queue.email.name}")
	private String queue;
	
	@Bean
	public Queue queue() {
		return new Queue(queue, true); //Criando uma nova instancia de Queue e se ela é duravel ou não(Quando o broker cair por um determinado momento
									   //esta fila será preservada
		
		// Assim quando iniciarmos a aplicação ja teremos a nossa fila lá dentro do broker
	}
	
	//Bean de conversão, porque vamos receber um json e vamos fazer a conversão para o nosso record
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper objetMapper = new ObjectMapper();
		return new Jackson2JsonMessageConverter(objetMapper);
	}
}

