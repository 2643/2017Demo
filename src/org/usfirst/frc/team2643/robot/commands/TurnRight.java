package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * TurnRight - rotates the robot 90 degrees to the right
 */
public class TurnRight extends Command {

	int first;
    public TurnRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    /**
     * Runs this before the command starts
     * -Resets the encoders before rotating
     */
    protected void initialize() {
    	first = Robot.drive.getRightEncoder();
    	Robot.drive.resetEncoders();
    	System.out.println("Turning right");
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * -Makes the left side go forward and the right side to go backward
     */
    protected void execute() {
    	Robot.drive.setLeftSpeed(0.6);
    	Robot.drive.setRightSpeed(-0.6);
    	System.out.println(Robot.drive.getRightEncoder());
    }
    
    /**
     * Make this return true when this Command no longer needs to run execute()
     * - will return true when the rightEncoder = rightRotationTicks; otherwise will return false
     */
    protected boolean isFinished() {
    	if(Robot.drive.getRightEncoder() > (RobotMap.rightRotationTicks - first)) {
    		return false;
    	}else {
    		return true;
    	}
    }

    /**
     * Called once after isFinished returns true
     * -stops all of the motors to end the command
     */
    protected void end() {
    	Robot.drive.setSpeed(0);
    }
    
    /**
     * Called when another command which requires one or more of the same 
     * subsystems is scheduled to run
     * -if this command is interrupted, just end the command
     */
    protected void interrupted() {
    	end();
    }
}