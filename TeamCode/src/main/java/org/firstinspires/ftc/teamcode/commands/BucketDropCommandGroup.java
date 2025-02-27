package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.util.machine;

public class BucketDropCommandGroup extends SequentialCommandGroup {

    public BucketDropCommandGroup(machine machine) {
        addCommands(
                new AngleCommand(machine, .19,500),
                new ExtendSlidesCommand(machine, -500),
                new ParallelCommandGroup(
                new MoveDiffCommand(machine, 0,500),
                new MoveClawCommand(machine,.45,200)
                ),
                new MoveDiffCommand(machine,.63,500)
        );
    }
}
