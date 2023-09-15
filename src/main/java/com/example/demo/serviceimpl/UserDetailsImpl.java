package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserDetail;
import com.example.demo.exception.DetailsNotFoundException;

import com.example.demo.repository.UserDetailRepository;
import com.example.demo.service.UserDetailService;

@Service
public class UserDetailsImpl implements UserDetailService {

	@Autowired
	private UserDetailRepository detailRepo;
	
	@Override
	public UserDetail save(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return detailRepo.save(userDetail) ;
	}

	@Override
	public List<UserDetail> getDetails() {
		// TODO Auto-generated method stub
		List<UserDetail> list=detailRepo.findAll();
		return list;
	}

	@Override
	public UserDetail getDetailsById(long id) {
		// TODO Auto-generated method stub
		Optional<UserDetail> uDetails=detailRepo.findById(id);
		return uDetails.get();
	}

	@Override
	public String updateDetails(long id, UserDetail userDetail) {
		// TODO Auto-generated method stub
		Optional<UserDetail> uDetail=detailRepo.findById(id);
		if(uDetail.isPresent())
		{
			UserDetail updateDetails=uDetail.get();
			updateDetails.setHobby(userDetail.getHobby());
			updateDetails.setYoutubeChannel(userDetail.getYoutubeChannel());
			detailRepo.save(userDetail);
			return "Updated Successfully";
		}
		else {
			throw new DetailsNotFoundException("Details not found"+id);
		}
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		detailRepo.deleteAll();
	}

	@Override
	public String deleteDetails(long id) {
		// TODO Auto-generated method stub
		Optional<UserDetail> uDetails=detailRepo.findById(id);
		if(uDetails.isPresent())
		{
			detailRepo.delete(uDetails.get());
			return "Deleted Successfully";
		}
		else {
			throw new DetailsNotFoundException("Details not found"+id);
		}
	}

}
