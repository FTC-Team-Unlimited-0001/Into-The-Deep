package org.firstinspires.ftc.teamcode.util;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.actions.CloseClawAction;
import org.firstinspires.ftc.teamcode.actions.OpenClawAction;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AllFunc {
    public machine robot;
    private DeepTeleop teleop;

    public AllFunc(DeepTeleop teleop) {
        this.teleop = teleop;
        this.robot = this.teleop.robot;
    }


    public void angleup(){
        robot.anglerright.setTargetPosition(250);
        robot.anglerleft.setTargetPosition(250);
        teleop.controlArmsWithPIDF();
    }
    public void angledown(){
        robot.anglerright.setTargetPosition(950);
        robot.anglerleft.setTargetPosition(950);
        teleop.controlArmsWithPIDF();
    }
    public Action clawopen(){
        return new OpenClawAction(teleop);
    }
    public Action clawclose(){
        return new CloseClawAction(teleop);
    }
    public void diffpick(){
        robot.servoleft.setPosition(0);
        robot.servoright.setPosition(0);
    }
    public void diffput(){
        robot.servoleft.setPosition(.63);
        robot.servoright.setPosition(.63);
    }

    public void moveSlidesToPosition(int targetPosition, double power) {
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