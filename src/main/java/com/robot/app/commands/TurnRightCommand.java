package com.robot.app.commands;

import java.awt.Point;

import com.robot.app.room.Room;

/**
 * Concrete class for turning right command.
 * 
 * @author Sanal Nair
 *
 */
public class TurnRightCommand extends Command {

	public TurnRightCommand(Room room) {
		super(room);
	}

	@Override
	public void execute(Point currentPosition) {
		room.turnRight();
	}

}
