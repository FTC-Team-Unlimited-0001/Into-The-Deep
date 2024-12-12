package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class ExtendSlides implements Action {
    private DeepTeleop teleop;
    private double target;

    public ExtendSlides(DeepTeleop teleop, double target) {
        this.teleop = teleop;
        this.target = target;

    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        teleop.robot.slidesTargetPosition = target;

        teleop.controlSlidesWithPIDF();
        //stops the action
        return Math.abs(teleop.robot.spoolleft.getCurrentPosition()-teleop.robot.slidesTargetPosition) > 50;
        //Tolerance, (Within 50, dont send anything)
    }
}
