package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.RobotMap;
import org.usfirst.frc.team2643.robot.commands.HoldGear;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gear extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Spark gearMotor = new Spark(RobotMap.gearMotorPort); 

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new HoldGear());
    }
    
    /**
     * Sets the gear motor to a speed
     * @param speed put a value from 0-1 (assuming that positive speeds 
     * make the flap release the gear 
     */
    public void setSpeed(double speed) {
    	if(speed >= 0 && speed <=1) 
    		gearMotor.set(speed);
    }
}

