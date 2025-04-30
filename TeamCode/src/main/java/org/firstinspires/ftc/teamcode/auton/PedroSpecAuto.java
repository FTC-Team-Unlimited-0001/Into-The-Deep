package org.firstinspires.ftc.teamcode.auton;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathBuilder;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import  com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;
import org.firstinspires.ftc.teamcode.util.AllFunc;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;
  class PedroSpecAuto extends DeepTeleop {

    @Override
      public void runOpMode() throws InterruptedException {


         PathBuilder builder = new PathBuilder();

         PathChain line1 = builder
                .addPath(
                        new BezierLine(
                                new Point(1.000, 80.000, Point.CARTESIAN),
                                new Point(39.000, 80.000, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(360))
                .build();

          PathChain line2 = builder
                .addPath(
                        new BezierCurve(
                                new Point(39.000, 80.000, Point.CARTESIAN),
                                new Point(22.777, 32.429, Point.CARTESIAN),
                                new Point(64.279, 24.901, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(360))
                .build();

          PathChain line3 = builder
                .addPath(
                        new BezierLine(
                                new Point(64.279, 24.901, Point.CARTESIAN),
                                new Point(13.898, 24.515, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(360))
                .build();

          PathChain line4 = builder
                .addPath(
                        new BezierCurve(
                                new Point(13.898, 24.515, Point.CARTESIAN),
                                new Point(26.638, 23.743, Point.CARTESIAN),
                                new Point(56.365, 13.705, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(360))
                .build();

          PathChain line5 = builder
                .addPath(
                        new BezierCurve(
                                new Point(56.365, 13.705, Point.CARTESIAN),
                                new Point(62.735, 14.477, Point.CARTESIAN),
                                new Point(10.424, 14.670, Point.CARTESIAN)
                        )
                )
                .setConstantHeadingInterpolation(Math.toRadians(360))
                .build();

          PathChain line6 = builder
                .addPath(
                        new BezierLine(
                                new Point(10.424, 14.670, Point.CARTESIAN),
                                new Point(55.786, 2.123, Point.CARTESIAN)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();

          PathChain line7 = builder
                .addPath(
                        new BezierLine(
                                new Point(55.786, 2.123, Point.CARTESIAN),
                                new Point(11.196, 2.895, Point.CARTESIAN)
                        )
                )
                .setTangentHeadingInterpolation()
                .build();
    }

}