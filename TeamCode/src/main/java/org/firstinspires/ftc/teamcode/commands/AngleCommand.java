package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.machine;

public class AngleCommand extends CommandBase {
    private machine robot;
    private ElapsedTime timer;
    private double target;
    private double timeout;

    public AngleCommand(machine robot, double target, double timeout) {
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
        robot.servoAngularLeft.setPosition(target);
        robot.servoAngularRight.setPosition(target);
    }

    @Override
    public boolean isFinished() {
        return timer.milliseconds() > timeout;
    }
}
