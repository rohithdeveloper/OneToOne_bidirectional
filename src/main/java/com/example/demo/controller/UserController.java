package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
		
	}
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		List<User> users=userService.getAllUsers();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public User userId(@PathVariable long id) {
		return userService.getUserById(id);
		
	}
	
	@PutMapping("/users/{id}")
	public String update(@PathVariable long id,@RequestBody User user) {
		return userService.updateUser(id, user);
		
	}
	@DeleteMapping("/users/{id}")
	public String deleteById(@PathVariable long id)
	{
		return userService.deleteUser(id);
	
		
	}
	@DeleteMapping("/users")
	public String delete(User user)
	{
		 userService.deleteAll();
		return "Deleted Successfully";
	}
	
}
