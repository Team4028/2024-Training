// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * 🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪
 * 🟪🟪🟪🟪  TASK: Create a motor and spin it a fixed number of rotataions  🟪🟪🟪🟪
 * 🟪🟪🟪🟪        The motor should spin +6 rotations on a Y press and -5   🟪🟪🟪🟪
 * 🟪🟪🟪🟪        rotations on an X press. Finally, if the motor is at     🟪🟪🟪🟪
 * 🟪🟪🟪🟪        the target position, have it run forward at 0.1 vbus     🟪🟪🟪🟪
 * 🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪
 */
public class Robot extends TimedRobot {
    private Command m_autonomousCommand;

    // 🟪🟪🟪🟪 Declare a new CANSparkMax motor here 🟪🟪🟪🟪

    private RobotContainer m_robotContainer;
    private CommandXboxController driverController = new CommandXboxController(0);
    private static final int CAN_ID = 13;
    

    // 🟪🟪🟪🟪 Declare your targetPosition and constants here (ROTATIONS_TO_SPIN, TOELRANCE, and CLOSED_LOOP_VBUS) 🟪🟪🟪🟪


    @Override
    public void robotInit() {
        m_robotContainer = new RobotContainer();

        // 🟪🟪🟪🟪 Initialize your CANSparkMax here (use the CAN_ID constant)... 🟪🟪🟪🟪
    }
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }
    @Override
    public void autonomousInit() {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();

        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic() {
        // 🟪🟪🟪🟪 Bind your buttons here... 🟪🟪🟪🟪

        

        // 🟪🟪🟪🟪 Here is where you'll set the motor control 🟪🟪🟪🟪
        // 🟪🟪🟪🟪 Remember, move it toward the target if     🟪🟪🟪🟪
        // 🟪🟪🟪🟪 it's farther away from the targetPosition  🟪🟪🟪🟪
        // 🟪🟪🟪🟪 than the threshold, otherwise run it at    🟪🟪🟪🟪
        // 🟪🟪🟪🟪             10% vbus (0.1)                 🟪🟪🟪🟪
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    @Override
    public void testPeriodic() {
    }

    @Override
    public void simulationInit() {
    }

    @Override
    public void simulationPeriodic() {
    }
}
