package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TakeIn extends Command {

  private final Intake m_intake;
  private final double m_speed;
  
  public TakeIn(Intake intake, double speed) {
    m_intake = intake;
    m_speed = speed;
    addRequirements(m_intake);
  }

  @Override
    public void initialize() {
        m_intake.setSpeed(m_speed); 
    }

  }
