package com.fdmgroup.ProductsAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundEaception extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ProductNotFoundEaception() {
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundEaception(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundEaception(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundEaception(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProductNotFoundEaception(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
