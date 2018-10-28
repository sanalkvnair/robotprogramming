package com.robot.app.commands;

import java.awt.Point;

import com.robot.app.exceptions.NoMoveForwardException;
import com.robot.app.room.Room;

/**
 * Concrete class for executing moving forward command.
 * 
 * @author Sanal Nair
 *
 */
public class MoveForwardCommand extends Command {

	public MoveForwardCommand(Room room) {
		super(room);
	}

	@Override
	public void execute(Point currentPosition) throws NoMoveForwardException {
		Point newPosition = room.moveForward(currentPosition);
		if(room.contains(newPosition)) {
			room.setRobotPosition(newPosition);
		} else {
			throw new NoMoveForwardException("No area further to move.");
		}
	}

}
