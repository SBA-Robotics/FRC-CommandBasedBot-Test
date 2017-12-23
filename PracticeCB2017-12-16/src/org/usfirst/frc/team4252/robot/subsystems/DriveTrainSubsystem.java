package org.usfirst.frc.team4252.robot.subsystems;

import org.usfirst.frc.team4252.robot.RobotMap;
import org.usfirst.frc.team4252.robot.commands.ArcadeDriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrainSubsystem extends Subsystem {
	
	private RobotDrive MainDrive;
	private Encoder encode;
	public DriveTrainSubsystem(){
		MainDrive = new RobotDrive(RobotMap.Drive_FLeft,RobotMap.Drive_RLeft,RobotMap.Drive_FRight,RobotMap.Drive_RRight);
		//Assume this encoder to be on left side, having a right encoder would require one of these values to be negative
		encode = new Encoder(RobotMap.EncoderA,RobotMap.EncoderB);
		encode.setDistancePerPulse(4 * Math.PI / 128.0);
	
	}	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveCommand());
	}
	
	public void teleOpDrive(Joystick Driver) {
		MainDrive.arcadeDrive(Driver);
	}
	
	public void drive(double speed,double turn) {
		MainDrive.drive(speed, turn);
	}
	
	public void resetEncoders() {
		encode.reset();
	}
	
	public double getEncoder() {
		//Returns in inches
		return encode.getDistance();
	}
	
	public void stop() {
		MainDrive.arcadeDrive(0,0);
	}

}
