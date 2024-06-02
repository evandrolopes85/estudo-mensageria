package com.ms.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
