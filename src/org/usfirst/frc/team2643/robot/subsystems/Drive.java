package org.usfirst.frc.team2643.robot.subsystems;

import org.usfirst.frc.team2643.robot.RobotMap;
import org.usfirst.frc.team2643.robot.commands.TankDriveWithJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Drive extends Subsystem {

	Spark lFrontMotor = new Spark(RobotMap.lFrontMotorPort);
	Spark lBackMotor = new Spark(RobotMap.lBackMotorPort);
	Spark rFrontMotor = new Spark(RobotMap.rFrontMotorPort);
	Spark rBackMotor = new Spark(RobotMap.rBackMotorPort);
	
	Encoder leftEncoder = new Encoder(RobotMap.leftEncoderPort1, RobotMap.leftEncoderPort2);
	Encoder rightEncoder = new Encoder(RobotMap.rightEncoderPort1, RobotMap.rightEncoderPort2);
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//takes 550 to turn left
    public Drive() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDriveWithJoystick());
    }
    
    public void setSpeed(double speed) {
    	lFrontMotor.set(speed);
    	lBackMotor.set(speed);
    	rFrontMotor.set(-speed);
    	rBackMotor.set(-speed);
    }
    
    public void setLeftSpeed(double speed) {
    	lFrontMotor.set(speed);
    	lBackMotor.set(speed);
    }
    
    public void setRightSpeed(double speed) {
    	rFrontMotor.set(-speed);
    	rBackMotor.set(-speed);
    }
    
    public void driveWithJoystick(Joystick stick) {
    	lFrontMotor.set(-stick.getRawAxis(1));
    	lBackMotor.set(-stick.getRawAxis(1));
    	rFrontMotor.set(stick.getRawAxis(5));
    	rBackMotor.set(stick.getRawAxis(5));
    }
    
    public int getLeftEncoder() {
    	return leftEncoder.get();
    }
    
    public int getRightEncoder() {
    	return rightEncoder.get();
    }
    
    public void resetEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
}