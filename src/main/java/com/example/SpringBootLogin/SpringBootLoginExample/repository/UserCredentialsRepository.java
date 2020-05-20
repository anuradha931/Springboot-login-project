package com.example.SpringBootLogin.SpringBootLoginExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootLogin.SpringBootLoginExample.entity.UserCredentials;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials,String> {
	UserCredentials findByUsername(String username);
}



