package org.usfirst.frc.team4252.robot.commands;

import org.usfirst.frc.team4252.robot.Robot;
import org.usfirst.frc.team4252.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardAutoCommand extends Command {
	
	double angle;
	public DriveForwardAutoCommand(){
        requires(Robot.DriveTrain);
	}
	
	
	protected void execute() {
		Robot.ag.reset();
		Robot.DriveTrain.resetEncoders();
		while(Robot.DriveTrain.getEncoder() <= RobotMap.ForwardDistanceAuto) {
		angle = Robot.ag.getAngle();
		Robot.DriveTrain.drive(-0.5, -angle*0.03);
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
	}
	
    protected void interrupted() {
    }

}
