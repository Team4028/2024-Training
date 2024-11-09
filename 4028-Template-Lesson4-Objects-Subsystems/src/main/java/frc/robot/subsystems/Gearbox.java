// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkRelativeEncoder.Type;

public class Gearbox extends SubsystemBase {

    // 🟪🟪🟪🟪 This template will focus on adding PID Control to a subsystem. 🟪🟪🟪🟪

	public enum GearboxStates {
		OUTFEED, OFF, INFEED, POSITION
	}

	private CANSparkMax motor;
    private RelativeEncoder encoder;

    // 🟪🟪🟪🟪 Create a PID controller here: 🟪🟪🟪🟪

	private GearboxStates state;

	private double targetVbus = 0.0;

    // 🟪🟪🟪🟪 Create the targetPosition here: 🟪🟪🟪🟪

	public Gearbox() {
		motor = new CANSparkMax(13, MotorType.kBrushed);
        encoder = motor.getEncoder(Type.kQuadrature, 4096);

        // 🟪🟪🟪🟪 Initialize your PID controller here: 🟪🟪🟪🟪

		state = GearboxStates.OFF;


        // 🟪🟪🟪🟪 set your PID gains here: 🟪🟪🟪🟪
	}

	public Command runMotorCommand(double vbus) {
		return runOnce(() -> {
			targetVbus = vbus;
			if (targetVbus > 0)
				state = GearboxStates.INFEED;
			else if (targetVbus < 0)
				state = GearboxStates.OUTFEED;
			else
				state = GearboxStates.OFF;
		});
	}

    public Command runToPositionCommand(double position) {
        // 🟪🟪🟪🟪 Here, return a command to set the targetPosition to the input position. 🟪🟪🟪🟪
        // 🟪🟪🟪🟪          Also, change the state to GearboxStates.POSITION               🟪🟪🟪🟪

        // ❌❌ Delete this line: ❌❌
        return Commands.none();
    }

    public double getPosition() {
        return encoder.getPosition();
    }

	@Override
	public void periodic() {
		switch (state) {
			case OFF:
				motor.set(0.0);
				break;
			case INFEED:
				motor.set(targetVbus);
				break;
			case OUTFEED:
				motor.set(targetVbus);
				break;
            case POSITION:
                // 🟪🟪🟪🟪 Put the behavior of the motor in the position state here: 🟪🟪🟪🟪
                break;
		}
	}
}
