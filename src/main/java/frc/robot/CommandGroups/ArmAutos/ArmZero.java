// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups.ArmAutos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.CommandGroups.MainAutos.AutoLog;
import frc.robot.Commands.Arm.ArmManualCmd;
import frc.robot.Subsystems.ArmSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ArmZero extends SequentialCommandGroup {
  /**
   * Slowly lowers the arm until the lower limit switch is pressed.
   * @param armSub Arm Subsystem
   */
  public ArmZero(
    ArmSubsystem armSub
  ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      // new AutoLog("Slowly lowering the arm back down to into intake position (zeroing the encoders)"),
      new ArmManualCmd(armSub,
        () -> 0.2
      ).until(
        () -> armSub.dropLimitSwitchHit()
      )
    );
  }
}
