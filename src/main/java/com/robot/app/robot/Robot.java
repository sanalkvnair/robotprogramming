package com.robot.app.robot;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.robot.app.commands.Command;
import com.robot.app.commands.MoveForwardCommand;
import com.robot.app.commands.TurnLeftCommand;
import com.robot.app.commands.TurnRightCommand;
import com.robot.app.exceptions.InvalidCommandException;
import com.robot.app.exceptions.NoMoveForwardException;
import com.robot.app.room.Room;

/**
 * Class for handling Robot functionalities.
 * 
 * @author Sanal Nair
 *
 */
public class Robot {
	
	private Room room;
	private String commands;
	private Map<Character, Command> executionCommands;
	
	public Robot(Room room, String commands, String langCode) {
		this.room = room;
		this.commands = commands;
		initExecutionCommands(langCode, this.room);
	}
	
	/**
	 * Init method for initializing commands based on language code.
	 * 
	 * @param langCode
	 * @param room
	 */
	private void initExecutionCommands(String langCode, Room room) {
		if(langCode.equalsIgnoreCase("SE")) {
			executionCommands = new HashMap<>();
			executionCommands.put('V', new TurnLeftCommand(room));
			executionCommands.put('H', new TurnRightCommand(room));
			executionCommands.put('G', new MoveForwardCommand(room));
		} else {
			executionCommands = new HashMap<>();
			executionCommands.put('L', new TurnLeftCommand(room));
			executionCommands.put('R', new TurnRightCommand(room));
			executionCommands.put('F', new MoveForwardCommand(room));
		}
	}
	
	/**
	 * The method executes the commands supplied to the robot.
	 * 
	 * @throws NoMoveForwardException
	 * @throws InvalidCommandException
	 */
	public void executeCommand() throws NoMoveForwardException, InvalidCommandException {
		
		char[] command = commands.toCharArray();
    	for(char cmd : command) {
    		Command executionCommand = executionCommands.get(cmd);
    		if(executionCommand != null) {
    			Point currentPosition = new Point(room.getRobotPosition().x, room.getRobotPosition().y);
        		executionCommand.execute(currentPosition);
    		} else {
    			throw new InvalidCommandException("Invalid command: "+cmd);
    		}
    		System.out.println("---> "+getRobotCurrentLocation());
    	}
	}
	
	/**
	 * Return robots current position in room in following format "X Y D"
	 * 
	 * @return String
	 */
	public String getRobotCurrentLocation() {
		return room.getRobotPosition().x+" "+room.getRobotPosition().y+" "+room.getDirection().getDirectionCode();
	}
}
