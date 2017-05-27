package org.usfirst.frc.team4252.robot.subsystems;

import org.usfirst.frc.team4252.robot.RobotMap;
import org.usfirst.frc.team4252.robot.commands.ArcadeDrive_Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain_Subsystem extends Subsystem{
	private RobotDrive MDrive = new RobotDrive(RobotMap.Drive_FLeft,RobotMap.Drive_RLeft,RobotMap.Drive_FRight,RobotMap.Drive_RRight);
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive_Command());
		
	}
	public void TeleopDrive(Joystick stick){
		MDrive.arcadeDrive(stick);
		//If you wanted to invert anything just put negatives in command below, but depending on what you want inverted
		//MDrive.arcadeDrive(-stick.getX(),-stick.getY());
	}
	public void stop(){
		MDrive.drive(0,0);
	}
}
