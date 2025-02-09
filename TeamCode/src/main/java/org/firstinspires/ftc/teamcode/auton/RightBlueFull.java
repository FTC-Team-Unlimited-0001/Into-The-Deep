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


    @Override
    public void runOpMode() throws InterruptedException {
        // Instantiate the SampleMecanumDrive (machine)
        robot = new machine(hardwareMap);
        allFunc = new AllFunc(this);


        Pose2d initialPose = new Pose2d(11, -69, Math.toRadians(90));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);


        waitForStart();


        Actions.runBlocking(new ParallelAction(
                drive.actionBuilder(initialPose)
                        .strafeTo(new Vector2d(11, -42))
                        .waitSeconds(1)

//                        .afterDisp(58, new ParallelAction(
//                                allFunc.specimanAngle(),
//                                allFunc.specimanExtendSlides(),
//                                allFunc.retractSlides(),
//                                allFunc.clawopen()
//                        ))

                       .strafeToConstantHeading(new Vector2d(34, -40))
//                        .afterDisp(84, new ParallelAction(
//                                allFunc.specimanPickUpAngle(),
//                                allFunc.clawopen()
//                        ))

                        .strafeToConstantHeading(new Vector2d(34, -10) )
//                        .afterDisp(107, new ParallelAction(
//                                allFunc.specimanAngle(),
//                                allFunc.specimanExtendSlides(),
//                                allFunc.retractSlides(),
//                                allFunc.clawopen()
//                        ))

                        .splineToConstantHeading(new Vector2d(40, -10), Math.toRadians(-90))
                        .lineToY(-56)
                      // .strafeTo(new Vector2d(44, -56))

//                        .afterDisp(115, new ParallelAction(
//                                allFunc.specimanPickUpAngle(),
//                                allFunc.clawopen()
//                        ))

                        .strafeTo(new Vector2d(51, -10) )
                        .strafeTo(new Vector2d(54, -55) )
                        .strafeTo(new Vector2d(60, -11) )
                        .strafeTo(new Vector2d(60, -55) )
//                        .splineToConstantHeading(new Vector2d(52, -56), Math.toRadians(-90))
//                        .splineToConstantHeading(new Vector2d(62, -10), Math.toRadians(-90))
//                        .splineToConstantHeading(new Vector2d(62, -56), Math.toRadians(-90))
//
//                        .setReversed(true)
//                        .splineTo(new Vector2d(47, -61), Math.toRadians(-270))
//                        .waitSeconds(1)

//                        .afterDisp(140, new ParallelAction(
//                                allFunc.specimanPickUpAngle(),
//                                allFunc.clawopen()
//                        ))

//                        .splineTo(new Vector2d(12, -36), Math.toRadians(90))
//                        .waitSeconds(1)

//                        .afterDisp(165, new ParallelAction(
//                                allFunc.specimanAngle(),
//                                allFunc.specimanExtendSlides(),
//                                allFunc.retractSlides(),
//                                allFunc.clawopen()
//                        ))

//                        .splineTo(new Vector2d(47, -61), Math.toRadians(270))
//                        .waitSeconds(1)

//                        .afterDisp(190, new ParallelAction(
//                                allFunc.specimanPickUpAngle(),
//                                allFunc.clawopen()
//                        ))

//                        .splineTo(new Vector2d(12, -36), Math.toRadians(90))
//                        .waitSeconds(1)

//                        .afterDisp(215, new ParallelAction(
//                                allFunc.specimanAngle(),
//                                allFunc.specimanExtendSlides(),
//                                allFunc.retractSlides(),
//                                allFunc.clawopen()
//                        ))

//                        .splineTo(new Vector2d(47, -61), Math.toRadians(270))

//                        .afterDisp(240, new ParallelAction(
//                                allFunc.specimanPickUpAngle(),
//                                allFunc.clawopen()
//                        ))

                      //  .splineTo(new Vector2d(12, -36), Math.toRadians(90))

//                        .afterDisp(265, new ParallelAction(
//                                allFunc.specimanAngle(),
//                                allFunc.specimanExtendSlides(),
//                                allFunc.retractSlides(),
//                                allFunc.clawopen()
//                        ))


                       // .splineTo(new Vector2d(41, -60), Math.toRadians(90))
                        .build()
        ));


    }
}