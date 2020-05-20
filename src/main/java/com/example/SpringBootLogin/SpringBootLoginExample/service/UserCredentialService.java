package com.example.SpringBootLogin.SpringBootLoginExample.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootLogin.SpringBootLoginExample.repository.UserCredentialsRepository;

@Service("userCredentialService")
public class UserCredentialService {
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;
	
//	public String getPassword(String userName) {
//		//String password=userCredentialsRepository.findByName(userName);
//		return password;
//	}
}
