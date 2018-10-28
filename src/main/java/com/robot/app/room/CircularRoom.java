package com.robot.app.room;

import java.awt.Point;

import com.robot.app.robot.Directions;

/**
 * Room implementation for circular room.
 * 
 * @author Sanal Nair
 *
 */
public class CircularRoom implements Room {
	
	private Point startPosition;
	private Point endPosition;
	private Point robotPosition;
	private Directions direction;
	
	public CircularRoom(Point robotPosition, Point endPosition) {
		//Circular room start position will be in inverse direction from zero.
		this.startPosition = new Point(-endPosition.x, -endPosition.y);
		this.endPosition = endPosition;
		this.robotPosition = robotPosition;
		this.direction = Directions.NORTH;
	}

	@Override
	public Point getStartPosition() {
		return startPosition;
	}

	@Override
	public Point getRobotPosition() {
		return robotPosition;
	}
	
	@Override
	public void setRobotPosition(Point position) {
		this.robotPosition = position;
		
	}

	@Override
	public boolean contains(Point position) {
		boolean inX = position.getX() >= startPosition.getX() && position.getX() <= endPosition.getX();
		boolean inY = position.getY() >= startPosition.getY() && position.getY() <= endPosition.getY();
		return inX && inY;
	}
	
	@Override
	public Directions getDirection() {
		return direction;
	}

	@Override
	public Point moveForward(Point currentPosition) {
		switch(direction) {
		case NORTH:
			currentPosition.setLocation(currentPosition.getX(), currentPosition.getY()-1);
			break;
		case EAST:
			currentPosition.setLocation(currentPosition.getX()+1, currentPosition.getY());
			break;
		case SOUTH:
			currentPosition.setLocation(currentPosition.getX(), currentPosition.getY()+1);
			break;
		case WEST:
			currentPosition.setLocation(currentPosition.getX()-1, currentPosition.getY());
			break;
		}
		return currentPosition;
	}
	
	@Override
	public void turnLeft() {
		switch(direction) {
		case NORTH:
			direction = Directions.WEST;
			break;
		case EAST:
			direction = Directions.NORTH;
			break;
		case SOUTH:
			direction = Directions.EAST;
			break;
		case WEST:
			direction = Directions.SOUTH;
			break;
		}
	}
	
	@Override
	public void turnRight() {
		switch(direction) {
		case NORTH:
			direction = Directions.EAST;
			break;
		case EAST:
			direction = Directions.SOUTH;
			break;
		case SOUTH:
			direction = Directions.WEST;
			break;
		case WEST:
			direction = Directions.NORTH;
			break;
		}
	}
	
}
