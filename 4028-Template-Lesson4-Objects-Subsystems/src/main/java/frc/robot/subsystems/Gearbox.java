// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gearbox extends SubsystemBase {

    public enum GearboxStates {
        OUTFEED,
        OFF,
        INFEED
    }

    // 🟪🟪🟪 Declare motor here: 🟪🟪🟪


    private GearboxStates state;

    // 🟪🟪🟪 Declare targetPosition here: 🟪🟪🟪


    public Gearbox() {
        // 🟪🟪🟪 Initialize motor here: 🟪🟪🟪
        
        
        state = GearboxStates.OFF;
    }

    // 🟪🟪🟪 Create a function that returns a command that changes the state here: 🟪🟪🟪



    // 🟪🟪🟪 Create a function that sets the target vbus for the gearbox here: 🟪🟪🟪


    @Override
    public void periodic() {
        switch (state) {
            case OFF:
                // 🟪🟪🟪 Put the behavior of the motor in the off state here: 🟪🟪🟪


                break;
            case INFEED:
                // 🟪🟪🟪 Put the behavior of the motor in the infeeding state here: 🟪🟪🟪


                break;
            case OUTFEED:
                // 🟪🟪🟪 Put the behavior of the motor in the outfeeding state here: 🟪🟪🟪


                break;
        }  
    }
}
