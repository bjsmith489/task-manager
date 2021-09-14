package com.example.todolist.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todolist.entities.Task;
import com.example.todolist.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Iterable<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	public Iterable<Task> getAllTasksByUsername(String username) {
		return taskRepository.getAllTasksByName(username);
	}
	public void deleteById(Integer id) {
		taskRepository.deleteById(id);
	}
	public Task getTaskById(Integer id) {
		return taskRepository.findById(id).get();
	}

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public Task updateTask(Task task, String name,String startDate,
			String endDate, String description,
			String email, String severity) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-dd-mm");
		task.setDescription(description);
		task.setEmail(email);
		task.setEndDate(formatter.parse(endDate));
		task.setName(name);
		task.setSeverity(severity);
		task.setStartDate(formatter.parse(startDate));
		taskRepository.save(task);
		return task;
	}

	public void deleteTask(Task task) {
		taskRepository.delete(task);
	}

	public Task setTask(String name,String startDate,
			String endDate, String description,
			String email, String severity) throws ParseException {

		DateFormat formatter = new SimpleDateFormat("yyyy-dd-mm");
		Task task = new Task();
		task.setDescription(description);
		task.setEmail(email);
		task.setEndDate(formatter.parse(endDate));
		task.setName(name);
		task.setSeverity(severity);
		task.setStartDate(formatter.parse(startDate));
		createTask(task);
		return task;
	}
	public boolean existsById(Integer id) {
		return taskRepository.existsById(id);
	}
	
	public Task updateTaskByDescription(Task task, String description) throws ParseException {
		task.setDescription(description);
		taskRepository.save(task);
		return task;
	}

	public Task updateTaskByStartdate(Task task, String startDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-dd-mm");
		task.setStartDate(formatter.parse(startDate));
		taskRepository.save(task);
		return task;
	}
	
	public Task updateTaskByEnddate(Task task, String endDate) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyyy-dd-mm");
		task.setEndDate(formatter.parse(endDate));
		taskRepository.save(task);
		return task;
	}
	public Task updateTaskBySeverity(Task task, String severity) throws ParseException {
		task.setSeverity(severity);
		taskRepository.save(task);
		return task;
	}
}
