package com.example.todolist.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todolist.configurations.AppConfig;
import com.example.todolist.configurations.UserDetailsImpl;
import com.example.todolist.entities.Task;
import com.example.todolist.entities.User;
import com.example.todolist.services.EmailService;
import com.example.todolist.services.TaskService;
import com.example.todolist.services.UserService;

@Controller
public class TaskController {
	@Autowired
	UserService userService;
	@Autowired
	TaskService service;
	@Autowired
	EmailService emailService;
	
	public ModelMap showTasks(ModelMap model) {
		UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user.getUsername());
		//model.addAttribute("email", user.);
		model.put("tasks",  service.getAllTasksByUsername(user.getUsername()));
		return model;
	}
	
	@RequestMapping(value="/")
	public String displayTasks(ModelMap model) {
		model = showTasks(model);
		return "display-task";
	}
	
	
	@RequestMapping(value="/setTask")
	public String setTask(ModelMap model, @RequestParam("name") String name, @RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate,
						@RequestParam(value="isChecked", required=false) String isChecked,  
						@RequestParam("description") String description, @RequestParam("email") String email, 
						@RequestParam("severity") String severity) throws ParseException, AddressException, MessagingException, IOException {
		service.setTask(name,startDate,endDate,description,email,severity);
	    
		if(isChecked != null) 
		{
			try {
				User user = userService.findByUsername(name);
				emailService.sendmail(email);
				emailService.sendmail(user.getEmail());
			}catch(Exception e) {
				
			}
		}
		model = showTasks(model);
		return "display-task";
	}
	@RequestMapping(value="/direct-to-edit-task")
	public String directToEditTask(ModelMap model, @RequestParam("id") Integer id) {
		Task task = service.getTaskById(id);
		model = showTasks(model);
		model.addAttribute("task", task);
		return "edit-task";
	}
	@RequestMapping(value="/delete-task")
	public String deleteTask(ModelMap model, @RequestParam("id") Integer id) {
		service.deleteById(id);
		model = showTasks(model);
		return "display-task";
	}
	@RequestMapping(value="/edit-task")
	public String editTask(ModelMap model) {
		model = showTasks(model);
		return "edit-task";
	}
	@RequestMapping(value="/update-task")
	public String updateTask(ModelMap model, @RequestParam("id") Integer id, @RequestParam("name") String name,
			  @RequestParam("startdate") String startDate, @RequestParam("enddate") String endDate,
			  @RequestParam("description") String description, @RequestParam("email") String email, 
			  @RequestParam("severity") String severity) throws ParseException  {
		Task task = service.getTaskById(id);
		if(!startDate.equals("")) {
			service.updateTaskByStartdate(task,startDate);
		}
		if(!endDate.equals("")) {
			service.updateTaskByEnddate(task,endDate);
		}
		if(!severity.equals("no change")) {
			service.updateTaskBySeverity(task,severity);
		}
		if(!description.equals("")) {
			service.updateTaskByDescription(task,description);
		}
		model = showTasks(model);
		return "display-task";
	}
}
