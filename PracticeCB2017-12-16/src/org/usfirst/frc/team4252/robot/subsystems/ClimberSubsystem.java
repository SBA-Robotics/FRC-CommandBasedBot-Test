package org.usfirst.frc.team4252.robot.subsystems;

import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem{
	
	
	public ClimberSubsystem() 
	{
		RobotMap.Climber.setSafetyEnabled(false);
	}
	@Override
	protected void initDefaultCommand() {	
	}
	
	public void start()	{
		RobotMap.Climber.setSpeed(1.0);
	}
	public void emergencyStop()	{
		RobotMap.Climber.setSpeed(0.0);
	}
	public void reverse()	{
		RobotMap.Climber.setSpeed(-0.4);
	}
	

}
