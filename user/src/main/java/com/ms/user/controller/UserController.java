package com.ms.user.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.user.dto.UserRecordDTO;
import com.ms.user.model.User;
import com.ms.user.services.IUserServices;

import jakarta.validation.Valid;

@RestController
public class UserController {

	private IUserServices service;
	
	public UserController(IUserServices service) {
		this.service = service;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO){
		var userModel = new User();
		BeanUtils.copyProperties(userRecordDTO, userModel);
		
		return ResponseEntity.status(201).body(service.save(userModel));
	}
	
}
