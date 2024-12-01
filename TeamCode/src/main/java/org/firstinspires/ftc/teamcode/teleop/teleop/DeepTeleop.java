package org.firstinspires.ftc.teamcode.teleop.teleop;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.LLresults;
import org.firstinspires.ftc.teamcode.util.machine;


@Config
@TeleOp

public class DeepTeleop extends LinearOpMode{

    private final FtcDashboard dashboard = FtcDashboard.getInstance();

    public machine robot;


    @Override
    public void runOpMode() throws InterruptedException {

        robot = new machine(hardwareMap);


        //Telem stuff
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        telemetry.addData("status", "initalized");
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetry.update();

        IMU imu = hardwareMap.get(IMU.class, "imu");
// Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
// Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);


        LLresults limelight = new LLresults();
        limelight.init(hardwareMap);



        ElapsedTime timer = new ElapsedTime();


        waitForStart();

        timer.reset();

        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            DcMotor.ZeroPowerBehavior brake = gamepad1.left_bumper ? DcMotor.ZeroPowerBehavior.BRAKE : DcMotor.ZeroPowerBehavior.FLOAT;
            robot.frontLeft.setZeroPowerBehavior(brake);
            robot.backRight.setZeroPowerBehavior(brake);
            robot.backLeft.setZeroPowerBehavior(brake);
            robot.backRight.setZeroPowerBehavior(brake);


            if (gamepad1.left_bumper) {
                robot.frontLeft.setPower(frontLeftPower / 3);
                robot.backLeft.setPower(backLeftPower / 3);
                robot.frontRight.setPower(frontRightPower / 3);
                robot.backRight.setPower(backRightPower / 3);
            } else {
                robot.frontLeft.setPower(frontLeftPower);
                robot.backLeft.setPower(backLeftPower);
                robot.frontRight.setPower(frontRightPower);
                robot.backRight.setPower(backRightPower);
            }




            //Preset variables:
            int high_basket = 400;
            int pickup = 1000;
            int clipper = 450;
            int pickup_assist = 900;

            //Claw presets
            double open = 0.5;
            double close = 0;

            //Spools
            double MAX_POSITION = 3140;
            double MIN_POSITION = 0;

            double big = 0.5;



            if (timer.milliseconds() > 500) {
                // Handle servo positions
                if (gamepad2.x) {
                    robot.servoright.setPosition(big);// Example: fully open position
                    robot.servoleft.setPosition(big);
                    timer.reset();
                }
                if (gamepad2.b) {
                    robot.servoleft.setPosition(robot.servoleft.getPosition() + 0.1);
                    robot.servoright.setPosition(robot.servoright.getPosition() + 0.1);
                    timer.reset();
                }
                if(gamepad2.left_bumper){
                    robot.servoleft.setPosition(robot.servoleft.getPosition() - 0.5);
                    robot.servoright.setPosition(robot.servoright.getPosition() - 0.5);
                    timer.reset();
                }
            }
            if (gamepad2.y) {
                robot.servopinch.setPosition(open);  // Example: partially open position
            } else if (gamepad2.a) {
                robot.servopinch.setPosition(close);   // Fully closed position
            }

            // Handle spool power for lifting mechanism

            // Get the trigger values
            double extendPower = gamepad1.right_trigger;  // Extending slides
            double retractPower = gamepad1.left_trigger;  // Retracting slides

            // Calculate motor power
            double slidePower = extendPower - retractPower;  // Combine triggers for bidirectional control

            // Set power to the slide motor
            robot.spoolleft.setPower(slidePower);
            robot.spoolright.setPower(slidePower);

            if (robot.spoolright.getCurrentPosition() >= MAX_POSITION && slidePower > 0) {
                slidePower = 0;  // Prevent extending further
            } else if (robot.spoolright.getCurrentPosition() <= MIN_POSITION && slidePower < 0) {
                slidePower = 0;  // Prevent retracting further
            }

            robot.spoolright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            robot.spoolleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            telemetry.addData("Slide Pos", robot.spoolleft.getCurrentPosition());
            telemetry.addData("Slide Power", slidePower);
            telemetry.update();

//            if (gamepad1.a) {
//                robot.spoolleft.setPower(1);
//                robot.spoolright.setPower(1);  // Spool moving up
//            } else if (gamepad1.x) {
//                robot.spoolleft.setPower(-1);
//                robot.spoolright.setPower(-1); // Spool moving down
//            } else {
//                robot.spoolleft.setPower(0);
//                robot.spoolright.setPower(0);  // Stop spool
//            }

            // Handle arm target position adjustments
            if (gamepad2.dpad_up) {
                robot.armTargetPosition = high_basket;  // Increment target position
            } else if (gamepad2.dpad_down) {
                robot.armTargetPosition = pickup_assist;    // Decrement target position
            }

            if (gamepad2.right_bumper) {
                robot.armTargetPosition = clipper;  // Set specific position
            }

            if (gamepad2.dpad_right) {
                robot.armTargetPosition = pickup; // Set to maximum position
            }


            robot.updatePIDFCoefficients();
            controlArmsWithPIDF();
            double angle = limelight.getOrientation();

            telemetry.addData("Sample Orientation", angle);

        }
    }

        // Method to control the arms using PIDF controller
        private void controlArmsWithPIDF() {

        // Get the current position of both arms (average)
            double currentPosition = (robot.anglerright.getCurrentPosition());

            // Calculate PID output
            double armOutput = robot.armPIDFController.calculate(currentPosition, robot.armTargetPosition);

            // Apply the output to both motors
            robot.anglerleft.setPower(armOutput);
            robot.anglerright.setPower(armOutput);

            // Telemetry to display information on the driver station
            telemetry.addData("Arm Target", robot.armTargetPosition);
            telemetry.addData("Arm Position", currentPosition);
            telemetry.addData("PIDF Output", armOutput);
            telemetry.addData("Left Arm Encoder", robot.anglerleft.getCurrentPosition());
            telemetry.addData("Right Arm Encoder", robot.anglerright.getCurrentPosition());
            telemetry.addData("right spool pos",robot.spoolright.getCurrentPosition());
            telemetry.update();


        }



// pid issue , use 1

}
