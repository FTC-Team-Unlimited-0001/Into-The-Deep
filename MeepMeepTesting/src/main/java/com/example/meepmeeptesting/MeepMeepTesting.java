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


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(1, -62.625, Math.toRadians(270)))

                .strafeTo(new Vector2d(1, -32))

//                                .afterDisp(31.625, new SequentialAction(
//                                                new ParallelAction(
//                                                        allFunc.diffpick(),
//                                                        allFunc.specimanAngle()
//                                                ),
//
//                                                allFunc.specimanExtendSlides(),
//                                                allFunc.stopSlides(),
//
//                                                allFunc.clawopen(),
//                                                allFunc.retractSlides()
//                                        )
//)
                //NUMBER 1 IS DONE

                .waitSeconds(2)

                .strafeToConstantHeading(new Vector2d(30, -40))
                .splineToConstantHeading(new Vector2d(30, -17),Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(45, -17), Math.toRadians(-90))
                .strafeToConstantHeading(new Vector2d(45, -50))
                .strafeToConstantHeading(new Vector2d(45, -17))
                .splineToConstantHeading(new Vector2d(56, -17), Math.toRadians(-90))
                .strafeToConstantHeading(new Vector2d(56, -49.4))
                .strafeTo(new Vector2d(4,-33) )

//                                .afterDisp(55.48, new SequentialAction(
//                                            new ParallelAction(
//                                                allFunc.specimanPickUpAngle(),
//                                                allFunc.specimanDiffPickup(),
//                                                allFunc.clawopen()
//                                            ),
//                                        allFunc.clawclose()
//                                        )
//                                )

                .waitSeconds(1)


//
//                                .afterDisp(0, new SequentialAction(
//                                        allFunc.diffpick(),
//                                        allFunc.specimanAngle()
//                                        )
//                                )



//                                .afterDisp(3  , new SequentialAction(
//
//                                                allFunc.speciman2ExtendSlides(),
//                                                allFunc.stopSlides(),
//                                                allFunc.clawopen(),
//                                                allFunc.retractSlides()
//                                        )
//                                )
                //NUMBER 2 IS DONE

                .waitSeconds(2)

                .strafeTo(new Vector2d(46,-52))
//
//                                .afterDisp(47.41, new SequentialAction(
//                                                new ParallelAction(
//                                                        allFunc.specimanPickUpAngle(),
//                                                        allFunc.specimanDiffPickup(),
//                                                        allFunc.clawopen()
//                                                ),
//                                                allFunc.clawclose()
//                                        )
//                                )

                .waitSeconds(1.5)

//                                .afterDisp(0, new SequentialAction(
//                                                allFunc.diffpick(),
//                                                allFunc.specimanAngle()
//                                        )
//                                )
//                                .waitSeconds(.5)

                .splineTo(new Vector2d(-1,-33),Math.toRadians(-90))



                //.splineToConstantHeading(new Vector2d(3, -32),Math.toRadians(-90))

////               // .afterDisp(84, new ParallelAction(
//////                        allFunc.specimanAngle(),
//////                        allFunc.clawopen()))
////
//                .strafeToConstantHeading(new Vector2d(34, -10) )
////               // .afterDisp(107, new ParallelAction(
//////                        allFunc.specimanAngle(),
//////                        allFunc.specimanExtendSlides(),
//////                        allFunc.retractSlides(),
//////                        allFunc.clawopen()
////                //))
////
//                .splineToConstantHeading(new Vector2d(40, -10), Math.toRadians(-90))
//               .lineToY(-56)
//               //.strafeTo(new Vector2d(44, -56))
//////
//////                .afterDisp(115, new ParallelAction(
//////                        allFunc.specimanPickUpAngle(),
//////                        allFunc.clawopen()
//////                ))
//         //       .strafeTo(new Vector2d(44, -11))
////
//                .strafeTo(new Vector2d(48, -13)  )
//                .strafeTo(new Vector2d(51, -13)  )
//                .strafeTo(new Vector2d(51, -53)  )
//
//                 .strafeTo(new Vector2d(54, -53) )
//                 .strafeTo(new Vector2d(60, -13) )
//                .strafeTo(new Vector2d(60, -53) )
//                  .turnTo(Math.toRadians(270))
//                                .setReversed(true)
//                                .strafeTo(new Vector2d(7,-33))
//                .setReversed(false)
//                                .strafeTo(new Vector2d (46,-56))
//                .setReversed(true)
//                .strafeTo(new Vector2d(7,-33))
//                .setReversed(false)
//                .strafeTo(new Vector2d (46,-56))
//                .setReversed(true)
//                .strafeTo(new Vector2d(7,-33))
//                .setReversed(false)
//                .strafeTo(new Vector2d (46,-56))
////                .splineToConstantHeading(new Vector2d(52, -56), Math.toRadians(-90))
////                .splineToConstantHeading(new Vector2d(62, -10), Math.toRadians(-90))
////                .splineToConstantHeading(new Vector2d(62, -56), Math.toRadians(-90))
//
//                .setReversed(true)
//                .splineTo(new Vector2d(47, -61), Math.toRadians(-270))
//                .waitSeconds(1)
//
////                .afterDisp(140, new ParallelAction(
////                        allFunc.specimanPickUpAngle(),
////                        allFunc.clawopen()
////                ))
//                .splineTo(new Vector2d(12, -36), Math.toRadians(90))
//                .waitSeconds(1)
//
////                .afterDisp(165, new ParallelAction(
////                        allFunc.specimanAngle(),
////                        allFunc.specimanExtendSlides(),
////                        allFunc.retractSlides(),
////                        allFunc.clawopen()
////                ))
//
//                .splineTo(new Vector2d(47, -61), Math.toRadians(270))
//                .waitSeconds(1)
//
////                .afterDisp(190, new ParallelAction(
////                        allFunc.specimanPickUpAngle(),
////                        allFunc.clawopen()
////                ))
//
//                .splineTo(new Vector2d(12, -36), Math.toRadians(90))
//                .waitSeconds(1)
//
////                .afterDisp(215, new ParallelAction(
////                        allFunc.specimanAngle(),
////                        allFunc.specimanExtendSlides(),
////                        allFunc.retractSlides(),
////                        allFunc.clawopen()
////                ))
//
//                .splineTo(new Vector2d(47, -61), Math.toRadians(270))
//
////                .afterDisp(240, new ParallelAction(
////                        allFunc.specimanPickUpAngle(),
////                        allFunc.clawopen()
////                ))
//
//                .splineTo(new Vector2d(12, -36), Math.toRadians(90))
//
////                .afterDisp(265, new ParallelAction(
////                        allFunc.specimanAngle(),
////                        allFunc.specimanExtendSlides(),
////                        allFunc.retractSlides(),
////                        allFunc.clawopen()
////                ))
//
//
//                .splineTo(new Vector2d(41, -60), Math.toRadians(90))


//

                      //  .splineTo(new Vector2d(41, -60), Math.toRadians(90))
                        .build());









        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}