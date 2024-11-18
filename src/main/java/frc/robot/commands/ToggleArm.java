package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class ToggleArm extends Command {

  private final Pneumatics m_pneumatics;
  
  public ToggleArm(Pneumatics pneumatics) {
    m_pneumatics = pneumatics;
    addRequirements(m_pneumatics);
  }

  @Override
    public void initialize() {
        m_pneumatics.toggleArm(); 
    }
