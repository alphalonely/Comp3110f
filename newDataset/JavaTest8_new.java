
public class Time {
    private int hour;
    private int minute;
    private int second;

    // Constructor with no parameters (defaults to midnight)
    public Time() {
        this(0, 0, 0);
    }

    // Constructor with parameters (validates input)
    public Time(int hour, int minute, int second) {

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }


    // Convert time to standard format (12-hour format with AM/PM)
    public String toString() {
        int standardHour = (hour == 0 || hour == 12) ? 12 : hour % 12;
        String amPm = (hour < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", standardHour, minute, second, amPm);
    }

    // Convert time to 24-hour format
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // Increment time by one second (adjust minutes and hours accordingly)
    public void tick() {
        second++;
        if (second == 60) {
            second = 0;
            incrementMinute();
        }
    }


    // Increment time by one hour (reset to midnight if necessary)
    public void incrementHour() {
        hour++;
        if (hour == 24) {
            hour = 0;
        }
    }

    // Compare two Time objects to check if they are equal
    public boolean isEqual(Time other) {
        return this.hour == other.hour && this.minute == other.minute && this.second == other.second;
    }
}
