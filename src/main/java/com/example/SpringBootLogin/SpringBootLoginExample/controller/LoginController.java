package com.example.SpringBootLogin.SpringBootLoginExample.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootLogin.SpringBootLoginExample.service.UserCredentialService;

@RestController
public class LoginController {
	@Autowired
	private UserCredentialService userCredentialService;
	
	
	@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "HowToDoInJava Reader !!");
        return "index";
    }
	
	
	@GetMapping("/login")
	public String login(Model model,String error,String logout) {
//		String password=userCredentialService.getPassword("anu");
//		System.out.println("password===="+password);
		if(error != null) {
			 model.addAttribute("error", "Your Username and password invalid !!");
		}
		if(logout != null) {
			 model.addAttribute("message", "You Have been Logout !!");
		}
		return "login";
	}
	
	@GetMapping(value= {"/","/welcome"})
    public String welcome(Model model) {
        //model.addAttribute("message", "HowToDoInJava Reader !!");
        return "welcome";
    }

}
