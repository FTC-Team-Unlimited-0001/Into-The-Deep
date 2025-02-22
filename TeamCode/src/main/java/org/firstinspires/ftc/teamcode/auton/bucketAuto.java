package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.PinpointDrive;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;
import org.firstinspires.ftc.teamcode.util.AllFunc;
import org.firstinspires.ftc.teamcode.util.machine;

@Autonomous(name = "Bucket Auto", group = "Autonomous")
public class bucketAuto extends DeepTeleop {
    private AllFunc allFunc;
    // Reference to AllFunc




    @Override
    public void runOpMode() throws InterruptedException {
        // Instantiate the SampleMecanumDrive (machine)
        robot = new machine(hardwareMap);
        allFunc = new AllFunc(this);


        Pose2d initialPose = new Pose2d(45, 70, Math.toRadians(180));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);


        waitForStart();


        Actions.runBlocking(new ParallelAction(
                        drive.actionBuilder(initialPose)

                                .afterDisp(0, new ParallelAction(
                                        allFunc.clawclose(),
                                        allFunc.specimanAngle()
                                ))
                                .strafeTo(new Vector2d(50, 70))
                                .waitSeconds(1)
                                .afterDisp(0, new SequentialAction(
                                        allFunc.bucketExtendSlides(),
                                        allFunc.stopSlides(),
                                        allFunc.diffdeposit(),
                                        allFunc.clawopen(),
                                        allFunc.diffput(),
                                        allFunc.retractSlides(),
                                        allFunc.stopSlides()
                                ))
                                .waitSeconds(2)
//                                .strafeToLinearHeading(new Vector2d(50, 38), Math.toRadians(-100))
//                                .afterDisp(32, new SequentialAction(
//                                        allFunc.angleDown(),
//                                        allFunc.clawclose(),
//                                        allFunc.specimanAngle()
//                                ))
//                                .waitSeconds(1)
//                                .strafeToLinearHeading(new Vector2d(54, 54), Math.toRadians(-135))
//                                .afterDisp(16.49, new SequentialAction(
//                                        allFunc.bucketExtendSlides(),
//                                        allFunc.stopSlides(),
//                                        allFunc.diffdeposit(),
//                                        allFunc.clawopen(),
//                                        allFunc.diffput(),
//                                        allFunc.retractSlides(),
//                                        allFunc.stopSlides()
//                                ))
//                                .waitSeconds(2)






//                                .afterDisp(22.83,new SequentialAction(
//
//                                        allFunc.bucketExtendSlides(),
//                                        allFunc.stopSlides(),
//                                        allFunc.diffdeposit(),
//                                        allFunc.clawopen(),
//                                        allFunc.diffdeposit(),
//                                        allFunc.retractSlides(),
//                                        allFunc.stopSlides()
//
//
//                                ))
//                                .waitSeconds(2)
//                                .strafeTo(new Vector2d(45, 35))
//                                .afterDisp(35, new SequentialAction(
//                                        new ParallelAction(
//                                                allFunc.angleDown(),
//                                                allFunc.clawopen(),
//                                                allFunc.diffdeposit()
//                                        ),
//                                        allFunc.clawclose()
//
//                                )
//
//                                )
//
//                                .strafeToLinearHeading(new Vector2d(55, 50), Math.toRadians(-135))
//
//                                .afterDisp(18.03,new SequentialAction(
//                                        allFunc.specimanAngle(),
//                                        allFunc.bucketExtendSlides(),
//                                        allFunc.stopSlides(),
//                                        allFunc.diffput(),
//                                        allFunc.clawopen(),
//                                        allFunc.diffdeposit(),
//                                        allFunc.retractSlides(),
//                                        allFunc.stopSlides()
//
//
//                                ))
//
//                                .strafeToLinearHeading(new Vector2d(48, 40), Math.toRadians(-90))
//
//                                .afterDisp(12.21,new SequentialAction(
//                                        allFunc.angleDown(),
//                                        allFunc.clawclose(),
//                                        allFunc.specimanAngle()
//                                ))
//
//                                .afterDisp(12.21,new SequentialAction(
//                                        allFunc.bucketExtendSlides(),
//                                        allFunc.stopSlides(),
//                                        allFunc.diffput(),
//                                        allFunc.clawopen(),
//                                        allFunc.diffdeposit(),
//                                        allFunc.retractSlides(),
//                                        allFunc.stopSlides()
//                                ))




                                .build()

                )

        );


    }
}