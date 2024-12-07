package org.firstinspires.ftc.teamcode.util;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AllFunc {
    public machine robot;
    public AllFunc(machine robot) {
        this.robot = robot;
    }


    public void angleup(){
        DeepTeleop telee = new DeepTeleop();
        robot.anglerright.setTargetPosition(250);
        robot.anglerleft.setTargetPosition(250);
        telee.controlArmsWithPIDF();
    }
    public void angledown(){
        DeepTeleop telee = new DeepTeleop();
        robot.anglerright.setTargetPosition(950);
        robot.anglerleft.setTargetPosition(950);
        telee.controlArmsWithPIDF();
    }
    public void clawopen(){
        DeepTeleop telee = new DeepTeleop();
        robot.servopinch.setPosition(0.35);
    }
    public void clawclose(){
        DeepTeleop telee = new DeepTeleop();
        robot.servopinch.setPosition(0);
    }
    public void diffpick(){
        DeepTeleop telee = new DeepTeleop();
        robot.servoleft.setPosition(0);
        robot.servoright.setPosition(0);
    }
    public void diffput(){
        DeepTeleop telee = new DeepTeleop();
        robot.servoleft.setPosition(.63);
        robot.servoright.setPosition(.63);
    }

    public void moveSlidesToPosition(int targetPosition, double power) {
        // Reset the motor encoders if needed
        robot.spoolleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.spoolright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set the target position
        robot.spoolleft.setTargetPosition(targetPosition);
        robot.spoolright.setTargetPosition(targetPosition);

        // Set the motors to run to the target position
        robot.spoolleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.spoolright.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // Apply power to the motors
        robot.spoolleft.setPower(power);
        robot.spoolright.setPower(power);

        // Wait for the motors to reach the target position
        while (robot.spoolleft.isBusy() && robot.spoolright.isBusy()) {
            // You can add telemetry here to monitor the positions
            telemetry.addData("Left Slide Position", robot.spoolleft.getCurrentPosition());
            telemetry.addData("Right Slide Position", robot.spoolright.getCurrentPosition());
            telemetry.update();
        }

        // Stop the motors once the target is reached
        robot.spoolleft.setPower(0);
        robot.spoolright.setPower(0);

        // Set the motors back to normal mode
        robot.spoolleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.spoolright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    }



//angle up/down
//openclaw/closeclaw
//spin diff back/forward
//extend Retract***************