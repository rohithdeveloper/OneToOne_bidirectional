package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserDetail;

public interface UserDetailService {
	UserDetail save(UserDetail userDetail);
	List<UserDetail> getDetails();
	UserDetail getDetailsById(long id);
	String updateDetails(long id,UserDetail userDetail);
	void deleteAll();
	String deleteDetails(long id);
}
