package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Dump extends Subsystem {
	
	Spark dumpMotor = new Spark(RobotMap.dumpMotorPort);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //adds functions to set motor's speed to speed, and set motor's speed to 0
    public void setDumpSpeed(double speed) {
    	dumpMotor.set(speed);
    }
    public void dumpStop() {
    	// Stops the motor
    	dumpMotor.set(0);
    }
}

