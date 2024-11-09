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
    }

    public Command getAutonomousCommand() {
        // @formatter:off
        // 🟪🟪🟪🟪 Here you need to return the gearbox's autonomous command. 🟪🟪🟪🟪
        // 🟪🟪🟪🟪 After the auton command, use an InstantCommand with a lambda (this symbol: () -> ) to a 🟪🟪🟪🟪
        // 🟪🟪🟪🟪 System.out.println() to print out "Done with the auton" to the console. 🟪🟪🟪🟪
        // @formatter:on

        // ❌❌ Delete this line: ❌❌
        return Commands.none();
    }
}
