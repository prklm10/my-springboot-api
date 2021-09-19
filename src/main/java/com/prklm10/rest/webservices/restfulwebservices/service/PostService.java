package com.prklm10.rest.webservices.restfulwebservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prklm10.rest.webservices.restfulwebservices.Model.Post;
import com.prklm10.rest.webservices.restfulwebservices.Repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
}
