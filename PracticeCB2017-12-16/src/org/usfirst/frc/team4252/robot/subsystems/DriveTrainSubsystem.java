package org.usfirst.frc.team4252.robot.subsystems;

import org.usfirst.frc.team4252.robot.Robot;
import org.usfirst.frc.team4252.robot.RobotMap;
import org.usfirst.frc.team4252.robot.commands.ArcadeDriveCommand;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrainSubsystem extends Subsystem {
	
	private RobotDrive MainDrive;
	private Encoder encodeL;
	private Encoder encodeR;
	private AnalogGyro ag;
	public DriveTrainSubsystem(){
		//DriveTrain
		MainDrive = new RobotDrive(RobotMap.Drive_FLeft,RobotMap.Drive_RLeft,RobotMap.Drive_FRight,RobotMap.Drive_RRight);
		//Encoders
		//Left
		encodeL = new Encoder(RobotMap.EncoderL1,RobotMap.EncoderL2, RobotMap.EncoderLReverse, Encoder.EncodingType.k2X);
		encodeL.setDistancePerPulse(RobotMap.EncoderDistTick);
		encodeL.setMaxPeriod(.1);
		encodeL.setMinRate(10);
		encodeL.setSamplesToAverage(7);
		//Right
		encodeR = new Encoder(RobotMap.EncoderR1,RobotMap.EncoderR2, RobotMap.EncoderRReverse, Encoder.EncodingType.k2X);
		encodeR.setDistancePerPulse(RobotMap.EncoderDistTick);
		encodeR.setMaxPeriod(.1);
		encodeR.setMinRate(10);
		encodeR.setSamplesToAverage(7);
		//Gyro
		ag = new AnalogGyro(RobotMap.AGyro); //Declaration of a gyroscope plugged into analog port 0.
		//PID Controller

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
	
	public void driveEncodedStraight(int distance) {
		double angle, error;
		reset();
		error = distance - ((getREncoder() + getLEncoder()) / 2);
		while(error > 20) 
		{
			angle = getAngle();
			drive(-0.5, -angle * RobotMap.kAngleP);
			error = distance - ((getREncoder() + getLEncoder()) / 2);
		}
		
		while(error > 0) 
		{
			error = distance - ((getREncoder() + getLEncoder()) / 2);
			angle = getAngle();
			Robot.DriveTrain.drive(RobotMap.kSpeedD + (RobotMap.kSpeedP * error), -angle * RobotMap.kAngleP);
			
			//This is what David Moss made as his forward autonomous, the bot should correct its angle proportional to deviation
		}
		Robot.DriveTrain.drive(0, 0); //After which it stops...
	}
	
	public void driveGryoSpin(double angle) {
		double angleSpin;
		reset();

		angleSpin = angle - getAngle();
			drive(0, angleSpin * RobotMap.kAngleP + RobotMap.kAngleD);
	}
	
	
	public void reset() {
		encodeL.reset();
		encodeR.reset();
		ag.reset();
	}
	public void resetEncoders() {
		encodeL.reset();
		encodeR.reset();
	}
	public void resetLEncoder() {
		encodeL.reset();
	}
	public void resetREncoder() {
		encodeR.reset();
	}
	
	public double getLEncoder() {
		//Returns in inches
		return encodeL.getDistance();
	}
	
	public double getREncoder() {
		//Returns in inches
		return encodeR.getDistance();
	}
	
	public double getLEncoderRate() {
		//Returns in inches/sec
		return encodeL.getDistance();
	}
	
	public double getREncoderRate() {
		//Returns in inches/sec
		return encodeR.getDistance();
	}
	
	public void resetAngle() {
		ag.reset();
	}
	
	
	public double getAngle() {
		return ag.getAngle();
	}
	
	public void stop() {
		MainDrive.arcadeDrive(0,0);
	}

}
