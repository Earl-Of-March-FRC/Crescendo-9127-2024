// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.MjpegServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.util.PixelFormat;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {
  /** Creates a new CameraSubsystem. */
  //CvSource stream;
  public CameraSubsystem() {
    // Creates UsbCamera and MjpegServer [1] and connects them
    //CameraServer.startAutomaticCapture(0);

    //CameraServer.getVideo("Camerafeed");

    UsbCamera usbCamera = new UsbCamera("USB Camera 0", 0);
    MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
    mjpegServer1.setSource(usbCamera);

// // Creates the CvSink and connects it to the UsbCamera
// CvSink cvSink = new CvSink("opencv_USB Camera 0");
// cvSink.setSource(usbCamera);

// // Creates the CvSource and MjpegServer [2] and connects them
// CvSource outputStream = new CvSource("Blur", PixelFormat.kMJPEG, 640, 480, 30);
// MjpegServer mjpegServer2 = new MjpegServer("serve_Blur", 1182);
// mjpegServer2.setSource(outputStream);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // public CvSource getOutputStream(){
  //   return stream;
  // }
}

