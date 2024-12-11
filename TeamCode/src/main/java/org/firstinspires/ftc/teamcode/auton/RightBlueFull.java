package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.PinpointDrive;
import org.firstinspires.ftc.teamcode.util.machine;

@Config
@Autonomous(name = "RightBlueFull", group = "Autonomous")
public class RightBlueFull extends LinearOpMode {

    public machine robot;

    @Override
    public void runOpMode() throws InterruptedException {
        // Instantiate the SampleMecanumDrive (machine)
        robot = new machine(hardwareMap);
        telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        Pose2d initialPose = new Pose2d(-24, -63, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);


        waitForStart();


            Actions.runBlocking(
                    drive.actionBuilder(initialPose)

                            .strafeTo(new Vector2d(-26, -55))
                            //.lineToX(-55)
                            //.waitSeconds(3)
                            .strafeTo(new Vector2d(-59, -59))
                            .turnTo(.9)
//                            .waitSeconds(10)
//
                            .build());



    }
}