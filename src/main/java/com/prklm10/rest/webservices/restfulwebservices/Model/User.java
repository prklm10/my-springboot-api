package com.prklm10.rest.webservices.restfulwebservices.Model;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.sound.sampled.LineListener;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


@Entity
public class User {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2)
	private String name;
	
	@Past()
	 private Date date;
	 
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	 
	
	
	
	public User(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public User() {
		
	}



	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public Date getDate() {
		return date;
	}





	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the posts
	 */
	public List<Post> getPosts() {
		return posts;
	}

	/**
	 * @param posts the posts to set
	 */
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
	}





	
}
