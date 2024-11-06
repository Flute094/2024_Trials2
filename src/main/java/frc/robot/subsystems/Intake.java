// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;


/** Add your docs here. */
public class Intake extends SubsystemBase{
    
    private final WPI_TalonSRX ritghtLauncherTalon = new WPI_TalonSRX (9);
   private final WPI_TalonSRX  leftLauncherTalon = new WPI_TalonSRX (6);

   public Intake(){
    leftLauncherTalon.follow(ritghtLauncherTalon);
   }


    public Command Launch() {
       
        
        return runOnce(()-> ritghtLauncherTalon.setVoltage(.1)).andThen(run(()-> new WaitCommand(4)).andThen(()-> ritghtLauncherTalon.setVoltage(0)));
    }
    

    public Command Suck_In() {
       return startEnd(()-> ritghtLauncherTalon.setVoltage(-.1), ()-> ritghtLauncherTalon.setVoltage(0));
    
       
    }
  
    
   
}
