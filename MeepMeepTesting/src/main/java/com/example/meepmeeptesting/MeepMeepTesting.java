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


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(11, -69, Math.toRadians(90)))
                .splineToConstantHeading(new Vector2d(11, -39), Math.toRadians(-90))
                        .waitSeconds(1)
                .splineToConstantHeading(new Vector2d(36, -33), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(36, -10), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(44, -10), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(44, -56), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(53, -10), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(52, -56), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(62, -10), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(62, -56), Math.toRadians(-90))

                .setReversed(true)
                .splineTo(new Vector2d(47, -59), Math.toRadians(-270))
                .waitSeconds(1)

                .splineTo(new Vector2d(12, -36), Math.toRadians(90))
                .waitSeconds(1)

                .splineTo(new Vector2d(47, -59), Math.toRadians(270))
                        .waitSeconds(1)
                .splineTo(new Vector2d(12, -36), Math.toRadians(90))
                .waitSeconds(1)
                .splineTo(new Vector2d(47, -59), Math.toRadians(270))
                .waitSeconds(1)
                .splineTo(new Vector2d(12, -36), Math.toRadians(90))
                .splineTo(new Vector2d(41, -60), Math.toRadians(90))







                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}