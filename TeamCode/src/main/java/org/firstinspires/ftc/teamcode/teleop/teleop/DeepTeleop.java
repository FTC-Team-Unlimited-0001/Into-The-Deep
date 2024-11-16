package org.firstinspires.ftc.teamcode.teleop.teleop;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;

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


        waitForStart();

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
                robot.frontLeft.setPower(frontLeftPower / 4);
                robot.backLeft.setPower(backLeftPower / 4);
                robot.frontRight.setPower(frontRightPower / 4);
                robot.backRight.setPower(backRightPower / 4);
            } else {
                robot.frontLeft.setPower(frontLeftPower);
                robot.backLeft.setPower(backLeftPower);
                robot.frontRight.setPower(frontRightPower);
                robot.backRight.setPower(backRightPower);
            }

            if (gamepad2.x){
                robot.servoright.setPower(0.5);
            }
            if(gamepad2.y){
                robot.servopinch.setPosition(70);
            }
            if(gamepad2.a){
                robot.servopinch.setPosition(0);
            }

            if (gamepad1.a) {
                robot.spoolleft.setPower(1);
                robot.spoolright.setPower(1);
            } else if (gamepad1.x) {
                robot.spoolleft.setPower(-1);
                robot.spoolright.setPower(-1);
            } else {
                robot.spoolleft.setPower(0);
                robot.spoolright.setPower(0);
            }

            if (gamepad2.dpad_up) {
                robot.armTargetPosition = 125;  // Increment target position (move up)

            } else if (gamepad2.dpad_down) {
                robot.armTargetPosition = 0;  // Decrement target position (move down)

            }

            if(gamepad2.right_bumper){
                robot.armTargetPosition = 200;
            }
            if(gamepad2.dpad_right){
                robot.armTargetPosition = 690;
            }


            robot.updatePIDFCoefficients();
            controlArmsWithPIDF();

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
            telemetry.update();

        }



// pid issue , use 1

}
