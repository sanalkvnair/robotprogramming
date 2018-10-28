package com.robot.app.robot;

/**
 * Enum values for valid directions.
 * 
 * @author Sanal Nair
 *
 */
public enum Directions {

	NORTH("N"),
	EAST("Ö"),
	SOUTH("S"),
	WEST("V");
	
	private String code;
	
	Directions(String code) {
		this.code = code;
	}
	
	public String getDirectionCode() {
		return code;
	}
	
}
