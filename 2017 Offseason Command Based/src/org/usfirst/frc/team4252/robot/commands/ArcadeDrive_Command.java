package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive_Command extends Command{
	public ArcadeDrive_Command(){
		requires(Robot.DriveTrain);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}	
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.DriveTrain.TeleopDrive(Robot.oi.getstickJoystick());
	}		
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}	
	
}

