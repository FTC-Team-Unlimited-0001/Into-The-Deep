package org.firstinspires.ftc.teamcode.util;

import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.actions.AngleLinkages;
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
    public Action bucketAngleUp(){return new AngleLinkages(teleop, 0);}
    public Action angleDown(){return new AngleLinkages(teleop, Math.toRadians(47));}
    public Action specimanAngle(){return new AngleLinkages(teleop,0.1);}
    public Action specimanPickUpAngle(){return new AngleLinkages(teleop,0.1);}



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
    public Action bucketExtendSlides(){
        return new ExtendSlides(teleop,-3000);
    }
    public Action specimanExtendSlides(){return new ExtendSlides(teleop,0);}
    public Action retractSlides(){
        return new ExtendSlides(teleop,-0);
    }

    }



//angle up/down
//openclaw/closeclaw
//spin diff back/forward
//extend Retract***************