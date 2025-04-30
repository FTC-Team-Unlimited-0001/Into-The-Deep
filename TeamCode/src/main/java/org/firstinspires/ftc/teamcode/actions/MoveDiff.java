package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

import java.lang.annotation.Target;

public class MoveDiff implements Action {
    private DeepTeleop teleop;
    private boolean ranOnce;
    private ElapsedTime timer;
    private double target;
    private double targettwo;

    public MoveDiff(DeepTeleop teleop, double target, double targettwo) {
        this.teleop = teleop;
        ranOnce = false;
        timer = new ElapsedTime();
        this.target = target;
        this.targettwo = targettwo;

    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        if (!ranOnce) {
            timer.reset();
            ranOnce = true;
        }
        teleop.robot.servoleft.setPosition(target);
        teleop.robot.servoright.setPosition(targettwo);
        return timer.milliseconds() < 200;
    }
}
