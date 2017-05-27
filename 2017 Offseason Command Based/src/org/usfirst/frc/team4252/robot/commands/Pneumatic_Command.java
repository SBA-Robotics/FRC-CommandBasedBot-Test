package org.usfirst.frc.team4252.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc.team4252.robot.Robot;

public class Pneumatic_Command extends InstantCommand {
	
	public Pneumatic_Command() {
		requires(Robot.pneu);
	}
	
	@Override
	protected void execute() {
		Robot.pneu.pOpen();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void end() {
		Robot.pneu.pClose();
	}
	
	
}

