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


        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(1, -62.625, Math.toRadians(270)))


                .strafeTo(new Vector2d(1, -32))

                //NUMBER 1 IS DONE

                .waitSeconds(.1)

                .strafeToConstantHeading(new Vector2d(29, -44))

                .splineToConstantHeading(new Vector2d(32, -15), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(43.5, -15), Math.toRadians(-90))

                .splineToConstantHeading(new Vector2d(45, -51), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(43, -15), Math.toRadians(-90))

                .splineToConstantHeading(new Vector2d(52.5, -16), Math.toRadians(-90))

//                                .waitSeconds(0.2)

                .strafeToConstantHeading(new Vector2d(52.5,-51.2))


                .splineToConstantHeading(new Vector2d(55, -15),Math.toRadians(-90) )
                .splineToConstantHeading(new Vector2d(63, -15),Math.toRadians(-90) )

                .strafeTo(new Vector2d(59, -51.5))


                .waitSeconds(.1)
                .strafeTo(new Vector2d(59, -51.2))


                .waitSeconds(.1)
                .strafeTo(new Vector2d(2.9, -31.5))


//2 is done
                .strafeTo(new Vector2d(2.9, -31.5))
                .waitSeconds(.1)


                .strafeTo(new Vector2d(39, -53.2))








                .strafeTo(new Vector2d(39, -53))
                .waitSeconds(0.1)


                .strafeTo(new Vector2d(-3,-30.5))



                //3  is done
                .strafeTo(new Vector2d(-3, -31.5))
                .waitSeconds(.1)


                .strafeTo(new Vector2d(39, -53.2))



                .strafeTo(new Vector2d(39, -53))


                .strafeTo(new Vector2d(4.1 ,-30.5))

                //4 is done
                .strafeTo(new Vector2d(4.1, -30.5))
                .waitSeconds(.1)

                .strafeTo(new Vector2d(39, -53))


                .strafeTo(new Vector2d(39, -53))


                .strafeTo(new Vector2d(5.6,-30))


                .build());









        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}