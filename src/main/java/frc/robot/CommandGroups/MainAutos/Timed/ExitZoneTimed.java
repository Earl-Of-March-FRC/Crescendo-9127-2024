// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups.MainAutos.Timed;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.CommandGroups.ArmAutos.ArmIntakePerimeter;
import frc.robot.CommandGroups.ArmAutos.ArmZero;
import frc.robot.CommandGroups.DrivetrainAutos.Timed.MoveOutOfZoneTimed.MoveOutOfZoneTimed1;
import frc.robot.Subsystems.ArmSubsystem;
import frc.robot.Subsystems.DrivetrainSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ExitZoneTimed extends SequentialCommandGroup {
  /** Creates a new ExitZoneTimed. */
  public ExitZoneTimed(
    DrivetrainSubsystem driveSub,
    ArmSubsystem armSub
  ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelCommandGroup(
        new MoveOutOfZoneTimed1(driveSub),
        new ArmZero(armSub).andThen(new ArmIntakePerimeter(armSub, () -> armSub.getController().atSetpoint()))
      )
    );
  }
}
