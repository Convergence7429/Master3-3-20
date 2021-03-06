package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {
  public static Gyro gyro = new Gyro();
  Climber climber = new Climber();
  Intake intake = new Intake();
  Shooter shooter = new Shooter();

  private final DriveTrain driveTrain = new DriveTrain();
  private final Limelight limeLight = new Limelight();
  private int autonomousStage;

  @Override
  public void robotInit() {
    driveTrain.robotInitDriveTrain();
    intake.intakeSolenoidOff();
    intake.openSolenoidOff();
    intake.spinnerSolenoidOff();
    // climber.climberInit();
    //shooter.initSpark1();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    //driveTrain.autoInitDrive();\
    driveTrain.autoInitDrive();
    autonomousStage = 0;
    //shoot()?
    //seek()?
    //shoot()?
  }

  @Override
  public void autonomousPeriodic() {
    if (autonomousStage == 0) {
      if (driveTrain.driveTrainByInches(24)) {
        autonomousStage = 1;
      }
    }
    if (autonomousStage == 1) {
      if (driveTrain.driveTrainByInches(-24)) {
        autonomousStage = 2;
      }
    }
    //driveTrain.autoDrivePeriodic();
  }

  @Override
  public void teleopInit() {
    //driveTrain.robotInitDriveTrain();
    //driveTrain.autoInitDrive();
    driveTrain.teleopInitDrive();
    //driveTrain.rotate();
  }


  @Override
  public void teleopPeriodic() {
    if (RobotMap.joystick.getRawButton(12)) {
      intake.openSolenoidForward();
      intake.intakeSolenoidForward();
      intake.spinnerSolenoidForward();
    }
    else {
      intake.openSolenoidReverse();
      intake.intakeSolenoidReverse();
      intake.spinnerSolenoidReverse();
    }
    // if (RobotMap.joystick.getRawButton(1) == true) {
    //   double[] steer = limeLight.ballTracking();
    //   SmartDashboard.putNumber("steer", steer[0]);
    //   SmartDashboard.putNumber("drive", steer[1]);
    //   driveTrain.driveTrainByLimelight(steer);
    // }
    // else {
    //   driveTrain.driveTrainByOperatorControl();
    // }

    // shooter.testShooter();
    // System.out.println("Talon 5: " + shooter.talon5.getSensorCollection().getIntegratedSensorVelocity());
    // System.out.println("Talon 6: " + shooter.talon6.getSensorCollection().getIntegratedSensorVelocity());
    driveTrain.driveTrainByOperatorControl();
    driveTrain.moveALittleBit();
    driveTrain.rotateSlowly();
    System.out.println(RobotMap.joystick.getPOV());
    
  }


  @Override
  public void testPeriodic() {
  }

  @Override
  public void disabledInit() {
    //driveTrain.disabledInitDrive();
  }
}