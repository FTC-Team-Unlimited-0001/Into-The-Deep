package org.firstinspires.ftc.teamcode.actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.canvas.Canvas;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Actions;
import com.acmerobotics.roadrunner.ParallelAction;

public class ParallelRaceAction implements Action {
    private Action[] actions;

    public ParallelRaceAction(Action... actions){
        this.actions = actions;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {
        for (Action action: actions) {
            if (!action.run(telemetryPacket)) {
                return false;
            }
        }
        return true;
    }
}
