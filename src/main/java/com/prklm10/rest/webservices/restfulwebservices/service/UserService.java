package com.prklm10.rest.webservices.restfulwebservices.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prklm10.rest.webservices.restfulwebservices.Model.User;
import com.prklm10.rest.webservices.restfulwebservices.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	public User createUser(User user) {
		return userRepository.save(user);
	}
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}
	public void deleteById(int id) {
		 userRepository.deleteById(id);
	}
}
