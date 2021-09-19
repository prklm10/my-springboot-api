package com.prklm10.rest.webservices.restfulwebservices.Controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prklm10.rest.webservices.restfulwebservices.HelloWorldBean;

@RestController
public class HelloWorldController {

	
	@GetMapping(path = "/api/hello-world")
	public String helloWorld() {
		return "Hello World!";
	}
	
	@GetMapping(path = "/api/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World From Bean");
	}
	@GetMapping(path = "/api/hello-world/path-variable/{name}")
	public HelloWorldBean pathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello %s", name));
	}
	
}
