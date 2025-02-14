package org.firstinspires.ftc.teamcode.Vision;//package org.firstinspires.ftc.teamcode.Vision;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import java.math.*;
import java.util.List;


@Config

public class Limelight {
    private Limelight3A limelight;
    private Telemetry telemetry; // Added telemetry reference

    // Constants
    private static final double LIMELIGHT_HEIGHT = 193.141; // mm
    private static final double TARGET_HEIGHT = 38.1; // mm
    private static final double CAMERA_OFFSET = 204.669; // mm

    // Target lateral distance for alignment (default to 0 for centered alignment)
    private double targetLateralDistance = 0;

    public Limelight(Limelight3A limelight, Telemetry telemetry) {
        this.limelight = limelight;
        this.telemetry = telemetry;
    }



    /**
     * Get the distance to the target using the vertical angle.
     * @return the calculated distance in mm, or -1 if no valid target is detected.
     */
    public double getDistanceToTarget() {
        limelight.pipelineSwitch(2);
        limelight.start();
        LLResult result = limelight.getLatestResult();
        if (result == null) {
            telemetry.addData("Debug", "Result is null");
        } else {
            telemetry.addData("Debug", "Result is valid: " + result.isValid());
        }
        telemetry.addData("Limelight Connected", limelight.isConnected());

        if (result != null && result.isValid()) {
            // Use the result data
            telemetry.addData("tx", result.getTx());
            telemetry.addData("ty", result.getTy());
            telemetry.addData("ta", result.getTa());
        }


        // Check if the result is valid
        if (result == null || !result.isValid()) {
            telemetry.addData("Distance to Target", "No valid target detected");
            return -1; // Indicate no valid target
        }
        else {
            double yOffset = result.getTy(); // Vertical angle in degrees
            double verticalAngle = Math.toRadians(yOffset);

         double distanceToTarget = Math.abs((LIMELIGHT_HEIGHT- (TARGET_HEIGHT/2)) * (1/Math.sin(result.getTy())));


            telemetry.addData("Distance to Target", distanceToTarget + " mm");


            return distanceToTarget;

        }}

    public String getLimelightTelemetry() {
        LLResult result = limelight.getLatestResult();
    limelight.start();
    limelight.pipelineSwitch(2);
        StringBuilder telemetryData = new StringBuilder();


        if (result != null && result.isValid()) {
            telemetryData.append("Target Valid: Yes\n");
            telemetryData.append("tx: ").append(result.getTx()).append("\n");
            telemetryData.append("ty: ").append(result.getTy()).append("\n");
            telemetryData.append("ta: ").append(result.getTa()).append("\n");

            telemetry.addData("Target Valid", "Yes");
            telemetry.addData("tx", result.getTx());
            telemetry.addData("ty", result.getTy());
            telemetry.addData("ta", result.getTa());
        } else {
            telemetryData.append("Target Valid: No\n");
            telemetry.addData("Target Valid", "No");
        }

        telemetry.update();
        return telemetryData.toString();
    }




    /**
     * Get the adjusted lateral distance from the robot's center.
     * @return the lateral distance in mm, or -1 if no valid target is detected.
     */
    public double getAdjustedLateralDistance() {

        LLResult result = limelight.getLatestResult();

        // Check if the result is valid
        if (result == null || !result.isValid()) {
            telemetry.addData("Adjusted Lateral Distance", "No valid target detected");
            return -1; // Indicate no valid target
        }

        // Retrieve necessary data
        double xOffset = result.getTx(); // Horizontal angle in degrees
        double distanceToTarget = getDistanceToTarget();

        if (distanceToTarget == -1) {
            telemetry.addData("Adjusted Lateral Distance", "No valid distance to target");
            return -1; // No valid distance
        }

        double horizontalAngle = Math.toRadians(xOffset);
        double lateralDistanceFromCamera = (LIMELIGHT_HEIGHT-(TARGET_HEIGHT/2)) * ((Math.sin(result.getTx())) / Math.tan(result.getTy()));

        // Adjust for camera offset
        double adjustedLateralDistance = lateralDistanceFromCamera + CAMERA_OFFSET;

        // Telemetry output
        telemetry.addData("Horizontal Offset (tx)", xOffset + " degrees");
        telemetry.addData("Lateral Distance from Camera", lateralDistanceFromCamera + " mm");
        telemetry.addData("Adjusted Lateral Distance", adjustedLateralDistance + " mm");
        return adjustedLateralDistance;
    }

    /**
     * Get the lateral alignment error.
     * @param targetLateralDistance The desired lateral distance (e.g., 0 for centered alignment).
     * @return The alignment error in mm, or -1 if no valid target is detected.
     */
    public double getLateralError(double targetLateralDistance) {
        double currentLateralDistance = getAdjustedLateralDistance();

        // Check if the lateral distance is valid
        if (currentLateralDistance == -1) {
            telemetry.addData("Lateral Error", "No valid target detected");
            return -1; // Indicate no valid target
        }

        // Calculate and return the error
        double lateralError = currentLateralDistance - targetLateralDistance;
        telemetry.addData("Lateral Error", lateralError + " mm");
        return lateralError;
    }

    public double[] getPythonOutput() {
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            // Get PythonOutput from SnapScript
            double[] pythonOutput = result.getPythonOutput();

            if (pythonOutput.length > 0) {
                telemetry.addData("Python Output", java.util.Arrays.toString(pythonOutput));


                return pythonOutput; // Return the PythonOutput array
            } else {
                telemetry.addData("Python Output", "No data from SnapScript");
            }
        } else {
            telemetry.addData("Status", "No valid target detected");
        }
    limelight.getStatus();
        telemetry.update();
        return null;
    }
    public double getCorners(Telemetry telemetry) {
        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {
            List<LLResultTypes.ColorResult> colorResults = result.getColorResults();
            if (!colorResults.isEmpty()) {
                LLResultTypes.ColorResult target = colorResults.get(0);
                limelight.pipelineSwitch(4);
                List<LLResultTypes.DetectorResult> corners = result.getDetectorResults();

                if (corners.size() >= 4) {
                    LLResultTypes.DetectorResult bottomLeft = corners.get(2);
                    LLResultTypes.DetectorResult bottomRight = corners.get(3);
                    LLResultTypes.DetectorResult topLeft = corners.get(0);
                    LLResultTypes.DetectorResult topRight = corners.get(1);

                    double low = Math.sqrt(Math.pow(bottomRight.getTargetXPixels() - bottomLeft.getTargetXPixels(), 2) +
                            Math.pow(bottomRight.getTargetYPixels() - bottomLeft.getTargetYPixels(), 2));

                    double high = Math.sqrt(Math.pow(topLeft.getTargetXPixels() - bottomLeft.getTargetXPixels(), 2) +
                            Math.pow(topLeft.getTargetYPixels() - bottomLeft.getTargetYPixels(), 2));

                    double resultValue = low + high;

                    // Add telemetry for debugging
                    telemetry.addData("Low (Bottom Edge)", low);
                    telemetry.addData("High (Left Edge)", high);
                    telemetry.addData("Result (Low + High)", resultValue);
                    telemetry.update();

                    return resultValue;
                }
            }
        }

        // Return -1 if detection fails and log it in telemetry
        telemetry.addData("Limelight Detection", "No valid corners detected");
        telemetry.update();
        return -1;
    }
}




