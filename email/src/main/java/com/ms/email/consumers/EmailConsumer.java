package com.ms.email.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.ms.email.dto.EmailRecordDto;

@Component
public class EmailConsumer {

	
	// metodo ouvinte que vai consumir as mensagens desta fila
	@RabbitListener(queues = "${broker.queue.email.name}")
	public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) { // String string){// Antes foi usada um String string para teste que foi enviada da fila
		//System.out.println(string);
		System.out.println(emailRecordDto.emailTo());
	}
}
