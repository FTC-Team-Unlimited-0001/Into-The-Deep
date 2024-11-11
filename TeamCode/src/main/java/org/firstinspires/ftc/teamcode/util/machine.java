package org.firstinspires.ftc.teamcode.util;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class machine {

    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;

    public DcMotor spoolleft;
    public  DcMotor spoolright;

    public DcMotor anglerright;
    public DcMotor anglerleft;

    public PIDFController armPIDFController;
    public static double armTargetPosition;

    // PID coefficients
    public static double kP = 0.001;
    public static double kI = 0.001;
    public static double kD = 0.001;
    public static double kF = 0.05;




    public machine(HardwareMap hwMap) {
        initialize(hwMap);
    }

    HardwareMap hardwareMap;

    private void initialize(HardwareMap hwMap) {
        hardwareMap = hwMap;

        //Connect Motors
        frontRight = hardwareMap.get(DcMotor.class, "rightFront");
        frontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        backRight = hardwareMap.get(DcMotor.class, "rightBack");
        backLeft = hardwareMap.get(DcMotor.class, "leftBack");

        anglerright = hardwareMap.get(DcMotor.class, "anglerright");
        anglerleft = hardwareMap.get(DcMotor.class, "anglerleft");

        spoolleft = hardwareMap.get(DcMotor.class, "spoolleft");
        spoolright = hardwareMap.get(DcMotor.class, "spoolright");



        //Set motor direction
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        anglerright.setDirection(DcMotor.Direction.REVERSE);



        anglerright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        anglerright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        anglerleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        anglerleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Initialize the PID controller for the arms
        armPIDFController = new PIDFController(kP, kI, kD, kF);

        // Set an initial target position for the arms (e.g., 500 ticks)
        armTargetPosition = 0;

    }

    public void updatePIDFCoefficients() {
        armPIDFController.setPIDF(kP, kI, kD, kF);
    }
}
