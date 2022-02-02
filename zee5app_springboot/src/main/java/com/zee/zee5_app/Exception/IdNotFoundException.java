
package com.zee.zee5_app.Exception;

import lombok.ToString;

@ToString(callSuper = true)

public class IdNotFoundException extends Exception {

	public IdNotFoundException(String message) {
		super(message);
	}
}
