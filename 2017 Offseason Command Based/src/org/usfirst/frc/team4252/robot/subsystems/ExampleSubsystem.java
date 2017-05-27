package org.usfirst.frc.team4252.robot.subsystems;

import org.usfirst.frc.team4252.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 This subsystem will be the climber
 */
public class ExampleSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Spark Climber = RobotMap.Climber;
		
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void up(){
		Climber.set(1);
	}
	
	public void down(){
		Climber.set(-1);
	}
	
	public void stop(){
		Climber.set(0);
	}
}
