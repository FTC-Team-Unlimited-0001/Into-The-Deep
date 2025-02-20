package org.firstinspires.ftc.teamcode.auton;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.PinpointDrive;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;
import org.firstinspires.ftc.teamcode.util.AllFunc;
import org.firstinspires.ftc.teamcode.util.machine;

@Autonomous(name = "RightBlueFull", group = "Autonomous")
public class bucketAuto extends DeepTeleop {
    private AllFunc allFunc;
    // Reference to AllFunc




    @Override
    public void runOpMode() throws InterruptedException {
        // Instantiate the SampleMecanumDrive (machine)
        robot = new machine(hardwareMap);
        allFunc = new AllFunc(this);


        Pose2d initialPose = new Pose2d(45, 70, Math.toRadians(-90));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);


        waitForStart();


        Actions.runBlocking(new ParallelAction(
                        drive.actionBuilder(initialPose)

                                .strafeTo(new Vector2d(45, 35))
                                .afterDisp(35, new SequentialAction(
                                        new ParallelAction(
                                                allFunc.angleDown(),
                                                allFunc.clawopen(),
                                                allFunc.diffpick()
                                        ),
                                        allFunc.clawclose()

                                )

                                )





                                .build()

                )

        );


    }
}