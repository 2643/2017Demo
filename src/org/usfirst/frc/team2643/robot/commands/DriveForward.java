package org.usfirst.frc.team2643.robot.commands;

import org.usfirst.frc.team2643.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	Timer timer = new Timer();
	int timeToDrive;
	
    public DriveForward(int time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	timeToDrive = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.setSpeed(0.5);
    	System.out.println(Robot.drive.getRightEncoder());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timer.get() >= timeToDrive)
        	return true;
        else if(timer.get() < timeToDrive)
        	return false;
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.setSpeed(0);
    	timer.stop();
    	timer.reset();
    	Robot.drive.resetEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
