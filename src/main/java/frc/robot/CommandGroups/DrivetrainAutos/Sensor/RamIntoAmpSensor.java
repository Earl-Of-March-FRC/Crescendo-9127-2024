// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups.DrivetrainAutos.Sensor;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.CommandGroups.MainAutos.AutoLog;
import frc.robot.Commands.Drivetrain.TankDrivePIDCmd;
import frc.robot.Subsystems.DrivetrainSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RamIntoAmpSensor extends SequentialCommandGroup {
  /** Creates a new RamIntoAmpSensor. */
  public RamIntoAmpSensor(
    DrivetrainSubsystem driveSub
  ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutoLog("Ramming into amp"),
      new TankDrivePIDCmd(driveSub,
        () -> driveSub.getLeftDistance() - 1.55,
        () -> driveSub.getRightDistance() - 1.55, //was 1.4
        () -> 0.2,
        () -> false,
        () -> false,
        () -> driveSub.isDriveControllersAtSetpoint()
      ).withTimeout(3),
      Commands.runOnce(() -> driveSub.resetGyro(), driveSub),
      new WaitCommand(1)
    );
  }
}
