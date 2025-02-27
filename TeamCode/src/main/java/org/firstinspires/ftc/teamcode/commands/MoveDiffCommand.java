package org.firstinspires.ftc.teamcode.commands;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;
import org.firstinspires.ftc.teamcode.util.machine;

public class MoveDiffCommand extends CommandBase {
    private machine robot;
    private ElapsedTime timer;
    private double target;
    private double timeout;

    public MoveDiffCommand(machine robot, double target, double timeout) {
        this.robot = robot;
        timer = new ElapsedTime();
        this.target = target;
        this.timeout = timeout;
    }

    @Override
    public void initialize() {
        timer.reset();
    }

    @Override
    public void execute() {
        robot.servoleft.setPosition(target);
        robot.servoright.setPosition(target);
    }

    @Override
    public boolean isFinished() {
        return timer.milliseconds() > timeout;
    }
}
