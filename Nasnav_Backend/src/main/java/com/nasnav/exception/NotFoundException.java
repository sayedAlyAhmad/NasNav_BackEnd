package com.nasnav.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException  extends BaseException{

	private static final long serialVersionUID = -5145678421121373773L;

	public NotFoundException(String message, String code) {
		super(message, code);
	}

	@Override
	public HttpStatus getStatusCode() {
		// TODO Auto-generated method stub
		return HttpStatus.NOT_FOUND;
	}
}
