package com.example.todolist.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.todolist.services.TaskService;

@Controller
public class HomeController {
	
	@Autowired
	TaskService service;
	
	@RequestMapping(value="/tasks")
	public String displayTasks(ModelMap model) {
		String name = (String) model.get("name");
		model.put("tasks",  service.getAllTasks());
		return "home";
	}
	@RequestMapping("/login")
	public String loginPage() {
		return "login";	
	}
	@RequestMapping("/logout-success")
	public String logoutPage() {
		return "logout";	
	}
}
