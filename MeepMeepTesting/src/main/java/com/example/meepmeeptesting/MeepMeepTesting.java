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



                .strafeToConstantHeading(new Vector2d(34, -40))


                .strafeToConstantHeading(new Vector2d(34, -10) )


                .splineToConstantHeading(new Vector2d(40, -10), Math.toRadians(-90))

                .lineToY(-56)
                .strafeTo(new Vector2d(44, -11))

                .splineToConstantHeading(new Vector2d(50, -55) ,Math.toRadians(90))


                .splineTo(new Vector2d(60, -11),Math.toRadians(90))
                .strafeTo(new Vector2d(60, -55) )
                                .turnTo(Math.toRadians(-90))
                                .setReversed(true)
                                .strafeTo(new Vector2d(7,-33))
                .setReversed(false)
                                .strafeTo(new Vector2d (46,-56))
                .setReversed(true)
                .strafeTo(new Vector2d(7,-33))
                .setReversed(false)
                .strafeTo(new Vector2d (46,-56))
                .setReversed(true)
                .strafeTo(new Vector2d(7,-33))
                .setReversed(false)
                .strafeTo(new Vector2d (46,-56))



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