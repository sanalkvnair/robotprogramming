package com.robot.app.exceptions;

/**
 * Exception class for handling Invalid commands.
 * 
 * @author Sanal Nair
 *
 */
public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCommandException(String msg) {
		super(msg);
	}
}
