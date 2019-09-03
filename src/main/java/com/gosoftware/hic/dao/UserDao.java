package com.gosoftware.hic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosoftware.hic.model.User;
import com.gosoftware.hic.repo.UserRepository;


@Service
public class UserDao {
	
	@Autowired
	UserRepository userRepository;
	
	//save user
	
	public User save(User user) {
		
		return userRepository.save(user);
		
	}
	
	
	 //find all users
	
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}
	
	// find single user
	
	public User findOne(String emailid) {
		
		return userRepository.findOneByemailid(emailid);
		
	}
	
	public String deleteUser(User user) {
		
		userRepository.delete(user);
		return "User deleted successfully";
		
	}
	public String deleteAll() {
		
		userRepository.deleteAll();
		return "All users has been deleted";
		
	}

}
