package com.robot.app.room;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import com.robot.app.robot.Directions;

public class RectangularRoomTest {

	Room rectangularRoom;

	@Before
	public void setup() {
		rectangularRoom = new RectangularRoom(new Point(0, 0), new Point(5, 5));
	}

	@Test
	public void testNewPositionIsInsideRoom() {
		boolean isInside = rectangularRoom.contains(new Point(2, 2));
		assertThat(isInside, Is.is(true));
	}

	@Test
	public void testNewPositionIsOutsideRoom() {
		boolean isOutside = rectangularRoom.contains(new Point(6, 5));
		assertThat(isOutside, Is.is(false));
	}

	@Test
	public void testNewPositionIsInsideRoomBoundary() {
		boolean isInsideOnBoundary = rectangularRoom.contains(new Point(5, 5));
		assertThat(isInsideOnBoundary, Is.is(true));
	}

	@Test
	public void testMoveForwardInNorth() {
		Point actual = rectangularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(1));
		assertThat(actual.y, equalTo(1));
	}
	
	@Test
	public void testMoveForwardInEast() {
		rectangularRoom.turnRight();
		Point actual = rectangularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(2));
		assertThat(actual.y, equalTo(2));
	}
	
	@Test
	public void testMoveForwardInSouth() {
		rectangularRoom.turnRight(); //turn to east
		rectangularRoom.turnRight(); //turn to south
		Point actual = rectangularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(1));
		assertThat(actual.y, equalTo(3));
	}
	
	@Test
	public void testMoveForwardInWest() {
		rectangularRoom.turnLeft(); //turn to east
		Point actual = rectangularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(0));
		assertThat(actual.y, equalTo(2));
	}
	
	@Test
	public void testTurnRightIsEast() {
		rectangularRoom.turnRight();
		assertThat(rectangularRoom.getDirection(), equalTo(Directions.EAST));
	}
	
	@Test
	public void testTwiceTurnRightIsSouth() {
		rectangularRoom.turnRight();
		rectangularRoom.turnRight();
		assertThat(rectangularRoom.getDirection(), equalTo(Directions.SOUTH));
	}
	
	@Test
	public void testTurnLeftIsWest() {
		rectangularRoom.turnLeft();
		assertThat(rectangularRoom.getDirection(), equalTo(Directions.WEST));
	}
	
	@Test
	public void testTwiceTurnLeftIsSouth() {
		rectangularRoom.turnLeft();
		rectangularRoom.turnLeft();
		assertThat(rectangularRoom.getDirection(), equalTo(Directions.SOUTH));
	}
}
