package org.firstinspires.ftc.teamcode.util;

import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.actions.AngleLinkages;
import org.firstinspires.ftc.teamcode.actions.CloseClawAction;
import org.firstinspires.ftc.teamcode.actions.MoveDiff;
import org.firstinspires.ftc.teamcode.actions.ExtendSlides;
import org.firstinspires.ftc.teamcode.actions.OpenClawAction;
import org.firstinspires.ftc.teamcode.actions.StopOnDime;
import org.firstinspires.ftc.teamcode.actions.retractSlides;
import org.firstinspires.ftc.teamcode.actions.stopSlides;
import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AllFunc {
    public machine robot;
    private DeepTeleop teleop;

    public AllFunc(DeepTeleop teleop) {
        this.teleop = teleop;
        this.robot = this.teleop.robot;
    }
    public Action bucketAngleUp(){return new AngleLinkages(teleop, 0);}
    public Action angleDown(){return new AngleLinkages(teleop, 1);}
    public Action specimanAngle(){return new AngleLinkages(teleop,.19);}
    public Action specimanPickUpAngle(){return new AngleLinkages(teleop,.75);}
    public Action specimanDiffPickup() {return new MoveDiff(teleop,.3);}



    public Action clawopen(){
        return new OpenClawAction(teleop);
    }
    public Action clawclose(){
        return new CloseClawAction(teleop);
    }
    public Action diffdeposit(){return new MoveDiff(teleop,0);}
    public Action diffput(){
        return new MoveDiff(teleop, .63);
    }
    public Action stopSlides(){return new stopSlides(teleop);}
    public Action bucketExtendSlides(){return new ExtendSlides(teleop,-900);
    }
    public Action specimanExtendSlides(){return new ExtendSlides(teleop,-405);}
    public Action halfExtendSlides(){return new ExtendSlides(teleop,-200);}

    public Action retractSlides(){return new retractSlides(teleop,0);}
    public Action stopOnDime(){return new StopOnDime(teleop);}
    }




