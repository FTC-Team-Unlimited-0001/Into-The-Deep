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

                .strafeTo(new Vector2d(1, -33))



                .waitSeconds(1.3)

                .strafeToConstantHeading(new Vector2d(29, -44))

                .splineToConstantHeading(new Vector2d(39, -15), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(45, -15), Math.toRadians(-90))

                .splineToConstantHeading(new Vector2d(45, -50), Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(43, -17), Math.toRadians(-90))

                .splineToConstantHeading(new Vector2d(55, -16), Math.toRadians(-90))

//                                .waitSeconds(0.2)

                .strafeToConstantHeading(new Vector2d(55,-51.2))

                //   .waitSeconds(0.3)


//                .strafeToConstantHeading(new Vector2d(54,-46))  //second is pushed into human zone
                .splineToConstantHeading(new Vector2d(57, -15),Math.toRadians(-90) )

                .splineToConstantHeading(new Vector2d(63, -15),Math.toRadians(-90) )

                .strafeTo(new Vector2d(63, -51.2))  //3rd is pushed

                .strafeTo(new Vector2d(1, -31.5))


                .strafeTo(new Vector2d(45, -50))
                .strafeTo(new Vector2d(4,-30) )



                //NUMBER 2 IS DONE

                .waitSeconds(1)


                .strafeTo(new Vector2d(38,-53))




                .waitSeconds(0.2)



                .strafeTo(new Vector2d(-3,-30.5))



                .waitSeconds(1)
                //NUMBER 3 DONE

                .strafeTo(new Vector2d(38,-53.3))




                .waitSeconds(0.2)



                .splineToConstantHeading(new Vector2d(-1,-32),Math.toRadians(-90))
                .strafeTo(new Vector2d(-1,-31.5))





                .build());









        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}