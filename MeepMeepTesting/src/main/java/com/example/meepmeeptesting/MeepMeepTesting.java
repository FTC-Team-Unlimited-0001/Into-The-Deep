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


 //   SPEC STARTPOINT
        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(1, -62.625, Math.toRadians(270)))
         //       myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(40, 62, Math.toRadians(-180)))
                .strafeToConstantHeading(new Vector2d(30, -40))
                .splineToConstantHeading(new Vector2d(34, -14), Math.toRadians(-90))
                .strafeTo(new Vector2d(48, -14) )
                .strafeTo(new Vector2d(48, -51) )
                .splineToConstantHeading(new Vector2d(52, -15),Math.toRadians(-90))
                .splineToConstantHeading(new Vector2d(52,-54),Math.toRadians(-90))



                .strafeTo(new Vector2d(63, -12) )
                .strafeTo(new Vector2d(63,-45))
                .waitSeconds(.1)
                .strafeTo(new Vector2d(63,-53.762))
                .waitSeconds(.2)


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