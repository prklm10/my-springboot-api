package com.prklm10.rest.webservices.restfulwebservices.Expections;

import java.util.Date;

public class ExceptionResponse {
	// == Fields ==
	private Date timestamp;
	private String message;
	private String details;
	
	//== Constructors
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	// getters
	

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
	
	
}
