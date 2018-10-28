package com.robot.app.room;

import java.awt.Point;

import com.robot.app.robot.Directions;

public interface Room {

	/**
	 * Get the starting position of the room.
	 * 
	 * @return Point
	 */
	Point getStartPosition();
	/**
	 * Get the robot's current position.
	 * 
	 * @return Point
	 */
	public Point getRobotPosition();
	/**
	 * Set the robot's position.
	 * 
	 * @param position
	 */
	public void setRobotPosition(Point position);
	/**
	 * Check whether the position is inside room.
	 * 
	 * @param position
	 * @return boolean
	 */
	boolean contains(Point position);
	/**
	 * Get the direction of robot facing.
	 * 
	 * @return Directions
	 */
	public Directions getDirection();
	/**
	 * Method to move forward robot from the current position.
	 * 
	 * @param currentPosition
	 * @return Point.
	 */
	public Point moveForward(Point currentPosition);
	/**
	 * Method to turn left the robot direction.
	 * 
	 */
	public void turnLeft();
	/**
	 * Method to turn right the robot direction.
	 */
	public void turnRight();
	
}
