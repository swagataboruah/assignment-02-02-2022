package com.zee.zee5_app.Exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidNameException extends Exception {
	public InvalidNameException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}