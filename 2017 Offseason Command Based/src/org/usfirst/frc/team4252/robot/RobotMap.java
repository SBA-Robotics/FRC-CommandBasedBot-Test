package org.usfirst.frc.team4252.robot;

import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final Victor Drive_FLeft = new Victor(0),
	    Drive_RLeft = new Victor(1),		
		Drive_FRight = new Victor(2),
		Drive_RRight = new Victor(3),	
		Climber = new Victor(4);	
}
