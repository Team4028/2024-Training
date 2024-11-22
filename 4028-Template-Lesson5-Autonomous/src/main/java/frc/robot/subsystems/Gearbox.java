package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Gearbox extends SubsystemBase {

    private CANSparkMax motor;
    private GearboxStates state;
    private double targetVbus;

    private enum GearboxStates {
        OFF, FORWARD, REVERSE
    }

    public Command runForwardCommand(double vbus) {
        return Commands.runOnce(() -> {
            targetVbus = vbus;
            if (targetVbus > 0) {
                state = GearboxStates.FORWARD;
            } else if (targetVbus < 0) {
                state = GearboxStates.REVERSE;
            } else
                state = GearboxStates.OFF;
        });
    }

    public Gearbox() {
        motor = new CANSparkMax(13, MotorType.kBrushed);
        state = GearboxStates.OFF;
        targetVbus = 0.3;
    }

    public Command autonomousCommand() {
        // @formatter:off
        // 🟪🟪🟪🟪   Create an auton here to spin the motor forward at 0.4 vbus for 5 seconds and then  🟪🟪🟪🟪
        // 🟪🟪🟪🟪 backwards at 0.2 vbus for 6. Finally, have it spin forward at 0.2 vbus for 1 second. 🟪🟪🟪🟪
        // @formatter:on

        // ❌❌ Delete this line: ❌❌
        return Commands.none();
    }

    @Override
    public void periodic() {
        switch (state) {
            case OFF :
                motor.set(0.0);
                break;
            case FORWARD :
                motor.set(targetVbus);
                break;
            case REVERSE :
                motor.set(targetVbus);
                break;
        }
    }
}