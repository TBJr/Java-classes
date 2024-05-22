import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

    // Method to continuously update and print the current time
    public static void updateAndPrintTime() {
        Thread updateTimeThread = new Thread(() -> {
            while (true) {
                Date now = new Date();
                System.out.println("Current Time: " + dateFormat.format(now));
                try {
                    Thread.sleep(1000); // Update time every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateTimeThread.setPriority(Thread.MIN_PRIORITY); // Lower priority for background updating thread

        Thread printTimeThread = new Thread(() -> {
            while (true) {
                Date now = new Date();
                System.out.println("Current Time: " + dateFormat.format(now));
                try {
                    Thread.sleep(1000); // Update time every second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        printTimeThread.setPriority(Thread.MAX_PRIORITY); // Higher priority for clock display thread

        updateTimeThread.start();
        printTimeThread.start();
    }

    public static void main(String[] args) {
        updateAndPrintTime();
    }
}
