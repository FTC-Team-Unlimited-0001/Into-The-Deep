package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class ExtendSlides implements Action {
    private DeepTeleop teleop;
    private double target;
    private boolean isExtending = false;
    private boolean isSlidesMoving = false; // No longer static

    public ExtendSlides(DeepTeleop teleop, double target) {
        this.teleop = teleop;
        this.target = target;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        if (isSlidesMoving) return false;
        isExtending = true;
        isSlidesMoving = true;

        teleop.robot.slidesTargetPosition = target;
        teleop.controlSlidesWithPIDF();

        boolean done = Math.abs(teleop.robot.spoolleft.getCurrentPosition() - teleop.robot.slidesTargetPosition) < 50;

        if (done) {
            isExtending = false;
            isSlidesMoving = false;
        }

        return !done;
    }
}
