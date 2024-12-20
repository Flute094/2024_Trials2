// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;





import frc.robot.subsystems.Drive;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.commands.TakeIn;
import frc.robot.commands.UpArm;
import frc.robot.commands.DownArm;
import frc.robot.commands.Launch;
import frc.robot.subsystems.Pneumatics;



import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drive m_drive = new Drive();
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Intake m_Intake = new Intake();
  private final Pneumatics m_pneumatics = new Pneumatics();

  //private GenericEntry speedVeriable = Shuffleboard.getTab("1").add("Speed", .98).getEntry();
  private double speedVariable = .98;
  
GenericEntry speed = Shuffleboard.getTab("Drive").add("Speed", speedVariable).getEntry();


  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_pneumatics.initialize();
  }
  
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    //new Trigger(m_exampleSubsystem::exampleCondition)
        //.onTrue(new ExampleCommand(m_exampleSubsystem));

    
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    m_drive.setDefaultCommand(
        m_drive.arcadeDriveCommand(
            () -> m_driverController.getLeftY()*speedVariable, () -> -m_driverController.getRightX()*speedVariable));
    m_driverController.leftBumper().whileTrue(new TakeIn(m_Intake));
    m_driverController.rightBumper().whileTrue(new Launch(m_Intake));
    m_driverController.y().onTrue(new UpArm(m_pneumatics));
    m_driverController.a().onTrue(new DownArm(m_pneumatics));
   
    
    
    
    
  }



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}

