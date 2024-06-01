package com.ms.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
