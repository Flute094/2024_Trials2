// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import java.util.function.DoubleSupplier;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/** Add your docs here. */
public class Drive extends SubsystemBase{
    public static Object m_Drive;
    public final WPI_VictorSPX fLeft = new WPI_VictorSPX(8);
    private final WPI_VictorSPX bLeft = new WPI_VictorSPX(4);
    public final WPI_VictorSPX fRight = new WPI_VictorSPX(3);
    private final WPI_VictorSPX bRight = new WPI_VictorSPX(0);

    private DifferentialDrive m_drive = new DifferentialDrive(bLeft, bRight);
    
    public Drive(){
      fLeft.configFactoryDefault();
      fRight.configFactoryDefault();
      bLeft.configFactoryDefault();
      bRight.configFactoryDefault();

      //fLeft.set(ControlMode.Follower, bLeft.getDeviceID());
      //fRight.set(ControlMode.Follower, bRight.getDeviceID());
      fLeft.follow(bLeft);
      fRight.follow(bRight);
      
      bRight.setInverted(true);
      fRight.setInverted(InvertType.FollowMaster);
    }
   
  

 

  public Command arcadeDriveCommand(DoubleSupplier fwd, DoubleSupplier rot) {
    // A split-stick arcade command, with forward/backward controlled by the left
    // hand, and turning controlled by the right.
    
    return run(() -> m_drive.arcadeDrive(fwd.getAsDouble(), rot.getAsDouble()))
        .withName("arcadeDrive");
}}


 



