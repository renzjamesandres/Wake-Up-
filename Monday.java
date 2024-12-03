import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Monday extends Weekday {
    private String time; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time for alarm in this format (HH:MM): ");
        String timeInput = scanner.nextLine();

        Monday monday = new Monday();
        monday.setAlarm(timeInput);
        monday.showAlarm();

        scanner.close();
    }

    @Override
    public void setAlarm(String time) {
        this.time = time;
    }

    @Override
    public void showAlarm() {
        try {
            LocalTime alarm = LocalTime.parse(time);
            LocalTime now = LocalTime.now();

            if (alarm.isAfter(now)) {
                System.out.println("I'll wake you up later!");
            } else {
                System.out.println("Alarm is set for tomorrow!");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid time format. Please enter time in HH:MM format.");
        }
    }
}
