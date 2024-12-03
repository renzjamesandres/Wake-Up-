import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.LocalTime;

// Define the Alarm interface
interface Alarm {
    void setAlarm(String time);
    void showAlarm();
}

// Define the abstract Weekday class that implements the Alarm interface
abstract class Weekday implements Alarm {
    private String alarmTime;

    @Override
    public void setAlarm(String time) {
        this.alarmTime = time;
    }

    @Override
    public void showAlarm() {
        LocalTime alarm = LocalTime.parse(alarmTime); // Convert String to LocalTime
        LocalTime now = LocalTime.now(); // Get the current time

        // Check if the alarm time is before the current time
        if (alarm.isBefore(now)) {
            System.out.println("Alarm is set for tomorrow!");
        } else {
            System.out.println("I'll wake you up later!");
        }
    }
}

// Define the public class Monday that contains the main method
public class Monday extends Weekday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Monday monday = new Monday();
        
        System.out.print("Enter time for alarm in this format (HH:MM): ");
        String timeInput = scanner.nextLine();

        monday.setAlarm(timeInput);
        monday.showAlarm();
        
        scanner.close();
    }
}
