package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class CloseClawAction implements Action {
    private DeepTeleop teleop;
    private boolean ranOnce;
    private ElapsedTime timer;

    public CloseClawAction(DeepTeleop teleop) {
        this.teleop = teleop;
        ranOnce = false;
        timer = new ElapsedTime();
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        if (!ranOnce) {
            timer.reset();
            ranOnce = true;
        }
        teleop.robot.servopinch.setPosition(0);
        return timer.milliseconds() < 200;
    }
}
