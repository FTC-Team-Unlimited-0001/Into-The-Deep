package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AngleLinkages implements Action {
    private DeepTeleop teleop;
    public double servopos;

    public AngleLinkages(DeepTeleop teleop, double servopos) {
        this.teleop = teleop;
        this.servopos=servopos;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {

       teleop.robot.servoAngularRight.setPosition(servopos);
       teleop.robot.servoAngularLeft.setPosition(servopos);




        return true;

    }
}
