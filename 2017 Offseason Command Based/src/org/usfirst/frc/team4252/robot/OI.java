package org.usfirst.frc.team4252.robot;

import org.usfirst.frc.team4252.robot.commands.ClimberDown_Command;
import org.usfirst.frc.team4252.robot.commands.ExampleCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick stick = new Joystick(0);
	public OI(){
		Button button1 = new JoystickButton(stick, 1);
		Button button2 = new JoystickButton(stick, 2);
		button1.whenPressed(new ExampleCommand());
		button2.whenPressed(new ClimberDown_Command());

	}
	public Joystick getstickJoystick(){
		return stick;
	}
}
