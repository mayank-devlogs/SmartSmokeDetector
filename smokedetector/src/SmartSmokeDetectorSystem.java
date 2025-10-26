import java.util.*;

class SmokeSensor {
    private double smokeLevel;
    private final double threshold;

    SmokeSensor(double threshold) {
        this.threshold = threshold;
    }

    // Simulate reading smoke/gas level (0–100)
    public void readSensor() {
        smokeLevel = Math.random() * 100;
    }

    public double getSmokeLevel() {
        return smokeLevel;
    }

    public boolean isSmokeDetected() {
        return smokeLevel >= threshold;
    }
}

class AlarmSystem {
    public void triggerAlarm(double level) {
        System.out.println("🚨 ALERT! Smoke level high: " + String.format("%.2f", level));
        System.out.println("⚠️ Activating buzzer and sending notification...");
    }

    public void stopAlarm() {
        System.out.println("✅ Air quality normal. System stable.\n");
    }
}

class DataLogger {
    private final List<Double> log = new ArrayList<>();

    public void record(double smokeLevel) {
        log.add(smokeLevel);
    }

    public void displayLog() {
        System.out.println("\n📊 Smoke Level Log:");
        for (int i = 0; i < log.size(); i++) {
            System.out.println("Reading " + (i + 1) + ": " + String.format("%.2f", log.get(i)));
        }
    }
}

public class SmartSmokeDetectorSystem {
    public static void main(String[] args) throws InterruptedException {
        SmokeSensor sensor = new SmokeSensor(60.0);  // threshold = 60
        AlarmSystem alarm = new AlarmSystem();
        DataLogger logger = new DataLogger();

        System.out.println("=== SMART SMOKE DETECTOR SYSTEM ===\n");
        for (int i = 1; i <= 10; i++) {
            sensor.readSensor();
            double level = sensor.getSmokeLevel();
            System.out.println("Smoke Reading " + i + ": " + String.format("%.2f", level));
            logger.record(level);

            if (sensor.isSmokeDetected()) {
                alarm.triggerAlarm(level);
            } else {
                alarm.stopAlarm();
            }

            Thread.sleep(1000); // simulate delay between readings
        }

        logger.displayLog();
        System.out.println("\nSystem shutting down safely...");
    }
}
