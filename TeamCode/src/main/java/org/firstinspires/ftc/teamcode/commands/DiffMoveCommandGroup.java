package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.util.machine;

public class DiffMoveCommandGroup extends SequentialCommandGroup {

    public DiffMoveCommandGroup(machine machine) {
        addCommands(

                new SequentialCommandGroup(
                new MoveDiffCommand(machine, 0,300),
                new ParallelCommandGroup(
                        new MoveClawCommand(machine,0,310)
                ),
                new MoveDiffCommand(machine,.63,220)
                )
        );
    }
}
