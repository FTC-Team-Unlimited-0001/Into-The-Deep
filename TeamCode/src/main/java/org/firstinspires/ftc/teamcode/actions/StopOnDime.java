package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class StopOnDime implements Action {
    private DeepTeleop teleop;
    private long startTime;

    public StopOnDime(DeepTeleop teleop) {
        this.teleop = teleop;
        this.startTime = System.currentTimeMillis(); // Record start time
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        long elapsedTime = System.currentTimeMillis() - startTime;

//        if (elapsedTime < 50) { // Run for 1 second
//            teleop.robot.frontLeft.setPower(-0.2);
//            teleop.robot.frontRight.setPower(-0.2);
//            teleop.robot.backLeft.setPower(-0.2);
//            teleop.robot.backRight.setPower(-0.2);
//        } else {
            // Stop all motors after 1 second
            teleop.robot.frontLeft.setPower(0);
            teleop.robot.frontRight.setPower(0);
            teleop.robot.backLeft.setPower(0);
            teleop.robot.backRight.setPower(0);
            return true; // Action complete


//        return false; // Action still running
    }
}