/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2643.robot;

import org.usfirst.frc.team2643.robot.commands.DriveBackward;
import org.usfirst.frc.team2643.robot.commands.DriveForward;
import org.usfirst.frc.team2643.robot.commands.DumpStop;
import org.usfirst.frc.team2643.robot.commands.DumpTime;
import org.usfirst.frc.team2643.robot.commands.TurnLeft;
import org.usfirst.frc.team2643.robot.commands.TurnRight;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick driveStick = new Joystick(0);

	public OI() {
		JoystickButton button1 = new JoystickButton(driveStick, 1);
		JoystickButton button2 = new JoystickButton(driveStick, 2);
		JoystickButton button3 = new JoystickButton(driveStick, 3);
		JoystickButton button4 = new JoystickButton(driveStick, 4);
		JoystickButton button5 = new JoystickButton(driveStick, 5);
//		button1.whenPressed(new DriveBackward(3));
//		button2.whenPressed(new TurnRight());
//		button3.whenPressed(new TurnLeft());
//		button4.whenPressed(new DriveForward(3));
		button5.whenPressed(new DumpTime());
		button5.whenReleased(new DumpStop());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	/**
	 * Gets the joystick 
	 * @return Joystick 
	 */
	public Joystick getJoystick() {
		return driveStick;
	}
}
