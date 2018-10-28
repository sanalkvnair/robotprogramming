package com.robot.app;

import java.awt.Point;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.robot.app.exceptions.InvalidCommandException;
import com.robot.app.exceptions.NoMoveForwardException;
import com.robot.app.robot.Robot;
import com.robot.app.room.CircularRoom;
import com.robot.app.room.RectangularRoom;
import com.robot.app.room.Room;

/**
 * 
 * @author Sanal Nair
 *
 */
public class App {
	public static void main(String[] args) {
		CommandLineParser cliParser = new DefaultParser();

		Options options = new Options();
		Option roomSizeOption = Option.builder("r")
				.desc("Size of room for rectangular room specify two numbers and for circular specify a single number.")
				.longOpt("roomSize").hasArgs().required().build();
		Option robotPositionOption = Option.builder("p").desc("Robot starting position value x,y in room.")
				.longOpt("robotPosition").numberOfArgs(2).required().build();
		options.addOption(roomSizeOption);
		options.addOption(robotPositionOption);
		options.addRequiredOption("l", "langCode", true, "Language code 'SE' or 'EN' for commanding robot.");
		options.addRequiredOption("c", "commands", true,
				"Command sequence for robot to perform in room. "
						+ "\nEnglish Commands: R = Turn Right\tL = Turn Left\tF = Move Forward"
						+ "\nSwedish Commands: H = Sväng Höger\tV= = Sväng Vänster\tG = Gå");

		Room room = null;
		Point robotPosition = null;
		Robot robot = null;
		try {
			CommandLine cli = cliParser.parse(options, args);
			String[] startPosition = cli.getOptionValues("p");
			robotPosition = new Point(Integer.parseInt(startPosition[0]), Integer.parseInt(startPosition[1]));
			String[] roomSize = cli.getOptionValues("r");
			if (roomSize.length == 1) {
				room = new CircularRoom(robotPosition,
						new Point(Integer.parseInt(roomSize[0]), Integer.parseInt(roomSize[0])));
			} else {
				room = new RectangularRoom(robotPosition,
						new Point(Integer.parseInt(roomSize[0]), Integer.parseInt(roomSize[1])));
			}
			String langCode = cli.getOptionValue("l");
			String commands = cli.getOptionValue("c");
			robot = new Robot(room, commands, langCode);
			System.out.println("Start: " + robot.getRobotCurrentLocation());
			robot.executeCommand();
		} catch (ParseException e) {
			System.err.println("Missing required option.");
			HelpFormatter help = new HelpFormatter();
			help.printHelp("java -jar App", "Options", options, "java -jar App -c HGHGGHGHG -l SE -p 0 0 -r 10", true);
		} catch (NoMoveForwardException e) {
			System.err.println(e);
		} catch (InvalidCommandException e) {
			System.err.println(e);
		}
		if(robot !=null) {
			System.out.println("End: " + robot.getRobotCurrentLocation());
		}
	}
}
