package com.cnaps.security.services;

import org.springframework.security.core.AuthenticationException;

public class MatriculeNotFoundException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MatriculeNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	public MatriculeNotFoundException(String msg,  Throwable cause) {
		super(msg ,  cause);
		// TODO Auto-generated constructor stub
	}
}
