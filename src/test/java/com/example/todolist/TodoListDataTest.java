package com.example.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.todolist.entities.Task;
import com.example.todolist.repositories.TaskRepository;
import com.example.todolist.services.TaskService;
@SpringBootTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TodoListDataTest {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired 
	private TaskService taskService;
	
	@Test
	public void testDeleteTask() throws ParseException {
		Task task = new Task();
		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		LocalDateTime now = LocalDateTime.now();		
		task.setDescription("description");
		task.setEmail("email");
		task.setEndDate(formatter.parse(now.toString()));
		task.setName("name");
		task.setSeverity("severity");
		task.setStartDate(formatter.parse(now.toString()));
		taskService.createTask(task);
		taskService.deleteTask(task);
		assertTrue(!taskService.existsById(task.getId()));
	}
	@Test
	public void testUpdateTask() throws ParseException {
		Task task = new Task();
		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		LocalDateTime now = LocalDateTime.now();		
		task.setDescription("description");
		task.setEmail("email");
		task.setEndDate(formatter.parse(now.toString()));
		task.setName("name");
		task.setSeverity("severity");
		task.setStartDate(formatter.parse(now.toString()));
		taskRepository.save(task);
		taskService.updateTask(task, "name", now.toString(), now.toString(), "description", "email", "severity");
		assertTrue(task.equals(taskService.getTaskById(task.getId())));
		taskService.deleteTask(task);		
	}
	@Test
	public void testCreateTask() throws ParseException {
		Task task = new Task();
		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		LocalDateTime now = LocalDateTime.now();		
		task.setDescription("description");
		task.setEmail("email");
		task.setEndDate(formatter.parse(now.toString()));
		task.setName("name");
		task.setSeverity("severity");
		task.setStartDate(formatter.parse(now.toString()));
		taskService.createTask(task);
		assertTrue(taskService.existsById(task.getId()));
		taskService.deleteTask(task);		
	}
}
