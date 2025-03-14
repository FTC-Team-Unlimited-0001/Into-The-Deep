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

@Autonomous(name = "Speciman Auto", group = "Autonomous")
public class specAuto extends DeepTeleop {
    private AllFunc allFunc;
    // Reference to AllFunc


    private final int slideUpPosition = 3140; // Adjust as needed
    private final int slideDownPosition = 0;  // Retracted position


    @Override
    public void runOpMode() throws InterruptedException {
        // Instantiate the SampleMecanumDrive (machine)
        robot = new machine(hardwareMap);
        allFunc = new AllFunc(this);


        Pose2d initialPose = new Pose2d(1, -62.625, Math.toRadians(270));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);
//        allFunc.clawclose().run(new TelemetryPacket());
//        allFunc.diffpick().run(new TelemetryPacket());
//        allFunc.specimanAngle().run(new TelemetryPacket());


        waitForStart();


        Actions.runBlocking(new ParallelAction(
                        drive.actionBuilder(initialPose)
                                .afterDisp(0,new ParallelAction(
                                        allFunc.clawclose(),
                                        allFunc.diffdeposit(),
                                        allFunc.specimanAngle()
                                ))

                                .strafeTo(new Vector2d(1, -32))

                                .afterDisp(30.625, new SequentialAction(


                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),

                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()
                                        )
)
                                //NUMBER 1 IS DONE

                                .waitSeconds(1.3)

                                .strafeToConstantHeading(new Vector2d(29, -44))
                                .splineToConstantHeading(new Vector2d(29, -17),Math.toRadians(-90))
                                .splineToConstantHeading(new Vector2d(43, -17), Math.toRadians(-90))
                                .strafeToConstantHeading(new Vector2d(43, -50))
                                .strafeToConstantHeading(new Vector2d(43, -17))
                                .afterDisp(33, new ParallelAction(
                                                allFunc.specimanPickUpAngle(),
                                                allFunc.specimanDiffPickup()

                                        )
                                )
                                .splineToConstantHeading(new Vector2d(56, -16), Math.toRadians(-90))

//                                .waitSeconds(0.2)
                                .strafeToConstantHeading(new Vector2d(56, -30))
                                .waitSeconds(0.1)
                                .strafeToConstantHeading(new Vector2d(56,-51.2))
                                .afterDisp(0,new SequentialAction(
                                                allFunc.clawclose()
                                        )
                                )
                                .waitSeconds(0.3)

                                .afterDisp(0, new ParallelAction(
                                                allFunc.diffdeposit(),
                                                allFunc.specimanAngle()
                                        )
                                )


                                .strafeToConstantHeading(new Vector2d(56,-46))
                                .strafeTo(new Vector2d(4,-30))



                                .afterDisp( 54.52  , new SequentialAction(

                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()
                                        )
                                )
                                //NUMBER 2 IS DONE

                                .waitSeconds(1)

                                .afterDisp(0,new ParallelAction(
                                        allFunc.clawopen(),
                                        allFunc.specimanPickUpAngle(),
                                        allFunc.specimanDiffPickup()
                                ))
                                .strafeTo(new Vector2d(38,-53))


                                .afterDisp(0, new SequentialAction(
                                                allFunc.clawclose()
                                        )
                                )

                                .waitSeconds(0.2)

                                .afterDisp(0, new ParallelAction(
                                                allFunc.diffdeposit(),
                                                allFunc.specimanAngle()
                                        )
                                )

                                .strafeTo(new Vector2d(-3,-30.5))


                                .afterDisp(43.07  , new SequentialAction(

                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()
                                        )
                                )
                                .waitSeconds(1)
                                //NUMBER 3 DONE

                                .afterDisp(0,new ParallelAction(
                                        allFunc.clawopen(),
                                        allFunc.specimanPickUpAngle(),
                                        allFunc.specimanDiffPickup()
                                ))
                                .strafeTo(new Vector2d(38,-53.3))


                                .afterDisp(0, new SequentialAction(
                                                allFunc.clawclose()
                                        )
                                )

                                .waitSeconds(0.2)

                                .afterDisp(0, new ParallelAction(
                                                allFunc.diffdeposit(),
                                                allFunc.specimanAngle()
                                        )
                                )

                                .strafeTo(new Vector2d(-1,-30.5))


                                .afterDisp(45.18   , new SequentialAction(

                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.clawopen(),
                                                new ParallelAction(
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.diffput()
                                                )
                                        )
                                )
                                .waitSeconds(1)










//                .afterDisp(84, new ParallelAction(
////                        allFunc.specimanAngle(),
////                        allFunc.clawopen()))
//
                                //   .strafeToConstantHeading(new Vector2d(34, -10) )
//               // .afterDisp(107, new ParallelAction(
////                        allFunc.specimanAngle(),
////                        allFunc.specimanExtendSlides(),
////                        allFunc.retractSlides(),
////                        allFunc.clawopen()
//                //))
//
//                        .splineToConstantHeading(new Vector2d(42, -10), Math.toRadians(-90))
//                        .lineToY(-56)
                                //.strafeTo(new Vector2d(44, -56))
////
////                .afterDisp(115, new ParallelAction(
////                        allFunc.specimanPickUpAngle(),
////                        allFunc.clawopen()
////                ))
                                //       .strafeTo(new Vector2d(44, -11))
//
//                        .strafeTo(new Vector2d(48, -13)  )
//                        .strafeTo(new Vector2d(51, -13)  )
//                        .strafeTo(new Vector2d(51, -53)  )
//
//                        .strafeTo(new Vector2d(54, -53) )
//                        .strafeTo(new Vector2d(60, -13) )
//                        .strafeTo(new Vector2d(60, -53) )
//                        .turnTo(Math.toRadians(270))
//                        .setReversed(true)
//                        .strafeTo(new Vector2d(7,-33))
//                        .setReversed(false)
//                        .strafeTo(new Vector2d (46,-56))
//                        .setReversed(true)
//                        .strafeTo(new Vector2d(7,-33))
//                        .setReversed(false)
//                        .strafeTo(new Vector2d (46,-56))
//                        .setReversed(true)
//                        .strafeTo(new Vector2d(7,-33))
//                        .setReversed(false)
//                        .strafeTo(new Vector2d (46,-56))

//                        .afterTime(1,//new ParallelAction(
//                               new SequentialAction(
//                                       allFunc.bucketExtendSlides(),
//                                       allFunc.retractSlides()
//                               )
//
//                        )
//                        .strafeToConstantHeading(new Vector2d(34, -40))
//
//
//                        .strafeToConstantHeading(new Vector2d(34, -10) )
//
//                .splineToConstantHeading(new Vector2d(40, -10), Math.toRadians(-90))
//               .lineToY(-56)
//ew Vector2d(54, -53) )
////                 .strafeTo(new Vector2d(60, -11) )
////                .strafeTo(new Vector2d(60, -53) )
////                  .turnTo(Math.toRadians(-90))
////                                .setReversed(true)
////                                .strafeTo(new Vector2d(7,-33))
////                .setReversed(false)
////                                .strafeTo(new Vector2d (46,-56))
////                .setReversed(true)
////                .strafeTo(new Vector2d(7,-33))
////                .setReversed(false)
////                .strafeTo(new Vector2d (46,-56))
////                .setReversed(true)
////                .strafeTo(new Vector2d(7,-33))
////                .setReversed(false)
////                .strafeTo(new Vector2d (46,-56))
//                .strafeTo(new Vector2d(48, -11)  )
//                .strafeTo(new Vector2d(51, -11)  )
//                .strafeTo(new Vector2d(51, -53)  )
//
//                 .strafeTo(n
//                        _________________________________________________


                                .build()

                )

        );


    }
}