package com.robot.app.robot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import com.robot.app.exceptions.InvalidCommandException;
import com.robot.app.exceptions.NoMoveForwardException;
import com.robot.app.room.CircularRoom;
import com.robot.app.room.RectangularRoom;
import com.robot.app.room.Room;

public class RobotTest {
	Room rectangularRoom;
	Room circularRoom;
	Robot robot;
	
	@Before
	public void initialize() {
		rectangularRoom = new RectangularRoom(new Point(1,2), new Point(5,5));
		circularRoom = new CircularRoom(new Point(0,0), new Point(10,10));
	}

	@Test
	public void testExecuteCommandForRectangularRoom() throws NoMoveForwardException, InvalidCommandException {
		robot = new Robot(rectangularRoom, "HGHGGHGHG", "SE");
		robot.executeCommand();
		assertThat(robot.getRobotCurrentLocation(), equalTo("1 3 N"));
	}
	
	@Test
	public void testExecuteCommandForCircularRoom() throws NoMoveForwardException, InvalidCommandException {
		robot = new Robot(circularRoom, "RRFLFFLRF", "EN");
		robot.executeCommand();
		assertThat(robot.getRobotCurrentLocation(), equalTo("3 1 Ö"));
	}
	
	@Test(expected = InvalidCommandException.class)
	public void testExecuteCommandForInvalidCommandException() throws NoMoveForwardException, InvalidCommandException {
		robot = new Robot(circularRoom, "MRRFLFFLRF", "EN");
		robot.executeCommand();
	}
	
	@Test(expected = NoMoveForwardException.class)
	public void testExecuteCommandForNoMoveForwardException() throws NoMoveForwardException, InvalidCommandException {
		robot = new Robot(rectangularRoom, "FFF", "EN");
		robot.executeCommand();
	}

}
