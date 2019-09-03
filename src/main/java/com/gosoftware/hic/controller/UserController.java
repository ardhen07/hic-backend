package com.gosoftware.hic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosoftware.hic.dao.UserDao;
import com.gosoftware.hic.model.User;

@RestController
@RequestMapping("/hic")
public class UserController {

	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/saveuser")
	public User createUser(@Valid @RequestBody User user) {
		
		return userDao.save(user);
		
	}
	
	
	@GetMapping("/allusers")
	public List<User> findAllUsers(){
		
		return userDao.findAll();
	}

	@GetMapping("/userByEmail/{emailid}")
	public ResponseEntity<User> findUserByEmail(@PathVariable (value="emailid") String emailid){
		
		User user=userDao.findOne(emailid);
		if (user==null){
			
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok().body(user);
		}
	}
	
	@PutMapping("updateuser/{emailid}")
	
	public ResponseEntity<User> updateUserByEmail(@PathVariable(value="emailid") String emailid, @Valid @RequestBody User userdetails)
	{
		User user=userDao.findOne(emailid);
		if (user==null){
					
					return ResponseEntity.notFound().build();
				}
		
		user.setFullname(userdetails.getFullname());
		user.setEmailid(userdetails.getEmailid());
		user.setPasswood(userdetails.getPasswood());
		user.setPhno(userdetails.getPhno());
		user.setPin(userdetails.getPin());
		user.setImagepath(userdetails.getImagepath());
		user.setCreatedDate(userdetails.getCreatedDate());
		user.setId(userdetails.getId());
		User updatedUser=userDao.save(user);
		
		return ResponseEntity.ok().body(updatedUser);
	}
	
	@DeleteMapping("deleteuser/{emailid}")
	
	public ResponseEntity<User> deleteUserByEail(@PathVariable (value="emailid") String emailid){
		
		User user=userDao.findOne(emailid);
		if(user==null) {
			return ResponseEntity.notFound().build();
			
		}
		userDao.deleteUser(user);
		return ResponseEntity.ok().build();
	}
	
//	@DeleteMapping
//	
//	private   pub() {
//		// TODO Auto-generated method stub
//
//	}
}
