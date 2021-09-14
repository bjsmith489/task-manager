package com.example.todolist.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer>{
	public Iterable<Task> getAllTasksByName(String username);
}
