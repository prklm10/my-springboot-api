package com.prklm10.rest.webservices.restfulwebservices.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prklm10.rest.webservices.restfulwebservices.Expections.UserNotFoundException;
import com.prklm10.rest.webservices.restfulwebservices.Model.Post;
import com.prklm10.rest.webservices.restfulwebservices.Model.User;
import com.prklm10.rest.webservices.restfulwebservices.service.PostService;
import com.prklm10.rest.webservices.restfulwebservices.service.UserService;

@RestController
public class PostController {

	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	@GetMapping("/api/users/{id}/posts")
	public List<Post> getAllPost(@PathVariable int id){
		Optional<User> userOptional = userService.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found!");
		}
		return userOptional.get().getPosts();
	}
	
	@PostMapping("/api/users/{id}/posts")
	public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post){
		Optional<User> userOptional = userService.findById(id);
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User not found!");
		}
		User user = userOptional.get();
		post.setUser(user);
		postService.createPost(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}").buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
