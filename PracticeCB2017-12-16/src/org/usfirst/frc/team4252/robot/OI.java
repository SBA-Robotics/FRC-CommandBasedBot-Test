package org.usfirst.frc.team4252.robot;

import org.usfirst.frc.team4252.robot.commands.ClimbUpCommand;
import org.usfirst.frc.team4252.robot.commands.ClimberDownCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick stick;
	Button climberUpB;
	Button climberDownB;
	Button gearGrabberB;
	public OI(){
	stick = new Joystick(0);
	climberUpB = new JoystickButton(stick,0);
	climberDownB = new JoystickButton(stick,1);
	gearGrabberB = new JoystickButton(stick,2);
	
	climberUpB.whenPressed(new ClimbUpCommand());
	climberDownB.whenPressed(new ClimberDownCommand());
	
	}
	public Joystick getstickJoystick(){
		return stick;
	}
}