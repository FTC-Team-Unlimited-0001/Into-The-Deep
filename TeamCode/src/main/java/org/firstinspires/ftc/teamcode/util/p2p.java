package org.firstinspires.ftc.teamcode.util;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Pose2dDual;
import com.acmerobotics.roadrunner.Time;

import org.firstinspires.ftc.teamcode.MecanumDrive;

public class p2p implements Action {
    private final Pose2d targetPose;
    private final double translationalAccuracy;
    private final double headingAccuracy;

    public static MecanumDrive drive;

    public p2p(Pose2d pose, double translationalAccuracy, double headingAccuracy) {
        this.targetPose = pose;
        this.translationalAccuracy = translationalAccuracy;
        this.headingAccuracy = headingAccuracy;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket packet) {
        Pose2dDual<Time> target = Pose2dDual.constant(targetPose, 3);

        // Use the static drive reference
        p2p.drive.goToTarget(target, packet.fieldOverlay());

        Pose2d currentPose = p2p.drive.pose;

        double posError = targetPose.minusExp(currentPose).position.norm();
        double headingError = Math.abs(Math.toDegrees(targetPose.minusExp(currentPose).heading.toDouble()));

        return !(posError < translationalAccuracy && headingError < headingAccuracy);

    }
}
