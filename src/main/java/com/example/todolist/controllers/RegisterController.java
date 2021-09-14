package com.example.todolist.controllers;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todolist.entities.User;
import com.example.todolist.exceptions.UserExistsException;
import com.example.todolist.services.EmailService;
import com.example.todolist.services.UserService;

@Controller

public class RegisterController {
	@Autowired
	UserService service;
	@Autowired
	EmailService emailService;
	@RequestMapping(value="/display-registration")
	public String displayRegistration() {
		return "display-registration";
	}
	@RequestMapping(value="/register")
	public String register(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password,
							@RequestParam("email") String email) throws UserExistsException, AddressException, MessagingException, IOException {
		try{
			service.addUser(username, password, email);
			emailService.sendmail(email);
		}
		catch(UserExistsException ex) {
			model.addAttribute("error", "error");
			return "display-registration";
		}
		return "login";
	}
}
