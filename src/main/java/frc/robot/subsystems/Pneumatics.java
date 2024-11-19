// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;


import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
/** Add your docs here. */
public class Pneumatics extends SubsystemBase{

    public final DoubleSolenoid lSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
   
    public Pneumatics(){
    }
    
    public void UP(){
       lSolenoid.set(DoubleSolenoid.Value.kForward); 
    }

    public void DOWN(){
       lSolenoid.set(DoubleSolenoid.Value.kReverse); 
    }

    public void TOGGLE(){
        lSolenoid.toggle();
    }

    public void initialize(){
        lSolenoid.set(DoubleSolenoid.Value.kForward);
    }    
    
}
