// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.CommandGroups.MainAutos;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoLog extends InstantCommand {
  private String message;

  /**
   * Prints and pushes text to Smart Dashboard under the key "Routine Log"
   * @param message The text to push
   */
  public AutoLog(String message) {this.message = message;}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putString("Routine Log", message);
    System.out.println("RoutineLog - " + message);
  }
}