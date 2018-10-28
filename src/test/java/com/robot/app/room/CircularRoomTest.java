package com.robot.app.room;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.awt.Point;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import com.robot.app.robot.Directions;

public class CircularRoomTest {

	Room circularRoom;

	@Before
	public void setup() {
		circularRoom = new CircularRoom(new Point(0, 0), new Point(5, 5));
	}

	@Test
	public void testNewPositionIsInsideRoom() {
		boolean isInside = circularRoom.contains(new Point(2, 2));
		assertThat(isInside, Is.is(true));
	}

	@Test
	public void testNewPositionIsOutsideRoom() {
		boolean isOutside = circularRoom.contains(new Point(6, 5));
		assertThat(isOutside, Is.is(false));
	}

	@Test
	public void testNewPositionIsInsideRoomBoundary() {
		boolean isInsideOnBoundary = circularRoom.contains(new Point(5, 5));
		assertThat(isInsideOnBoundary, Is.is(true));
	}

	@Test
	public void testMoveForwardInNorth() {
		Point actual = circularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(1));
		assertThat(actual.y, equalTo(1));
	}
	
	@Test
	public void testMoveForwardInEast() {
		circularRoom.turnRight();
		Point actual = circularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(2));
		assertThat(actual.y, equalTo(2));
	}
	
	@Test
	public void testMoveForwardInSouth() {
		circularRoom.turnRight(); //turn to east
		circularRoom.turnRight(); //turn to south
		Point actual = circularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(1));
		assertThat(actual.y, equalTo(3));
	}
	
	@Test
	public void testMoveForwardInWest() {
		circularRoom.turnLeft(); //turn to east
		Point actual = circularRoom.moveForward(new Point(1,2));
		assertThat(actual.x, equalTo(0));
		assertThat(actual.y, equalTo(2));
	}
	
	@Test
	public void testTurnRightIsEast() {
		circularRoom.turnRight();
		assertThat(circularRoom.getDirection(), equalTo(Directions.EAST));
	}
	
	@Test
	public void testTwiceTurnRightIsSouth() {
		circularRoom.turnRight();
		circularRoom.turnRight();
		assertThat(circularRoom.getDirection(), equalTo(Directions.SOUTH));
	}
	
	@Test
	public void testTurnLeftIsWest() {
		circularRoom.turnLeft();
		assertThat(circularRoom.getDirection(), equalTo(Directions.WEST));
	}
	
	@Test
	public void testTwiceTurnLeftIsSouth() {
		circularRoom.turnLeft();
		circularRoom.turnLeft();
		assertThat(circularRoom.getDirection(), equalTo(Directions.SOUTH));
	}
}
