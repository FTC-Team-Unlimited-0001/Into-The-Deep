package org.firstinspires.ftc.teamcode.util;

public class MathUtil {
    public static boolean isNear(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }
}
