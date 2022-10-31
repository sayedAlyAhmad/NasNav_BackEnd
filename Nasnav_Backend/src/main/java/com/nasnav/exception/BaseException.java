package com.nasnav.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public abstract class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = -4625962428283901408L;
	private final String message;
	private final String code;
	
	public abstract HttpStatus getStatusCode();

}
