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
import com.example.demo.entity.UserDetail;
import com.example.demo.repository.UserDetailRepository;
import com.example.demo.service.UserDetailService;

@RestController
@RequestMapping("/api")
public class UserDetailController {

	@Autowired
	private UserDetailService detailService;
	
	@PostMapping("/userDetails")
	public UserDetail addUser(@RequestBody UserDetail userDetail) {
		return detailService.save(userDetail);
		
	}
	
	@GetMapping("/userDetails")
	public List<UserDetail> getUsers()
	{
		List<UserDetail> users=detailService.getDetails();
		return users;
	}
	
	@GetMapping("/userDetails/{id}")
	public UserDetail userId(@PathVariable long id) {
		return detailService.getDetailsById(id);
		
		
	}
	
	@PutMapping("/userDetails/{id}")
	public String update(@PathVariable long id,@RequestBody UserDetail userDetail) {
		return detailService.updateDetails(id, userDetail);
		
	}
	@DeleteMapping("/userDetails/{id}")
	public String deleteById(@PathVariable long id)
	{
		return detailService.deleteDetails(id);
	
		
	}
	@DeleteMapping("/userDetails")
	public String delete(UserDetail userDetail)
	{
		detailService.deleteAll();
		return "Deleted Successfully";
	}
}
