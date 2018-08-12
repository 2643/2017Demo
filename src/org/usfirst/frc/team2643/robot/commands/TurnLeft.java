package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;
import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnLeft extends Command {
 
	int first;
	
    public TurnLeft() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    /**
     * Called just before this Command runs the first time
     * -resets the encoders before rotating
     */
    protected void initialize() {
    	first = Robot.drive.getRightEncoder() + 450;
    	Robot.drive.resetEncoders();
    	System.out.println("Turning left");
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     * -set the left side to backward and the right side to go forward
     */
    protected void execute() {
    	Robot.drive.setLeftSpeed(-0.7);
    	Robot.drive.setRightSpeed(0.7);
    	System.out.println(Robot.drive.getRightEncoder());
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     * -returns true when the right encoder equals left rotation ticks; otherwise return false
     */
    protected boolean isFinished() {
    	if(Robot.drive.getRightEncoder() < (RobotMap.leftRotationTicks + first)) {
    		return false;
    	}else {
    		return true;
    	}
    }

    /**
     * Called once after isFinished returns true
     * -to end the command, stop the motors
     */
    protected void end() {
    	Robot.drive.setSpeed(0);
    }

    /**
     * Called when another command which requires one or more of the same 
     * subsystems is scheduled to run
     * - when this command is interrupted, end the command
     */
    protected void interrupted() {
    	end();
    }
}