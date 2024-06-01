package com.ms.user.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.user.model.User;
import com.ms.user.producer.UserProducer;
import com.ms.user.repositories.UserRepository;



@Service
public class UserServiceImpl implements IUserServices {

	private UserRepository userRepository;
	private UserProducer userProducer;
	
	public UserServiceImpl(UserRepository userRepository,UserProducer userProducer) {
		this.userRepository = userRepository;
		this.userProducer = userProducer;
	}

	@Transactional
	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		user = userRepository.save(user);
		userProducer.publishMessageEmail(user);
		return user;
	}
}
