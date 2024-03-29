// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands.LED;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Subsystems.LEDSubsystem;

public class LEDOff extends InstantCommand {
  private LEDSubsystem led;
  /** Creates a new LEDturnOff. */
  public LEDOff(
    LEDSubsystem led
  ) {
    this.led = led;
    addRequirements(led);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    led.turnOff();
  }
}
