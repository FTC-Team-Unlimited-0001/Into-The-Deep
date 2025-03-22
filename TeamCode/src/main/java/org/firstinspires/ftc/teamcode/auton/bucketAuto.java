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


                                 .afterTime(0,new ParallelAction(
                                        allFunc.specimanAngle()
                                ))
                                .strafeToLinearHeading(new Vector2d(64.9, 65), Math.toRadians(-135))


                                .afterDisp(1,new SequentialAction(
                                         allFunc.diffdeposit(),


                                        allFunc.bucketExtendSlides(),
                                        allFunc.clawopen(),
                                        allFunc.stopSlides(),



                                                allFunc.diffput(),

                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()

                                        ))



                                .strafeToLinearHeading(new Vector2d(65,65.1), Math.toRadians(-135))
                                .waitSeconds(1)
// 1 is done
                                .strafeToLinearHeading(new Vector2d(60,55), Math.toRadians(-90))
                                .afterDisp(0,new ParallelAction(
                                        allFunc.angleDown(),
                                        allFunc.diffput()


                                ))
                                .strafeToLinearHeading(new Vector2d(61,55), Math.toRadians(-90))
                                .waitSeconds(1)
                                .afterDisp(0,new SequentialAction(
                                        allFunc.clawclose()
                                ))

                                .strafeToLinearHeading(new Vector2d(61.1,55), Math.toRadians(-90))
                                .waitSeconds(1)

                                .afterTime(1,new ParallelAction(
                                        allFunc.specimanAngle()
                                ))

                                .strafeToLinearHeading(new Vector2d(65, 65), Math.toRadians(-135))
                                .waitSeconds(1)
                                .afterDisp(0,new SequentialAction(
                                        allFunc.diffdeposit(),
                                        allFunc.bucketExtendSlides(),
                                        allFunc.stopSlides(),
                                        allFunc.clawopen(),

                                        allFunc.diffdeposit(),



                                        allFunc.diffput(),
                                        allFunc.retractSlides(),
                                        allFunc.stopSlides()

                                ))

                                .strafeToLinearHeading(new Vector2d(65,65.1), Math.toRadians(-135))

                                 .waitSeconds(1)
//2 is done
                                .strafeToLinearHeading(new Vector2d(67.99,55), Math.toRadians(-90))
                                .afterDisp(0,new ParallelAction(
                                        allFunc.angleDown(),
                                        allFunc.diffput()


                                ))
                                .strafeToLinearHeading(new Vector2d(70.2,55), Math.toRadians(-90))
                                .waitSeconds(1)
                                .afterDisp(0,new SequentialAction(
                                        allFunc.clawclose()
                                ))

                                .strafeToLinearHeading(new Vector2d(70.3,55), Math.toRadians(-90))
                                .waitSeconds(1)

                                .afterTime(1,new ParallelAction(
                                        allFunc.specimanAngle()
                                ))
                                .waitSeconds(1)
                                .strafeToLinearHeading(new Vector2d(64.9, 65), Math.toRadians(-135))


                                .afterDisp(1,new SequentialAction(
                                        allFunc.diffdeposit(),


                                        allFunc.bucketExtendSlides(),
                                        allFunc.clawopen(),
                                        allFunc.stopSlides(),



                                        allFunc.diffput(),

                                        allFunc.retractSlides(),
                                        allFunc.stopSlides()

                                ))



                                .strafeToLinearHeading(new Vector2d(65,65.1), Math.toRadians(-135))
                                .waitSeconds(1)
// 3 is done

                                .afterDisp(0,new ParallelAction(
                                        allFunc.angleDown(),
                                        allFunc.diffput()


                                ))
                                .strafeToLinearHeading(new Vector2d(70,55), Math.toRadians(180))
                                .waitSeconds(1)
                                .afterDisp(0,new SequentialAction(
                                        allFunc.clawclose()
                                ))

                                .strafeToLinearHeading(new Vector2d(70.3,55), Math.toRadians(180))
                                .waitSeconds(1)

                                .afterTime(1,new ParallelAction(
                                        allFunc.specimanAngle()
                                ))
                                .waitSeconds(1)
                                .strafeToLinearHeading(new Vector2d(64.9, 65), Math.toRadians(-135))

                                .build()

                )

        );


    }
}