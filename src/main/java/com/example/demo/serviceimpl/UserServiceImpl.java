package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> list=userRepo.findAll();
		return list;
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		Optional<User> user=userRepo.findById(id);
		return user.get();
	}

	@Override
	public User saveUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public String updateUser(long id, User user) {
		// TODO Auto-generated method stub
		Optional<User> users=userRepo.findById(id);
		if(users.isPresent())
		{
			User updateUser=users.get();
			updateUser.setFirst_Name(user.getFirst_Name());
			updateUser.setLast_Name(user.getLast_Name());
			updateUser.setEmail(user.getEmail());
			userRepo.save(user);
			return "updated Successfully";
		}else {
			throw new UserNotFoundException("User id not found"+id);
		}
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		userRepo.deleteAll();
	}

	@Override
	public String deleteUser(long id) {
		// TODO Auto-generated method stub
		Optional<User> user=userRepo.findById(id);
		
		if(user.isPresent())
		{
			userRepo.delete(user.get());
			return "deleted Successfully";
		}
		else
		{
			throw new UserNotFoundException("User id not found"+id);
		}
		
	}

}
