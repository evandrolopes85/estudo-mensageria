package com.ms.user.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ms.user.dto.EmailDTO;
import com.ms.user.model.User;

@Component
public class UserProducer {

	// essa classe que vai ser a publicação das mensagens para o broker
	
	final RabbitTemplate rabbitTemplate;
	
	public UserProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Value(value = "{broker.queue.email.name}") // exchange do tipo default: chave routing key é o mesmo nome da fila
	private String routingKey;
	
	public void publishMessageEmail(User user) {
		var emailDTO = new EmailDTO();
		emailDTO.setIdUser(user.getIdUser());
		emailDTO.setEmailTo(user.getEmail());
		emailDTO.setSubject("Cadastro realizado com sucesso!");
		emailDTO.setText(user.getName() + ", seja bem vindo(a)!\nAgradecemos os seu cadastro, aproveite agora todos os recursos da nossa plataforma");
		
		// 3 informações, exchange, routingkey e qual o email(corpo da mensagem)
		// passa o excchange como uma string vazia que ele ja vai saber que é o exchange default
		// e como exchange é default o nome da routing key tem que ser o nome da fila que vai receber esta mensagem para rotear pelo consumer.
		rabbitTemplate.convertAndSend("", routingKey, emailDTO);
	}
}
