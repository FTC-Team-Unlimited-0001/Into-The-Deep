package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AngleSlides implements Action {
    private DeepTeleop teleop;

    public AngleSlides(DeepTeleop teleop) {
        this.teleop = teleop;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        teleop.robot.anglerright.setTargetPosition(250);
        teleop.robot.anglerleft.setTargetPosition(250);
        teleop.controlArmsWithPIDF();
        return true;
    }
}
