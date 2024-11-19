package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Pneumatics;

/** An example command that uses an example subsystem. */
public class DownArm extends Command {

  private final Pneumatics m_pneumatics;
  
  public DownArm(Pneumatics pneumatics) {
    m_pneumatics = pneumatics;
    addRequirements(m_pneumatics);
  }

  @Override
    public void initialize() {
        m_pneumatics.DOWN(); 
    }
  }
