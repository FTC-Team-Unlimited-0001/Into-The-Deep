package org.firstinspires.ftc.teamcode.commands;

import com.acmerobotics.roadrunner.Action;
import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.machine;

public class ExtendSlidesCommand extends CommandBase {
    private machine robot;
    private double target;

    public ExtendSlidesCommand(machine robot, double target) {
        this.robot = robot;
        this.target = target;
    }

    @Override
    public void initialize() {
        robot.slidesTargetPosition = target;
    }

    @Override
    public void execute() {
        robot.controlSlidesWithPIDF();
    }

    @Override
    public boolean isFinished() {
        return Math.abs(robot.spoolleft.getCurrentPosition() - robot.slidesTargetPosition) < 50;
    }

    @Override
    public void end(boolean interrupted) {
        double slideOutput=0;
        robot.spoolright.setPower(slideOutput);
        robot.spoolleft.setPower(slideOutput);
        robot.hangrright.setPower(slideOutput);
        robot.hangleft.setPower(slideOutput);
    }
}
