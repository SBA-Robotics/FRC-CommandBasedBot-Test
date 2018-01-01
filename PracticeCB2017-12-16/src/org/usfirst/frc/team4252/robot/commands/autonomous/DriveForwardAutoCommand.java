package org.usfirst.frc.team4252.robot.commands.autonomous;

import org.usfirst.frc.team4252.robot.Robot;
import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardAutoCommand extends Command {
	
	double angle;
	public DriveForwardAutoCommand(){
        requires(Robot.DriveTrain);
	}
	
	
	@SuppressWarnings("deprecation")
	protected void execute() {
		SmartDashboard.putString("Autonomous Status", "Executing");	
		Robot.DriveTrain.driveEncodedStraight(RobotMap.ForwardDistanceAuto);
	}
		
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		Robot.DriveTrain.stop();
		SmartDashboard.putString("Autonomous Status", "Complete");
	}
	
    protected void interrupted() {
    	SmartDashboard.putString("Autonomous Status", "Interrupted");
    }

}
