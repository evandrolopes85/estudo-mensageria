package com.ms.email.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
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
	
	/*@Bean
	public CachingConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory=new CachingConnectionFactory("jackal.rmq.cloudamqp.com");
		connectionFactory.setUsername("pzolrtxn");
		connectionFactory.setPassword("xQzF73huBBbS5NnZRPsYYfxzAFP_beY-");
		connectionFactory.setVirtualHost("pzolrtxn");
		
		//Recommended settings
		 connectionFactory.setRequestedHeartBeat(30);
		 connectionFactory.setConnectionTimeout(30000);
		return connectionFactory;
	}*/
	
	//Bean de conversão, porque vamos receber um json e vamos fazer a conversão para o nosso record
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		ObjectMapper objetMapper = new ObjectMapper();
		return new Jackson2JsonMessageConverter(objetMapper);
	}
}

