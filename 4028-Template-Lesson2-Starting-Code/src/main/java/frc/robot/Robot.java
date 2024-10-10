// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkRelativeEncoder.Type;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private final SendableChooser<String> chooser = new SendableChooser<>();

	private CANSparkMax NicksEpicestMotor;
	private CommandXboxController NicksBoringControler;
	private RelativeEncoder Nicolisuperdupperencoderorder;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		chooser.setDefaultOption("Default Auto", kDefaultAuto);
		chooser.addOption("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", chooser);

		NicksEpicestMotor = new CANSparkMax(13, MotorType.kBrushed);
		NicksBoringControler = new CommandXboxController(0);
		Nicolisuperdupperencoderorder = NicksEpicestMotor.getEncoder(Type.kQuadrature, 4096);

	}

	/**
	 * This function is called every 20 ms, no matter the mode. Use this for items
	 * like diagnostics that you want ran during disabled, autonomous, teleoperated
	 * and test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString line to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the SendableChooser
	 * make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = chooser.getSelected();
		// m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			case kCustomAuto :
				// Put custom auto code here
				break;
			case kDefaultAuto :
			default :
				// Put default auto code here
				break;
		}
	}

	/** This function is called once when teleop is enabled. */
	@Override
	public void teleopInit() {
	}

	/** This function is called periodically during operator control. */
	@Override
	public void teleopPeriodic() {
		if (NicksBoringControler.getLeftY() < -0.2) {
			if (Nicolisuperdupperencoderorder.getPosition() >= -30.0) {
				NicksEpicestMotor.set(NicksBoringControler.getLeftY());
			} else {
				NicksEpicestMotor.set(0);
			}
		} else if (NicksBoringControler.getLeftY() > 0.2) {
			if (Nicolisuperdupperencoderorder.getPosition() <= 30.0) {
				NicksEpicestMotor.set(NicksBoringControler.getLeftY());
			} else {
				NicksEpicestMotor.set(0);
			}
		} else {
			NicksEpicestMotor.set(0);
		}
		SmartDashboard.putNumber("Motor Revolutions", Nicolisuperdupperencoderorder.getPosition());
	}

	/** This function is called once when the robot is disabled. */
	@Override
	public void disabledInit() {
	}

	/** This function is called periodically when disabled. */
	@Override
	public void disabledPeriodic() {
	}

	/** This function is called once when test mode is enabled. */
	@Override
	public void testInit() {
	}

	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {
	}

	/** This function is called once when the robot is first started up. */
	@Override
	public void simulationInit() {
	}

	/** This function is called periodically whilst in simulation. */
	@Override
	public void simulationPeriodic() {
	}
}
