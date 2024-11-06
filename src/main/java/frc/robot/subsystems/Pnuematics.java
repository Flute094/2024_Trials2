// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
/** Add your docs here. */
public class Pnuematics extends SubsystemBase{
    private final Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);

    private final Solenoid lSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    private final Solenoid rSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);

    public Pnuematics(){
    compressor.enableDigital();
    }

    
    public Command armUp(){
    lSolenoid.set(true);
    rSolenoid.set(true);
    return para(null);
    } 

    public Command armDown(){
        lSolenoid.set(false);
        rSolenoid.set(false);
        return runOnce(null);
    }
       
       
    
}