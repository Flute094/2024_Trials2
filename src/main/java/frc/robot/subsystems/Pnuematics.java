// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/** Add your docs here. */
public class Pnuematics extends SubsystemBase{
    private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

    public final DoubleSolenoid lSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 0);
   
 
    public Command armUp(){
   
    return runOnce(()-> lSolenoid.toggle()); 

    
    }

    public Command armDown(){
        
        return runOnce(()-> lSolenoid.toggle());
    }
       
       
    
}
