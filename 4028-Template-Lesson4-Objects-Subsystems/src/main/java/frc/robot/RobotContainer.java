// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Gearbox;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

	private final Gearbox gearbox = new Gearbox();

	private final CommandXboxController driverController = new CommandXboxController(
			OperatorConstants.kDriverControllerPort);

	public RobotContainer() {
		configureBindings();
	}

	private void configureBindings() {

		// 🟪🟪🟪 Here is where you will bind buttons. 🟪🟪🟪
		// 🟪🟪🟪 Bind the 'A' button to spin the motor 3 rotations forward (using gearbox.getPosition()) 🟪🟪🟪🟪

		// 🟪🟪🟪 Bind the 'B' button to spin the motor 5 rotations backward (using gearbox.getPosition()) 🟪🟪🟪🟪
	}

	public Command getAutonomousCommand() {
		return Commands.none();
	}
}
