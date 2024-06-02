package com.ms.user.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.user.model.UserModel;
import com.ms.user.producer.UserProducer;
import com.ms.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserServices {

	final UserRepository userRepository;
	final UserProducer userProducer;
	
	public UserServiceImpl(UserRepository userRepository,UserProducer userProducer) {
		this.userRepository = userRepository;
		this.userProducer = userProducer;
	}

	@Transactional
	@Override
	public UserModel save(UserModel userModel) {
		// TODO Auto-generated method stub
		userModel = userRepository.save(userModel);
		userProducer.publishMessageEmail(userModel);
		return userModel;
	}
}
