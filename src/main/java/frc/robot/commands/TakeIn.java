package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.Command;

/** An example command that uses an example subsystem. */
public class TakeIn extends Command {

  private final Intake m_intake;
  
  public TakeIn(Intake intake) {
    m_intake = intake;
    addRequirements(m_intake);
  }

  @Override
    public void initialize() {
        m_intake.SetSpeed(1); 
    }

  @Override
    public void end(boolean interupted){
      m_intake.SetSpeed(0);
    }

  }
