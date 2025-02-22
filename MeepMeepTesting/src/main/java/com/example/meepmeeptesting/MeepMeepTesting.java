package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(45, 70, Math.toRadians(180)))
                .strafeTo(new Vector2d(50, 70))
                .strafeToLinearHeading(new Vector2d(50, 38), Math.toRadians(-100))
                .strafeToLinearHeading(new Vector2d(54, 54), Math.toRadians(-135))
                .strafeToLinearHeading(new Vector2d(57, 38), Math.toRadians(-85))
                .strafeToLinearHeading(new Vector2d(54, 54), Math.toRadians(-135))




////                                .afterDisp(31.625, new SequentialAction(
////                                                new ParallelAction(
////                                                        allFunc.diffpick(),
////                                                        allFunc.specimanAngle()
////                                                ),
////
////                                                allFunc.specimanExtendSlides(),
////                                                allFunc.stopSlides(),
////
////                                                allFunc.clawopen(),
////                                                allFunc.retractSlides()
////                                        )
////)
//                //NUMBER 1 IS DONE
//
//                .waitSeconds(2)
//
//                .strafeToConstantHeading(new Vector2d(28, -40))
//                .splineToConstantHeading(new Vector2d(28, -17),Math.toRadians(-90))
//                .splineToConstantHeading(new Vector2d(45, -17), Math.toRadians(-90))
//                .strafeToConstantHeading(new Vector2d(45, -50))
//                .strafeToConstantHeading(new Vector2d(45, -17))
//                .splineToConstantHeading(new Vector2d(56, -17), Math.toRadians(-90))
//                .strafeToConstantHeading(new Vector2d(56, -49.4))
//                .strafeTo(new Vector2d(4,-33) )
//
////                                .afterDisp(55.48, new SequentialAction(
////                                            new ParallelAction(
////                                                allFunc.specimanPickUpAngle(),
////                                                allFunc.specimanDiffPickup(),
////                                                allFunc.clawopen()
////                                            ),
////                                        allFunc.clawclose()
////                                        )
////                                )
//
//                .waitSeconds(1)
//
//
////
////                                .afterDisp(0, new SequentialAction(
////                                        allFunc.diffpick(),
////                                        allFunc.specimanAngle()
////                                        )
////                                )
//
//
//
////                                .afterDisp(3  , new SequentialAction(
////
////                                                allFunc.speciman2ExtendSlides(),
////                                                allFunc.stopSlides(),
////                                                allFunc.clawopen(),
////                                                allFunc.retractSlides()
////                                        )
////                                )
//                //NUMBER 2 IS DONE
//
//                .waitSeconds(2)
//
//                .strafeTo(new Vector2d(46,-52))
////
////                                .afterDisp(47.41, new SequentialAction(
////                                                new ParallelAction(
////                                                        allFunc.specimanPickUpAngle(),
////                                                        allFunc.specimanDiffPickup(),
////                                                        allFunc.clawopen()
////                                                ),
////                                                allFunc.clawclose()
////                                        )
////                                )
//
//                .waitSeconds(1.5)
//
////                                .afterDisp(0, new SequentialAction(
////                                                allFunc.diffpick(),
////                                                allFunc.specimanAngle()
////                                        )
////                                )
////                                .waitSeconds(.5)
//
//                .strafeTo(new Vector2d(4,-33) )



                        .build());









        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}