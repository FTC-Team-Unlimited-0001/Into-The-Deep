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



                .strafeToConstantHeading(new Vector2d(15, -48))
                     .strafeTo(new Vector2d(25, -8))
                .splineToConstantHeading(new Vector2d(43, -17), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(43, -51), Math.toRadians(-90))
                .strafeTo(new Vector2d(52.5, -15) )


                .splineToConstantHeading(new Vector2d(52.5,-51.2),Math.toRadians(-90))



                .strafeTo(new Vector2d(63, -15) )
                .splineToConstantHeading(new Vector2d(63, -49),Math.toRadians(-90))

                .waitSeconds(.1)
                .strafeTo(new Vector2d(63,-50))



                .waitSeconds(.5)
                .strafeTo(new Vector2d(4, -31))
                .waitSeconds(.1)

//2 is done
                .strafeTo(new Vector2d(2.9, -31))
                .waitSeconds(.1)

                .strafeTo(new Vector2d(39, -53.2))





//
                //





                .strafeTo(new Vector2d(39, -53))
                .waitSeconds(0.3)


                .strafeTo(new Vector2d(-.2,-31))


                //3  is done
                .strafeTo(new Vector2d(-.2, -31))
                .waitSeconds(.5)



                .strafeTo(new Vector2d(39, -53.2))





                .strafeTo(new Vector2d(39, -53))


                .strafeTo(new Vector2d(4.6 ,-30))

                //4 is done
                .strafeTo(new Vector2d(4.6, -30))
                .waitSeconds(.2)


                .strafeTo(new Vector2d(39, -53))



                .strafeTo(new Vector2d(39, -53))


                .strafeTo(new Vector2d(5.8,-30))


                .splineToConstantHeading(new Vector2d(44,-50),Math.toRadians(-90))
                .build());









        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}