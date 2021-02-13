package com.thiago.clientes.services.exceptions;

public class ElementNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ElementNotFoundException(String msg) {
		super(msg);
	}
	
}
