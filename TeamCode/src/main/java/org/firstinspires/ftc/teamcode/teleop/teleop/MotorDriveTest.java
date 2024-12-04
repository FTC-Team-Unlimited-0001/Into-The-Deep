package org.firstinspires.ftc.teamcode.teleop.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.machine;

@Config
@TeleOp
public class MotorDriveTest extends LinearOpMode {
    machine robot;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new machine(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.a) {
                robot.frontLeft.setPower(0.5);
            }
            if (gamepad1.b) {
                robot.frontRight.setPower(0.5);
            }
            if (gamepad1.x) {
                robot.backRight.setPower(0.5);
            }
            if (gamepad1.y) {
                robot.backLeft.setPower(0.5);
            }

        }
        // Front Left is in 4



    }
}