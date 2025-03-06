package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
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


    //SPEC STARTPOINT //   myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(1, -62.625, Math.toRadians(270)))
                myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(40, 62, Math.toRadians(-180)))


                        .strafeToLinearHeading(new Vector2d(54, 54), Math.toRadians(-135))

                                .strafeToLinearHeading(new Vector2d(48, 45), Math.toRadians(-90))
//                                .afterDisp(32, new SequentialAction(
//                                        allFunc.angleDown(),
//                                        allFunc.clawclose(),
//                                        allFunc.specimanAngle()
//                                ))
                              .waitSeconds(1)
                        .strafeToLinearHeading(new Vector2d(54, 54), Math.toRadians(-135))

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
                                 .waitSeconds(2)
                        .strafeToLinearHeading(new Vector2d(55, 45), Math.toRadians(-90))
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
                        .strafeToLinearHeading(new Vector2d(54, 54), Math.toRadians(-135))
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
                        .strafeToLinearHeading(new Vector2d(55, 42), Math.toRadians(-40))
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




//                START OF SPEC AUTO
//
//                .strafeTo(new Vector2d(1, -32))
//
//
//                //NUMBER 1 IS DONE
//
//                .waitSeconds(.1)
//
//
//                .strafeToConstantHeading(new Vector2d(22, -40))
//                .splineToConstantHeading(new Vector2d(38, -14), Math.toRadians(-90))
//                                .strafeTo(new Vector2d(43, -16) )
//
//                .strafeTo(new Vector2d(43, -51) )
//                .splineToConstantHeading(new Vector2d(52.5, -15),Math.toRadians(-90) )
//
//
//                .splineToConstantHeading(new Vector2d(52.5,-51.2),Math.toRadians(-90))
//
//
//                .strafeTo(new Vector2d(63, -15)  )
//                .strafeTo(new Vector2d(63, -49.8) )
//
//                .waitSeconds(.1)
//
//
//
//                .waitSeconds(.5)
//                .strafeTo(new Vector2d(3.4, -31))
//                .waitSeconds(.1)
//
//
////2 is done
//                .strafeTo(new Vector2d(3.4, -31))
//                .waitSeconds(.1)
//
//                .strafeTo(new Vector2d(39, -53.2))
//
//
//
//
//
////
//                //
//
//
//
//
//
//                .strafeTo(new Vector2d(39, -53))
//                .waitSeconds(0.3)
//
//
//                .strafeTo(new Vector2d(.6,-31))
//
//
//
//                //3  is done
//                .strafeTo(new Vector2d(.6, -31))
//                .waitSeconds(.1)
//
//
//
//                .strafeTo(new Vector2d(39, -53.2))
//
//
//
//                .strafeTo(new Vector2d(39, -53))
//
//                .strafeTo(new Vector2d(4.8 ,-30))
//
//                //4 is done
//                .strafeTo(new Vector2d(4.8, -30))
//                .waitSeconds(.2)
//
//                .strafeTo(new Vector2d(39, -53))
//
//
//                .strafeTo(new Vector2d(39, -53))
//
//
//                .strafeTo(new Vector2d(6.3,-30))
//
//
//                .strafeTo(new Vector2d(44,-50) )
                .build());









        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}