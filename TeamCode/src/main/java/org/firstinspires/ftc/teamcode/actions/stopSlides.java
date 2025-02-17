package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;


public class stopSlides implements Action {
    private DeepTeleop teleop;

    public stopSlides(DeepTeleop teleop) {
        this.teleop = teleop;


    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        double slideOutput=0;
        teleop.robot.spoolright.setPower(slideOutput);
        teleop.robot.spoolleft.setPower(slideOutput);
        teleop.robot.hangrright.setPower(slideOutput);
        teleop.robot.hangleft.setPower(slideOutput);

    return false;
    }
}
