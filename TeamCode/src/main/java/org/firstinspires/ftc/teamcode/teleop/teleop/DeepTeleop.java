package org.firstinspires.ftc.teamcode.teleop.teleop;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.teamcode.util.machine;

@Config
@TeleOp(name = "Deep TeleOp", group = "TeleOp")
public class DeepTeleop extends LinearOpMode {

    private final FtcDashboard dashboard = FtcDashboard.getInstance();

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize the robot hardware using the updated machine class
        machine robot = new machine(hardwareMap);

        // Setup telemetry to use both the default telemetry and the FtcDashboard telemetry
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // IMU initialization
        IMU imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        imu.initialize(parameters);

        waitForStart();

        while (opModeIsActive()) {
            // Drive control logic
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Compute motor powers
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            // Implement slow mode with left bumper
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

            // ===== CRServo Control Logic =====

            // First Intake Servo Control (gamepad1 right trigger and left trigger)
            if (gamepad1.right_trigger > 0.1) {
                robot.intakeServo.setPower(gamepad1.right_trigger);  // Spin intake forward based on trigger pressure
            } else if (gamepad1.left_trigger > 0.1) {
                robot.intakeServo.setPower(-gamepad1.left_trigger);  // Spin intake backward based on trigger pressure
            } else {
                robot.intakeServo.setPower(0);  // Stop intake when triggers are not pressed
            }



            // Telemetry updates for debugging and feedback
            telemetry.addData("Intake Servo Power", robot.intakeServo.getPower());
            telemetry.addData("Higher Intake Servo Power", robot.higherIntakeServo.getPower());
            telemetry.update();
        }
    }
}
