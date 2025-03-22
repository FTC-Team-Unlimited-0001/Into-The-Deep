package org.firstinspires.ftc.teamcode.teleop.teleop;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Vision.Limelight;
import org.firstinspires.ftc.teamcode.commands.BucketDropCommandGroup;
import org.firstinspires.ftc.teamcode.commands.DiffMoveCommandGroup;
import org.firstinspires.ftc.teamcode.ttquckstart.base.BaseOpMode;
import org.firstinspires.ftc.teamcode.util.machine;

@TeleOp
public class newdeepTeleOpMode extends BaseOpMode {
    private machine robot;
    ElapsedTime  timer;
    @Override
    public void initialize() {
        robot = new machine(hardwareMap);
       // Limelight limelight = new Limelight(robot.limelight, telemetry);
        int high_basket = 250;
        int pickup = 950;
        int clipper = 450;


        //Claw presets
        double open = 0.35;
        double close = 0;

        //Spools
        timer = new ElapsedTime();

        //Telem stuff
        telemetry = new MultipleTelemetry(telemetry);
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


        robot = new machine(hardwareMap);
        GamepadEx driverGamepad = new GamepadEx(gamepad1);
        GamepadEx manipulatorGamepad = new GamepadEx(gamepad2);
        DiffMoveCommandGroup diffMoveCommandGroup = new DiffMoveCommandGroup(robot);
        manipulatorGamepad.getGamepadButton(GamepadKeys.Button.LEFT_STICK_BUTTON).whenPressed(diffMoveCommandGroup);
        BucketDropCommandGroup example = new BucketDropCommandGroup(robot);
      //  driverGamepad.getGamepadButton(GamepadKeys.Button.A).whenPressed(example);
    }

    @Override
    public void justAfterStart() {

    }

    @Override
    public void update() {
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
        robot.frontRight.setZeroPowerBehavior(brake);

        robot.spoolleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.spoolright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.hangleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.hangrright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        double open = 0.35;
        double close = 0;




        if (gamepad1.left_bumper) {
            robot.frontLeft.setPower(frontLeftPower / 2);
            robot.backLeft.setPower(backLeftPower / 2);
            robot.frontRight.setPower(frontRightPower / 2);
            robot.backRight.setPower(backRightPower / 2);
        } else {
            robot.frontLeft.setPower(frontLeftPower);
            robot.backLeft.setPower(backLeftPower);
            robot.frontRight.setPower(frontRightPower);
            robot.backRight.setPower(backRightPower);
        }


        //Preset variables:

        if (gamepad1.left_bumper) {
            robot.frontLeft.setPower(frontLeftPower / 2);
            robot.backLeft.setPower(backLeftPower / 2);
            robot.frontRight.setPower(frontRightPower / 2);
            robot.backRight.setPower(backRightPower / 2);
        } else {
            robot.frontLeft.setPower(frontLeftPower);
            robot.backLeft.setPower(backLeftPower);
            robot.frontRight.setPower(frontRightPower);
            robot.backRight.setPower(backRightPower);
        }


        //Preset variables:


        if (timer.milliseconds() > 100) {
            // Handle servo positions
            if (gamepad2.x) {
                robot.servoright.setPosition(3.15);// Example: fully open position
                robot.servoleft.setPosition(1.44);
                timer.reset();
            }
            if (gamepad2.ps) {
                robot.servoAngularRight.setPosition(.4);// Example: fully open position
                robot.servoAngularLeft.setPosition(.4);
                timer.reset();
            }
            if (gamepad2.left_bumper) {
                robot.servoleft.setPosition(0);
                robot.servoright.setPosition(0);
                timer.reset();
            }

            if (gamepad2.dpad_up) {
                robot.servoAngularLeft.setPosition(.26);
                robot.servoAngularRight.setPosition(.26);

            }

            if (gamepad2.dpad_down) {
                robot.servoAngularRight.setPosition(1);
                robot.servoAngularLeft.setPosition(1);

            }
            if (gamepad2.dpad_right) {
                robot.servoAngularRight.setPosition(.18);
                robot.servoAngularLeft.setPosition(.18);

            }


            if (gamepad2.dpad_left) {
                robot.servoAngularRight.setPosition(.75);
                robot.servoAngularLeft.setPosition(.75);
            }


            if (gamepad2.right_bumper) {
                robot.servoleft.setPosition(.63);
                robot.servoright.setPosition(.63);
                timer.reset();
            }
            if (gamepad2.start) {
                robot.servoleft.setPosition(.3);
                robot.servoright.setPosition(.3);
                timer.reset();
            }
            if (gamepad2.right_stick_button) {
                robot.servoAngularRight.setPosition(0);
                robot.servoAngularLeft.setPosition(0);
            }

            if (gamepad2.b) {
                robot.servoleft.setPosition(1.26);
                robot.servoright.setPosition(.22);
            }
            if (gamepad2.a) {
                robot.servopinch.setPosition(open);

            }
            if (gamepad2.y) {
                robot.servopinch.setPosition(close);
                 ;
            }
        }

        //VERY USEFUL FOR FINDING SERVO POSTION DONT DELTE
        if (gamepad2.back){for (double pos = 0.0; pos <= 1.0; pos += 0.05) {  // Adjust max range if needed
            robot.servoAngularLeft.setPosition(pos);
            robot.servoAngularRight.setPosition(pos);
            telemetry.addData("Servo Position", pos);
            telemetry.update();
            sleep(1000); } // Wait to observe}
        }
        if (gamepad1.ps) {
            for (double pos = 0.0; pos <= 1.0; pos += 0.05) {  // Adjust max range if needed
                robot.servoleft.setPosition(pos);         // Left servo moves from 0 to 1
                robot.servoright.setPosition(1.0 - pos);  // Right servo moves from 1 to 0

                telemetry.addData("Left Servo Position", pos);
                telemetry.addData("Right Servo Position", 1.0 - pos);
                telemetry.update();

                sleep(1000); // Wait to observe
            }
        }



        // Handle spool power for lifting mechanism


//limelight.getPythonOutput();

        //     limelight.getAdjustedLateralDistance();

        //  limelight.getDistanceToTarget();

slidecontrol();
        // controlArmsWithPIDF();


    }
    public void slidecontrol() {
        // Get the trigger values
        double extendPower = gamepad1.right_trigger;  // Extending slides
        double retractPower = gamepad1.left_trigger;  // Retracting slides

        // Limit
        double slidePower = -(extendPower - retractPower);
        boolean isanglesDown = robot.servoAngularLeft.getPosition() >= Math.toRadians(40) && robot.servoAngularRight.getPosition() >= Math.toRadians(40);
        if ((robot.spoolleft.getCurrentPosition() <= -360 && slidePower < 0 && isanglesDown) ||
                (robot.spoolleft.getCurrentPosition() >= 0 && slidePower > 0)) {
            slidePower = 0;  // Prevent further movement
        }


        // Set power to the slide motor
        robot.spoolleft.setPower(slidePower);
        robot.spoolright.setPower(slidePower);
        robot.hangrright.setPower(slidePower);
        robot.hangleft.setPower(slidePower);


//
//
//        telemetry.addData("encoder position" , robot.spoolright.getCurrentPosition());
//
//
        telemetry.addData("Slide Pos", robot.spoolleft.getCurrentPosition());
        telemetry.addData("Slide Power", slidePower);
//        telemetry.addData("Right Servo", robot.servoright.getPosition());
//        telemetry.addData("Left Servo", robot.servoleft.getPosition());
    }
}



        // Retrieve results from the pipeline





