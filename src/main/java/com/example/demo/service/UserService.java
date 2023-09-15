package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.User;

public interface UserService {
	List<User> getAllUsers();
	User getUserById(long id);
	User saveUser(User user);
	String updateUser(long id,User user);
	void deleteAll();
	String deleteUser(long id);
}
