package com.app.exception;

@SuppressWarnings("serial")
public class ModuleNotFoundException extends RuntimeException {

	public ModuleNotFoundException(String message) {
		super(message);
	}
}
