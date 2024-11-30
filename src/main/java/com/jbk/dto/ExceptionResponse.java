package com.jbk.dto;

import java.sql.Timestamp;

public class ExceptionResponse {
	
	private String message;
	private String path;
	private Timestamp timeStamp;
	
	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponse(String message, String path, Timestamp timeStamp) {
		super();
		this.message = message;
		this.path = path;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
