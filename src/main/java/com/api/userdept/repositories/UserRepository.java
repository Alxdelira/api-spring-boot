package com.api.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.userdept.entities.User;
//Repositório de dados
public interface UserRepository  extends JpaRepository<User, Long>{
  
}
