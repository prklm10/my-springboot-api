package com.prklm10.rest.webservices.restfulwebservices.Controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prklm10.rest.webservices.restfulwebservices.Expections.UserNotFoundException;
import com.prklm10.rest.webservices.restfulwebservices.Model.User;
import com.prklm10.rest.webservices.restfulwebservices.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users")
	public List<User> getAllUser(){
		return userService.findAll();
	}
	@GetMapping("/api/users/{id}")
	public EntityModel<User> getUserById(@PathVariable int id) {
		Optional<User> users =  userService.findById(id);
		if(!users.isPresent()) {
			throw new UserNotFoundException("id :- "+id+" doesn't exist");
		}
		EntityModel<User> model = EntityModel.of(users.get());
		WebMvcLinkBuilder linkToUser = linkTo(methodOn(this.getClass()).getAllUser());
		model.add(linkToUser.withRel("all-users"));
		return model;
	}
	
	@PostMapping("/api/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = userService.createUser(user);
		java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUser.getId()).toUri();	
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/api/users/{id}")
	public void deleteUser(@PathVariable int id ) {
		Optional<User> users =  userService.findById(id);
		if(!users.isPresent()) {
			throw new UserNotFoundException("User not found!");
		}
		else {
			userService.deleteById(id);
		}
	}
	
}
