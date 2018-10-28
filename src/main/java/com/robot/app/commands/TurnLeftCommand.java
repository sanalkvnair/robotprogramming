package com.robot.app.commands;

import java.awt.Point;

import com.robot.app.room.Room;

/**
 * Concrete class for turning left command.
 * 
 * @author Sanal Nair
 *
 */
public class TurnLeftCommand extends Command {

	public TurnLeftCommand(Room room) {
		super(room);
	}

	@Override
	public void execute(Point currentPosition) {
		room.turnLeft();
	}

}
