package com.example.meepmeeptesting;

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


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(11, -67, Math.toRadians(90)))

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
//                .strafeTo(new Vector2d(44, -56))

//                        .afterDisp(115, new ParallelAction(
//                                allFunc.specimanPickUpAngle(),
//                                allFunc.clawopen()
//                        ))

                .strafeTo(new Vector2d(51, -10) )
                .strafeTo(new Vector2d(54, -55) )
                .strafeTo(new Vector2d(60, -11) )
                     //   .splineToConstantHeading(new Vector2d(44, -10), Math.toRadians(-90))
                       // .splineToConstantHeading(new Vector2d(44, -56), Math.toRadians(-90))
//                        .afterDisp(115, new ParallelAction(
//                                allFunc.specimanPickUpAngle(),
//                                allFunc.clawopen()
//                        ))

//                        .splineToConstantHeading(new Vector2d(53, -10), Math.toRadians(-90))
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
//
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

                     //   .splineTo(new Vector2d(12, -36), Math.toRadians(90))

//                        .afterDisp(265, new ParallelAction(
//                                allFunc.specimanAngle(),
//                                allFunc.specimanExtendSlides(),
//                                allFunc.retractSlides(),
//                                allFunc.clawopen()
//                        ))


                      //  .splineTo(new Vector2d(41, -60), Math.toRadians(90))
                        .build());









        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}