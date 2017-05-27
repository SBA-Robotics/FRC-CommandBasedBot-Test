package org.usfirst.frc.team4252.robot.subsystems;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Pneumatic_Subsystem extends Subsystem {
	public static Compressor pressureSwitch = new Compressor (0);
	public static Relay spike = new Relay (0);
	public static DoubleSolenoid sol = new DoubleSolenoid (6,7);
	public static Pneumatic_Subsystem pneu = new Pneumatic_Subsystem();
	
	public Pneumatic_Subsystem()	{
		
	}
	
	public void initDefaultCommand()	{
		sol.set(DoubleSolenoid.Value.kForward);
	}
	
	/**
	* Starts compressor safety loop.
	*/
	public static void Start()	{
		if (pressureSwitch.getPressureSwitchValue() == true) {
			spike.set(Value.kOff);
		}
		else 
		{
			spike.set(Value.kForward);
		}
	}
	
	/**
	 * Prints status of pneumatic arm to SmartDashboard.
	 */
	private static String Status()	{
		String gStatus = null;
		if (sol.get() == DoubleSolenoid.Value.kForward)	{
			gStatus = "Closed";
		}
		else if (sol.get() == DoubleSolenoid.Value.kReverse)	{
			gStatus = "Open";
		}
		else if (sol.get() == DoubleSolenoid.Value.kOff)	{
			gStatus = "Idle";
		}
		return gStatus;
		
	}
	/**
	 * Retracts pneumatic.
	 */
	public void pOpen()	{
		sol.set(DoubleSolenoid.Value.kReverse);
	}
	/**
	 * Extends pneumatic.
	 */
	public void pClose()	{
		sol.set(DoubleSolenoid.Value.kForward);
	}
	
	public static void updateStatus()	{
		SmartDashboard.putString("Grabber Status", Status());
	}
}

