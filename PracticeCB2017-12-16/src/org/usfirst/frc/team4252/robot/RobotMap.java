package org.usfirst.frc.team4252.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//*********************************************************
	//*********************Electrical Constants****************
	//*********************************************************
	//Main Drive
	public static final Victor Drive_FLeft = new Victor(0),
		    Drive_RLeft = new Victor(1),		
			Drive_FRight = new Victor(2),
			Drive_RRight = new Victor(3);
	//Climber
	public static final Spark Climber = new Spark(0);
	//Analog Gyro 
	public static final int AGyro = 0;
	//ENCODER (Distance Per Tick)
	private final static double DriveTrainWheelRadius = 3;
	private final static int EncoderTickPerRev = 1024;
	public static final double EncoderDistTick = DriveTrainWheelRadius * 2 * Math.PI / EncoderTickPerRev;
	//LEncoder
	public static final int EncoderL1 = 0;
	public static final int EncoderL2 = 1;
	public static final boolean EncoderLReverse = false;
	//REncoder
	public static final int EncoderR1 = 2;
	public static final int EncoderR2 = 3;
	public static final boolean EncoderRReverse = true;		

	
	//*********************************************************
	//*********************Number Constants********************
	//*********************************************************
	public static final int ForwardDistanceAuto = 114;
	//
		
		
}
