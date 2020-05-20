package com.example.SpringBootLogin.SpringBootLoginExample.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootLogin.SpringBootLoginExample.entity.UserCredentials;
import com.example.SpringBootLogin.SpringBootLoginExample.repository.UserCredentialsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredentials userCredentials=userCredentialsRepository.findByUsername(username);
		
		Set < GrantedAuthority > grantedAuthorities= new HashSet< >();
		grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

		return new org.springframework.security.core.userdetails.User(userCredentials.getUsername(), userCredentials.getPassword(), grantedAuthorities);
	}

}
