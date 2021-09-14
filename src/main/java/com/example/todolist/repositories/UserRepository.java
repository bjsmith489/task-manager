package com.example.todolist.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todolist.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	User findByUsername(String username);
	boolean existsByUsername(String username);
}
