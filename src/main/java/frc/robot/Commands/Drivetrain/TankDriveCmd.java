// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.Drivetrain;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Subsystems.DrivetrainSubsystem;

public class TankDriveCmd extends Command {
  // Create the necessary variables.
  private DrivetrainSubsystem driveSub;
  private DoubleSupplier leftInput, rightInput;


  /** Creates a new TankDriveCmd. */
  public TankDriveCmd(
    // The arguments (settings) that this command will accept.
    DrivetrainSubsystem driveSub,
    DoubleSupplier leftInput, DoubleSupplier rightInput //supplied from robotcontainer,
  ) {
    this.driveSub = driveSub;
    this.leftInput = leftInput;
    this.rightInput = rightInput;

    addRequirements(driveSub);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Creating variables called "left" and "right". Not necessary.
    double left = leftInput.getAsDouble() * DrivetrainConstants.speed;
    double right = rightInput.getAsDouble() * DrivetrainConstants.speed;

    driveSub.tankDriveSpeed( // Calling the "tankDrive" function in the DrivetrainSubsystem.java file.
      Math.signum(left)*(Math.sqrt(Math.abs(left))),
      Math.signum(right)*(Math.sqrt(Math.abs(right)))
    );

    // Pushing numbers onto SmartDashboard for debugging purposes.
    SmartDashboard.putNumber("Drivetrain Left Speed Input", leftInput.getAsDouble());
    SmartDashboard.putNumber("Drivetrain Right Speed Input", rightInput.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
