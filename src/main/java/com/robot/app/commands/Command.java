package com.robot.app.commands;

import java.awt.Point;

import com.robot.app.exceptions.NoMoveForwardException;
import com.robot.app.room.Room;

/**
 * Abstract class for handling commands for robot.
 * 
 * @author Sanal Nair
 *
 */
public abstract class Command {
	
	Room room;
	
	public Command(Room room) {
		this.room = room;
	}
	
	public abstract void execute(Point currentPosition) throws NoMoveForwardException;

}
