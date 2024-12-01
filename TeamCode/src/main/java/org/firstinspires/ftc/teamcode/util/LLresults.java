package org.firstinspires.ftc.teamcode.util;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



import java.util.List;


import java.util.ArrayList;


@Config
public class LLresults {

    private Telemetry telemetry;




    List<List<Double>> newCorners = new ArrayList<>();



    // Call sortCorners function and store result in cornerIndices
    int[] cornerIndices;
    double targetArea;
    boolean targetFound;

    Limelight3A limelight;

    public List<List<Double>> corners;
    public String cornerList;
    public double contourHeight;
    public double contourWidth;
    public double deltaY;
    public double deltaX;
    public double[][] cornerPoints;
    public double tX, tY;
    public boolean tiltedLeft;


    HardwareMap hardwareMap;

    public void init(HardwareMap hwMap) {
        hardwareMap = hwMap;


        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100); // This sets how often we ask Limelight for data (100 times per second)
        limelight.start(); // This tells Limelight to start looking!
        limelight.pipelineSwitch(0);
        cornerPoints = new double[4][2];


    }

    machine robot;

    public double getOrientation() {
        LLResult result = limelight.getLatestResult();
        tX = 0;
        tY = 0;
        targetArea = 0;
        if (result != null && result.isValid()) {
            List<LLResultTypes.ColorResult> colorRes = result.getColorResults();
            if (colorRes.size() == 0) {
                return -1;
            }
            corners = colorRes.get(0).getTargetCorners();

            if (corners.size() >= 4) {
                List<List<Double>> newCorners = colorRes.get(0).getTargetCorners().subList(0, 4);
                tX = colorRes.get(0).getTargetXDegrees();
                tY = colorRes.get(0).getTargetYDegrees();
                cornerIndices = sortCorners(newCorners);
                targetArea = colorRes.get(0).getTargetArea();
                if (newCorners.get(cornerIndices[0]).get(0) - newCorners.get(cornerIndices[1]).get(0)
                        > newCorners.get(cornerIndices[2]).get(1) - newCorners.get(cornerIndices[1]).get(1)) {
                        deltaY = newCorners.get(cornerIndices[0]).get(1) - newCorners.get(cornerIndices[1]).get(1);
                        deltaX = newCorners.get(cornerIndices[0]).get(0) - newCorners.get(cornerIndices[1]).get(0);
                } else {
                    deltaY = newCorners.get(cornerIndices[2]).get(1) - newCorners.get(cornerIndices[1]).get(1);
                    deltaX = newCorners.get(cornerIndices[2]).get(0) - newCorners.get(cornerIndices[1]).get(0);
                }

//                for (int index = 0; index < 4; index++) {
//                    cornerPoints[index][0] = corners.get(cornerIndices[index]).get(0);
//                    cornerPoints[index][1] = corners.get(cornerIndices[index]).get(1);
//                }

                tiltedLeft = newCorners.get(cornerIndices[1]).get(1) <
                        newCorners.get(cornerIndices[0]).get(1);
                double angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
                if (angle < 0) {
                    return 180 + angle;
                }
                return angle;
            }
        }
        return -1;
    }

    private int[] sortCorners(List<List<Double>> corners) {
        int leastYIndex = 0;
        int secondLeastYIndex = 1;

        for (int i = 0; i<corners.size(); i++) {
            double val = corners.get(i).get(1);
            if (val < corners.get(leastYIndex).get(1)) {
                secondLeastYIndex = leastYIndex;
                leastYIndex = i;
            }
            else if (val < corners.get(secondLeastYIndex).get(1) && i!=leastYIndex) {
                secondLeastYIndex = i;
            }
        }
        int bottomRight, bottomLeft;
        if (corners.get(leastYIndex).get(0) > corners.get(secondLeastYIndex).get(0)) {
            bottomRight = leastYIndex;
            bottomLeft = secondLeastYIndex;
        }
        else {
            bottomRight = secondLeastYIndex;
            bottomLeft = leastYIndex;
        }
        int topRight, topLeft;
        int [] remainingIndices = findRemainingIntegers(bottomLeft, bottomRight);
        if (corners.get(remainingIndices[0]).get(0) > corners.get(remainingIndices[1]).get(0)) {
            topRight = remainingIndices[0];
            topLeft = remainingIndices[1];
        }
        else {
            topRight = remainingIndices[1];
            topLeft = remainingIndices[0];
        }
        contourHeight = Math.abs(corners.get(topRight).get(1)-corners.get(bottomRight).get(1)); // Abs not really needed
        contourWidth = Math.abs(corners.get(bottomRight).get(0)-corners.get(bottomLeft).get(0)); // Abs not really needed


        return new int[]{bottomRight, bottomLeft, topLeft, topRight};
    }

    public int[] findRemainingIntegers(int given1, int given2) {
        // Set of all integers between 0 and 3
        Set<Integer> allIntegers = new HashSet<>(Arrays.asList(0, 1, 2, 3));

        // Remove the two given integers
        allIntegers.remove(given1);
        allIntegers.remove(given2);

        // Convert the remaining integers to an array
        int[] remaining = new int[2];
        int index = 0;
        for (int num : allIntegers) {
            remaining[index++] = num;
        }

        return remaining;
    }

}

