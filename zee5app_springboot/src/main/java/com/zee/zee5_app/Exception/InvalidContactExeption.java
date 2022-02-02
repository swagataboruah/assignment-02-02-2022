package com.zee.zee5_app.Exception;
import lombok.ToString;

@ToString(callSuper = true)
public class InvalidContactExeption extends Exception {

	public InvalidContactExeption(String message) {
		super(message);
}

}
