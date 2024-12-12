package org.firstinspires.ftc.teamcode.util;

import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.actions.AngleSlides;
import org.firstinspires.ftc.teamcode.actions.CloseClawAction;
import org.firstinspires.ftc.teamcode.actions.MoveDiff;
import org.firstinspires.ftc.teamcode.actions.ExtendSlides;
import org.firstinspires.ftc.teamcode.actions.OpenClawAction;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AllFunc {
    public machine robot;
    private DeepTeleop teleop;

    public AllFunc(DeepTeleop teleop) {
        this.teleop = teleop;
        this.robot = this.teleop.robot;
    }


    public Action angleup(){
        return new AngleSlides(teleop);
    }
    public void angledown(){
        robot.anglerright.setTargetPosition(950);
        robot.anglerleft.setTargetPosition(950);
        teleop.controlArmsWithPIDF();
    }
    public Action clawopen(){
        return new OpenClawAction(teleop);
    }
    public Action clawclose(){
        return new CloseClawAction(teleop);
    }
    public Action diffpick(){
        return new MoveDiff(teleop,0);
    }
    public Action diffput(){
        return new MoveDiff(teleop, .63);
    }
    public Action extendSlides(){
        return new ExtendSlides(teleop,-3000);
    }
    public Action retractSlides(){
        return new ExtendSlides(teleop,-0);
    }

    }



//angle up/down
//openclaw/closeclaw
//spin diff back/forward
//extend Retract***************