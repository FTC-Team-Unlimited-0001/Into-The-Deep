package org.firstinspires.ftc.teamcode.Vision;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.util.MathUtil;



import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
public class Visionnew extends SubsystemBase {
    private final Limelight3A camera;



  private boolean isDataOld = false;
 private SampleColor detectionColor = SampleColor.BLUE;
  private LLResult result;

    public static double CAMERA_HEIGHT = 193.141;
    public static double CAMERA_ANGLE = 0;
    public static double TARGET_HEIGHT = 19.05;

    public static double strafeConversionFactor = 6.6667;
    public static double cameraStrafeToBot = -20;

    public static double sampleToRobotDistance = 145;

    Telemetry telemetry;

    public Visionnew(final HardwareMap hardwareMap, Telemetry telemetry) {
        camera = hardwareMap.get(Limelight3A.class, "limelight");
        this.telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
    }


    public void initializeCamera() {
        camera.setPollRateHz(50);
        camera.start();
    }


    public enum SampleColor {
        RED(0.0),
        BLUE(1.0),
        YELLOW(2.0);

        private final double colorVal;

        SampleColor(double colorVal) {
            this.colorVal = colorVal;
        }

        public double getColorVal() {
            return colorVal;
        }
    }


    public double getTx(double defaultValue) {
        if (result == null) {
            return defaultValue;
        }
        return result.getTx();
    }

    public double getTy(double defaultValue) {
        if (result == null) {
            return defaultValue;
        }
        return result.getTy();
    }

    public boolean isTargetVisible() {
        if (result == null) {
            return false;
        }
        return !MathUtil.isNear(0, result.getTa(), 0.0001);
    }

    public double getDistance() {
        double ty = getTy(0.0);
        if (MathUtil.isNear(0, ty, 0.01)) {
            return 0;
        }
        double angleToGoalDegrees = CAMERA_ANGLE + ty;
        double angleToGoalRadians = Math.toRadians(angleToGoalDegrees);
        double distanceMM = (TARGET_HEIGHT - CAMERA_HEIGHT) / Math.tan(angleToGoalRadians);
        return Math.abs(distanceMM) - sampleToRobotDistance;
    }

    // Get the strafe
    public double getStrafeOffset() {
        double tx = getTx(0);
        if (tx != 0) {
            return tx * strafeConversionFactor - cameraStrafeToBot;
        }
        return 0;
    }

    public Double getTurnServoDegree() {
        if (result == null) {
            return null;
        }
        return result.getPythonOutput()[3];
    }

    @Override
    public void periodic() {
        camera.updatePythonInputs(
                new double[] {detectionColor.colorVal, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0});
        result = camera.getLatestResult();

        if (result != null) {
            long staleness = result.getStaleness();
            // Less than 100 milliseconds old
            isDataOld = staleness >= 100;
            telemetry.addData("Strafe Offset", getStrafeOffset());
            telemetry.addData("Distance", getDistance());
            telemetry.addData("Turn Servo Degrees", getTurnServoDegree());

                  telemetry.addData("Tx", result.getTx());
                  telemetry.addData("Ty", result.getTy());
                  telemetry.addData("Ta", result.getTa());
             telemetry.update();
        }
    }
}