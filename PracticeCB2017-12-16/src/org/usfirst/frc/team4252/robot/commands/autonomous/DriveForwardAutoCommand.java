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
		Robot.DriveTrain.reset();
		while(Robot.DriveTrain.getLEncoder() <= RobotMap.ForwardDistanceAuto && Robot.DriveTrain.getREncoder() <= RobotMap.ForwardDistanceAuto) 
		{
			angle = Robot.DriveTrain.getAngle();
			Robot.DriveTrain.drive(-0.5, -angle * 0.03); 
			SmartDashboard.putDouble("Angle", angle);
			SmartDashboard.putDouble("LDistance", Robot.DriveTrain.getLEncoder());
			SmartDashboard.putDouble("RDistance", Robot.DriveTrain.getREncoder());
			
			//This is what David Moss made as his forward autonomous, the bot should correct its angle proportional to deviation
		}
		Robot.DriveTrain.drive(0, 0); //After which it stops...
		Timer.delay(10.0); //For 10 seconds.
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
