package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveCommand extends Command {

	public ArcadeDriveCommand(){
        requires(Robot.DriveTrain);
	}
	
	
	protected void execute() {
		Robot.DriveTrain.teleOpDrive(Robot.oi.getstickJoystick());
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.DriveTrain.stop();
	}
	
    protected void interrupted() {
    }

}
