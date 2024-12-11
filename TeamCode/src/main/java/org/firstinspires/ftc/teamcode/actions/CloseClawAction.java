package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class CloseClawAction implements Action {
    private DeepTeleop teleop;

    public CloseClawAction(DeepTeleop teleop) {
        this.teleop = teleop;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        teleop.robot.servopinch.setPosition(0);
        //stops the action
        return false;
    }
}
