// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkRelativeEncoder.Type;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

// 🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪
// 🟪🟪 In this assignment, you will modify your gearbox code from the  🟪🟪
// 🟪🟪 last project to use position PID, reducing code quantity and    🟪🟪
// 🟪🟪                improving closed loop accuracy                   🟪🟪
// 🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪🟪

public class Robot extends TimedRobot {
    private static final int CAN_ID = 13;
    private static final double ROTATIONS_TO_SPIN = 4;

    private Command autonomousCommand;
    private CANSparkMax motor;
    private RelativeEncoder encoder;

    // 🟪🟪🟪 Declare a SparkPIDController here: 🟪🟪🟪

    private CommandXboxController driverController = new CommandXboxController(0);
    private double targetPosition;

    private RobotContainer robotContainer;

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();

        targetPosition = 0.0;
        motor = new CANSparkMax(CAN_ID, MotorType.kBrushed);
        encoder = motor.getEncoder(Type.kQuadrature, 4096);

        // 🟪🟪🟪 get the PIDController from the motor here: 🟪🟪🟪

        // 🟪🟪🟪 Set the P, I, and D gains here (you'll need to tune them). 🟪🟪🟪

        // 🟪🟪🟪 uncomment this line (don't worry about it): 🟪🟪🟪
        // pid.setFeedbackDevice(encoder);

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
        autonomousCommand = robotContainer.getAutonomousCommand();

        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }

        driverController.a().onTrue(Commands.runOnce(() -> {
            targetPosition = encoder.getPosition() + ROTATIONS_TO_SPIN;
        }));

        driverController.b().onTrue(Commands.runOnce(() -> {
            targetPosition = encoder.getPosition() - ROTATIONS_TO_SPIN;
        }));
    }

    @Override
    public void teleopPeriodic() {
        // 🟪🟪🟪 Here is where you will set the PID reference 🟪🟪🟪
        // 🟪🟪🟪 remember, use pid.setReference(); 🟪🟪🟪
        // 🟪🟪🟪 (with ControlType.kPosition) 🟪🟪🟪
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
