package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.PinpointDrive;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;
import org.firstinspires.ftc.teamcode.util.AllFunc;
import org.firstinspires.ftc.teamcode.util.machine;

@Autonomous(name = "Speciman Auto 5 testting", group = "Autonomous")
public class specAutotesting extends DeepTeleop {
    private AllFunc allFunc;
    // Reference to AllFunc


    private final int slideUpPosition = 3140; // Adjust as needed
    private final int slideDownPosition = 0;  // Retracted position


    @Override
    public void runOpMode() throws InterruptedException {
        // Instantiate the SampleMecanumDrive (machine)
        robot = new machine(hardwareMap);
        allFunc = new AllFunc(this);


        Pose2d initialPose = new Pose2d(.5, -62.625, Math.toRadians(270));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);
//        allFunc.clawclose().run(new TelemetryPacket());
//        allFunc.diffpick().run(new TelemetryPacket());
//        allFunc.specimanAngle().run(new TelemetryPacket());


        waitForStart();


        Actions.runBlocking(new ParallelAction(
                        drive.actionBuilder(initialPose)

                                .afterDisp(0,new SequentialAction(
                                       new ParallelAction( allFunc.clawclose(),
                                        allFunc.diffdeposit(),
                                        allFunc.specimanAngle()),

                                        allFunc.halfExtendSlides(),
                                        allFunc.stopSlides()

                                ))

                                .strafeTo(new Vector2d(.5, -32))

                                .afterDisp(30.625, new SequentialAction(


                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),

                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()
                                        )
)
                                //NUMBER 1 IS DONE

                                .waitSeconds(.1)

                                .strafeToConstantHeading(new Vector2d(20, -45))

                                .strafeToConstantHeading(new Vector2d(30, -40))
                                .splineToConstantHeading(new Vector2d(34, -14), Math.toRadians(-90))
                                .strafeTo(new Vector2d(46, -14) )
                                 .strafeTo(new Vector2d(46, -51) )
                                .splineToConstantHeading(new Vector2d(57, -15),Math.toRadians(-90))
                                  .splineToConstantHeading(new Vector2d(57,-54),Math.toRadians(-90))



                                .afterDisp(35.2, new ParallelAction(
                                                allFunc.specimanPickUpAngle(),
                                                allFunc.specimanDiffPickup()

                                        )
                                )
                                .strafeTo(new Vector2d(63, -12) )
                                 .strafeTo(new Vector2d(63,-45))
                                .waitSeconds(.1)
                                .strafeTo(new Vector2d(63,-53.762))
                                .waitSeconds(.2)

                                .afterDisp(0,new ParallelAction(
                                                allFunc.clawclose()
                                        )
                                )



                                .afterDisp(.7, new ParallelAction(
                                                allFunc.diffdeposit(),
                                                allFunc.specimanAngle(),
                                        new SequentialAction(
                                        allFunc.halfExtendSlides(),
                                        allFunc.stopSlides()
                                        ))

                                )

                                .strafeTo(new Vector2d(3.9, -31))
                                .waitSeconds(.1)

                                .afterDisp( 0  , new SequentialAction(

                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()
                                        )
                                )
//2 is done
                                .strafeTo(new Vector2d(3.9, -31))
                                .waitSeconds(.1)
                                .afterDisp(1,new ParallelAction(
                                        allFunc.clawopen(),
                                        allFunc.specimanPickUpAngle(),
                                        allFunc.specimanDiffPickup()
                                ))

                               .strafeTo(new Vector2d(39, -53.2))





//
             //




                               .afterDisp(0, new SequentialAction(
                                                allFunc.clawclose()
                                        )
                                )

                            .strafeTo(new Vector2d(39, -53))
                                .waitSeconds(0.3)
                                .afterDisp(0, new ParallelAction(
                                        allFunc.diffdeposit(),
                                                allFunc.specimanAngle(),
                                 new SequentialAction(
                                 allFunc.halfExtendSlides(),
                                allFunc.stopSlides()
        )

                                        )
                                )

                                .strafeTo(new Vector2d(.6,-31))


                                .afterDisp( 0 , new SequentialAction(

                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()
                                        )
                                )
             //3  is done
                                .strafeTo(new Vector2d(.6, -31))
                                .waitSeconds(.1)

                                .afterDisp(1,new ParallelAction(
                                        allFunc.clawopen(),
                                        allFunc.specimanPickUpAngle(),
                                        allFunc.specimanDiffPickup()
                                ))

                                .strafeTo(new Vector2d(39, -53.2))



                                .afterDisp(0, new SequentialAction(
                                                allFunc.clawclose()
                                        )
                                )

                                 .strafeTo(new Vector2d(39, -53))
                                .afterDisp(.5, new ParallelAction(
                                                allFunc.diffdeposit(),
                                                allFunc.specimanAngle(),
                                                new SequentialAction(
                                                        allFunc.halfExtendSlides(),
                                                        allFunc.stopSlides()
                                                ))
                                )

                             .strafeTo(new Vector2d(5.3 ,-30))
                                .afterDisp( 0 , new SequentialAction(

                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides()
                                        )
                                )
                                //4 is done
                                .strafeTo(new Vector2d(5.3, -30))
                                .waitSeconds(.2)
                                .afterDisp(0,new ParallelAction(
                                        allFunc.clawopen(),
                                        allFunc.specimanPickUpAngle(),
                                        allFunc.specimanDiffPickup()
                                ))

                                .strafeTo(new Vector2d(39, -53))


                                .afterDisp(0, new SequentialAction(
                                                allFunc.clawclose()
                                        )
                                )
                                .strafeTo(new Vector2d(39, -53))
                                .afterDisp(.5, new ParallelAction(
                                                allFunc.diffdeposit(),
                                                allFunc.specimanAngle(),
                                                new SequentialAction(
                                                        allFunc.halfExtendSlides(),
                                                        allFunc.stopSlides()
                                                )
                                        )
                                )

                                .strafeTo(new Vector2d(6.3,-30))
                                .afterDisp( 0 , new SequentialAction(

                                                allFunc.specimanExtendSlides(),
                                                allFunc.stopSlides(),
                                                allFunc.clawopen(),
                                                allFunc.retractSlides(),
                                                allFunc.stopSlides(),
                                        allFunc.diffput()
                                        )
                                )
                                .strafeTo(new Vector2d(6.3,-30))
                                .waitSeconds(.1)
                                .strafeTo(new Vector2d(40,-53) )
                                //5 is done

 //                                .waitSeconds(1)
//                                //NUMBER 3 DONE
//
//                                .afterDisp(0,new ParallelAction(
//                                        allFunc.clawopen(),
//                                        allFunc.specimanPickUpAngle(),
//                                        allFunc.specimanDiffPickup()
//                                ))
//                                .strafeTo(new Vector2d(38,-53.3))
//
//
//                                .afterDisp(0, new SequentialAction(
//                                                allFunc.clawclose()
//                                        )
//                                )
//
//                                .waitSeconds(0.2)
//
//                                .afterDisp(0, new ParallelAction(
//                                                allFunc.diffdeposit(),
//                                                allFunc.specimanAngle()
//                                        )
//                                )
//
//                                .strafeTo(new Vector2d(-1,-30.5))
//
//
//                                .afterDisp(45.18   , new SequentialAction(
//
//                                                allFunc.specimanExtendSlides(),
//                                                allFunc.stopSlides(),
//                                                allFunc.clawopen(),
//                                                new ParallelAction(
//                                                allFunc.retractSlides(),
//                                                allFunc.stopSlides(),
//                                                allFunc.diffput()
//                                                )
//                                        )
//                                )
//                                .waitSeconds(1)






//                                .strafeTo(new Vector2d(1, -33))
//
//
//
//                                .waitSeconds(1.3)
//
//                                .strafeToConstantHeading(new Vector2d(29, -44))
//
//                                .splineToConstantHeading(new Vector2d(39, -15), Math.toRadians(-90))
//                                .splineToConstantHeading(new Vector2d(45, -15), Math.toRadians(-90))
//
//                                .splineToConstantHeading(new Vector2d(45, -50), Math.toRadians(-90))
//                                .splineToConstantHeading(new Vector2d(43, -17), Math.toRadians(-90))
//
//                                .splineToConstantHeading(new Vector2d(55, -16), Math.toRadians(-90))
//
////                                .waitSeconds(0.2)
//
//                                .strafeToConstantHeading(new Vector2d(55,-51.2))
//
//                             //   .waitSeconds(0.3)
//
//
////                .strafeToConstantHeading(new Vector2d(54,-46))  //second is pushed into human zone
//                                .splineToConstantHeading(new Vector2d(57, -15),Math.toRadians(-90) )
//                                .splineToConstantHeading(new Vector2d(63, -15),Math.toRadians(-90) )
//
//                                .strafeTo(new Vector2d(63, -51.2))  //3rd is pushed
//                              //  .splineToConstantHeading(new Vector2d(1, -40),Math.toRadians(-90) )
//
//                                .strafeTo(new Vector2d(1, -31.5))
//
//
//
//                                .strafeTo(new Vector2d(45, -50))
//                                .splineToConstantHeading(new Vector2d(4,-30),Math.toRadians(-90))
//
//
//
//                                //NUMBER 2 IS DONE
//
//                                .waitSeconds(1)
//
//
//                                .strafeTo(new Vector2d(38,-53))
//
//
//
//
//                                .waitSeconds(0.2)
//
//
//
//                                .strafeTo(new Vector2d(-3,-30.5))
//
//
//
//                                .waitSeconds(1)
//                                //NUMBER 3 DONE
//
//                                .strafeTo(new Vector2d(38,-53.3))
//
//
//
//
//                                .waitSeconds(0.2)
//
//
//
//                                .splineToConstantHeading(new Vector2d(-1,-32),Math.toRadians(-90))
//                                .strafeTo(new Vector2d(-1,-31.5))
//
//
//



                                .build()

                )

        );


    }
}