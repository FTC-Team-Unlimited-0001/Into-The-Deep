package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.PathBuilder;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Trajectory;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.checkerframework.checker.units.qual.A;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.PinpointDrive;
import org.firstinspires.ftc.teamcode.actions.ParallelRaceAction;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;
import org.firstinspires.ftc.teamcode.util.AllFunc;
import org.firstinspires.ftc.teamcode.util.machine;

@Autonomous(name = "RightBlueFull", group = "Autonomous")
public class RightBlueFull extends DeepTeleop {
    private AllFunc allFunc;
    // Reference to AllFunc


    private final int slideUpPosition = 3140; // Adjust as needed
    private final int slideDownPosition = 0;  // Retracted position
    private final int motorpower = 1;
    private final int slidePickUpPosition = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        // Instantiate the SampleMecanumDrive (machine)
        robot = new machine(hardwareMap);
        allFunc = new AllFunc(this);


        Pose2d initialPose = new Pose2d(-42, -63, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);


        waitForStart();


        Actions.runBlocking(new ParallelRaceAction(
                new SequentialAction(
                        drive.actionBuilder(initialPose)
                                //.lineToX(-55)
                                .strafeTo(new Vector2d(-63, -54))
                                .turnTo(.8)
                                .build(),
                        allFunc.extendSlides(),
                        allFunc.diffput(),
                        allFunc.clawopen(),
                        allFunc.clawclose(),
                        allFunc.diffpick(),
                        allFunc.retractSlides()
               ),

                allFunc.angleup()
                )
        );
    }
}