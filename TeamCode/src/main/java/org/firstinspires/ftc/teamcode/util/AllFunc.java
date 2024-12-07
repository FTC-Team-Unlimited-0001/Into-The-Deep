package org.firstinspires.ftc.teamcode.util;

import org.firstinspires.ftc.teamcode.teleop.teleop.DeepTeleop;

public class AllFunc {
    public machine robot;

    public void angleup(){
        DeepTeleop telee = new DeepTeleop();
        robot.anglerright.setTargetPosition(250);
        robot.anglerleft.setTargetPosition(250);
        telee.controlArmsWithPIDF();
    }
    public void angledown(){
        DeepTeleop telee = new DeepTeleop();
        robot.anglerright.setTargetPosition(950);
        robot.anglerleft.setTargetPosition(950);
        telee.controlArmsWithPIDF();
    }
    public void clawopen(){
        DeepTeleop telee = new DeepTeleop();
        robot.servopinch.setPosition(0.35);
    }
    public void clawclose(){
        DeepTeleop telee = new DeepTeleop();
        robot.servopinch.setPosition(0);
    }
    public void diffpick(){
        DeepTeleop telee = new DeepTeleop();
        robot.servoleft.setPosition(0);
        robot.servoright.setPosition(0);
    }
    public void diffput(){
        DeepTeleop telee = new DeepTeleop();
        robot.servoleft.setPosition(.63);
        robot.servoright.setPosition(.63);
    }


}

//angle up/down
//openclaw/closeclaw
//spin diff back/forward
//extend Retract***************