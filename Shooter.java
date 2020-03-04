package frc.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
/**
 * Add your docs here.
 */

import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Shooter {
    public WPI_TalonFX talon6 = new WPI_TalonFX(6); // shooter back
    public WPI_TalonFX talon5 = new WPI_TalonFX(5); // shooter front
    public CANSparkMax turretSpark1 = new CANSparkMax(1, MotorType.kBrushless);
    public CANSparkMax hoodSpark2 = new CANSparkMax(2, MotorType.kBrushless);

    public CANEncoder spark1Encoder = new CANEncoder(turretSpark1);
    public CANPIDController spark1PID = new CANPIDController(turretSpark1);
    double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

    public CANEncoder spark2Encoder = new CANEncoder(hoodSpark2);
    public CANPIDController spark2PID = new CANPIDController(hoodSpark2);

    SpeedControllerGroup talonShooterGroup = new SpeedControllerGroup(talon5, talon6);

    private final Limelight limelight = new Limelight();

    public void initShooter(){
        spark1PID.setFeedbackDevice(spark1Encoder);
        spark1Encoder.setPosition(0);
        kP = 0.05;
        kI = 0;
        kD = 0;
        kIz = 0;
        kFF = 0;
        kMaxOutput = .35;
        kMinOutput = -.35;
        spark1PID.setP(kP);
        spark1PID.setI(kI);
        spark1PID.setD(kD);
        spark1PID.setIZone(kIz);
        spark1PID.setFF(kFF);
        spark1PID.setOutputRange(kMinOutput, kMaxOutput);

        spark2PID.setFeedbackDevice(spark2Encoder);
        spark2Encoder.setPosition(0);
        kP = 0.05;
        kI = 0;
        kD = 0;
        kIz = 0;
        kFF = 0;
        kMaxOutput = .35;
        kMinOutput = -.35;
        spark2PID.setP(kP);
        spark2PID.setI(kI);
        spark2PID.setD(kD);
        spark2PID.setIZone(kIz);
        spark2PID.setFF(kFF);
        spark2PID.setOutputRange(kMinOutput, kMaxOutput);
    }

    public void launchTracking(){ // this method will probably need some parameters/inputs Austin
        double[] launch = limelight.launcherTracking();
        turretSpark1.set(launch[0]);
        talonShooterGroup.set(launch[1]);
        spark1PID.setReference(launch[2], ControlType.kPosition);
    }



    // public void testShooter(){
    //     //talonShooterGroup.set(RobotMap.joystick.getY());
    //     if(RobotMap.joystick.getRawButton(12)){
    //         talon5.set(.5);
    //         talon6.set(.5);
    //     }

    //     if(RobotMap.joystick.getRawButton(11)){
    //         talon5.set(1.0);
    //         talon6.set(1.0);
    //     }

    //     if(RobotMap.joystick.getRawButton(10)){
    //         talon5.set(0);
    //         talon6.set(0);
    //     }
    // }

    // public void testMoveHood(){
    //     // if(RobotMap.joystick.getRawButton(8)){
    //     //     spark1Encoder.setPosition(0);
    //     //     spark1PID.setReference(5, ControlType.kPosition);
    //     // }

    //     // if(RobotMap.joystick.getRawButton(9)){
    //     //     spark1Encoder.setPosition(0);
    //     //     spark1PID.setReference(-5, ControlType.kPosition);
    //     // }

    //     // if(RobotMap.joystick.getRawButton(10)){
    //     //     spark1Encoder.setPosition(0);
    //     //     spark1PID.setReference(0, ControlType.kPosition);
    //     // }
    //     spark1.set(RobotMap.controller.getY());
    // }

    // //public void  
}