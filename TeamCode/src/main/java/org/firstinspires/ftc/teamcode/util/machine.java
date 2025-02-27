package org.firstinspires.ftc.teamcode.util;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;

@Config
public class machine {

    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;

    public DcMotor spoolleft;
    public DcMotor spoolright;

    public DcMotor hangrright;
    public DcMotor hangleft;

    public  Limelight3A limelight;
    public Servo servoright;
    public Servo servoleft;
    public Servo servopinch;
   public Servo servoAngularRight;
    public Servo servoAngularLeft;

    public PIDFController armPIDFController;
    public PIDFController slidesPIDFController;
    public static double armTargetPosition;
    public static double slidesTargetPosition;

    // PID coefficients
    public static double kP = 0.0005;
    public static double kI = 0;
    public static double kD = 0.00001;
    public static double kF = 0;
    public static double kPs = 0.007;
    public static double kIs = 0;
    public static double kDs = 0;
    public static double kFs = 0.0006;
//f is for predicting the power before something has happened.



    public machine(HardwareMap hwMap) {
        initialize(hwMap);
    }

    HardwareMap hardwareMap;

    private void initialize(HardwareMap hwMap) {
        hardwareMap = hwMap;
        limelight = hardwareMap.get(Limelight3A.class, "limelight");

        //Connect Motors
        frontRight = hardwareMap.get(DcMotor.class, "rightFront");
        frontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        backRight = hardwareMap.get(DcMotor.class, "rightBack");
        backLeft = hardwareMap.get(DcMotor.class, "leftBack");

        hangrright = hardwareMap.get(DcMotor.class, "hangright");
        hangleft = hardwareMap.get(DcMotor.class, "hangleft");

        spoolleft = hardwareMap.get(DcMotor.class, "spoolleft");
        spoolright = hardwareMap.get(DcMotor.class, "spoolright");

        servoleft = hardwareMap.get(Servo.class, "servoleft");
        servoright = hardwareMap.get(Servo.class, "servoright");
        servopinch = hardwareMap.get(Servo.class, "servopinch");
        servoAngularRight = hardwareMap.get(Servo.class, "servoAngularRight");
       servoAngularLeft = hardwareMap.get(Servo.class, "servoAngularLeft");



        //Set motor direction
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        hangleft.setDirection(DcMotorSimple.Direction.REVERSE);
        hangrright.setDirection(DcMotorSimple.Direction.FORWARD);

        spoolleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spoolright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        hangrright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spoolleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spoolleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        spoolright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spoolright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        spoolleft.setDirection(DcMotor.Direction.REVERSE);
        servoleft.setDirection(Servo.Direction.REVERSE);
        //servo right reverse after


        // Initialize the PID controller for the arms
        armPIDFController = new PIDFController(kP, kI, kD, kF);
        slidesPIDFController = new PIDFController(kPs, kIs, kDs, kFs);
        // Set an initial target position for the arms (e.g., 500 ticks)
        armTargetPosition = 0;
        slidesTargetPosition = 0;

    }
    public void updatePIDFsCoeffecients(){
        slidesPIDFController.setPIDF(kPs, kIs, kDs, kFs);
    }

    public void controlSlidesWithPIDF() {
        updatePIDFsCoeffecients();
        // Get the current position of both arms (average)
        double currentPosition = (spoolleft.getCurrentPosition());

        // Calculate PID output
        double slideOutput = slidesPIDFController.calculate(currentPosition, slidesTargetPosition);

        if(Math.abs(currentPosition-slidesTargetPosition) < 25){

            slideOutput = 0;
        }
//  software limits

//        if ((currentPosition >= slidelimit && slideOutput > 0) ||
//                (currentPosition <= MIN_POSITION && slideOutput < 0)) {
//            slideOutput = 0;  // Prevent further movement
//        }
        // Apply the output to both motors
        spoolright.setPower(slideOutput);
        spoolleft.setPower(slideOutput);
        hangrright.setPower(slideOutput);
        hangleft.setPower(slideOutput);

    }

}

//Back up Straight
