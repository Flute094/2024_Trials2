// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;

/** Add your docs here. */
public class Vision extends SubsystemBase{
    private final PhotonCamera camera = new PhotonCamera("Arducam_0V9281_USB_Camera");
    
    public Vision(){

        

    }
    public PhotonPipelineResult getLatestResult(){
        return camera.getLatestResult();
    }
}
