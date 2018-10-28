package com.robot.app.exceptions;

/**
 * Exception class for handling when no further move available forward.
 * 
 * @author Sanal Nair
 *
 */
public class NoMoveForwardException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoMoveForwardException(String msg) {
		super(msg);
	}
}
