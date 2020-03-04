package frc.robot;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Indexer {
    public CANSparkMax indexerSpark5 = new CANSparkMax(5, MotorType.kBrushless);

    public CANEncoder spark5Encoder = new CANEncoder(indexerSpark5);
    public CANPIDController spark5PID = new CANPIDController(indexerSpark5);
    double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;

    public void indexerInit(){
        spark5PID.setFeedbackDevice(spark5Encoder);
        spark5Encoder.setPosition(0);
        kP = 0.05;
        kI = 0;
        kD = 0;
        kIz = 0;
        kFF = 0;
        kMaxOutput = .2;
        kMinOutput = -.2;
        spark5PID.setP(kP);
        spark5PID.setI(kI);
        spark5PID.setD(kD);
        spark5PID.setIZone(kIz);
        spark5PID.setFF(kFF);
        spark5PID.setOutputRange(kMinOutput, kMaxOutput);
    }
}
