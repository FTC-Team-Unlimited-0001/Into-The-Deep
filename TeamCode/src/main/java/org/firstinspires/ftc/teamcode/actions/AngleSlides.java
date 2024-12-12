package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AngleSlides implements Action {
    private DeepTeleop teleop;

    public AngleSlides(DeepTeleop teleop) {
        this.teleop = teleop;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {

       teleop.robot.armTargetPosition = 250;

        teleop.controlArmsWithPIDF();
        return true;

    }
}
