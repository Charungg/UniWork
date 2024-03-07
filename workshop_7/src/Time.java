public class Time {
    private int hour;

    private int minute;

    public Time(int setHourValue, int setMinuteValue) {
        setHour(setHourValue);
        setMinute(setMinuteValue);
    }

    public void setHour(int setHourValue) {
        if (setHourValue>=0 && setHourValue <= 23) {
            hour = setHourValue;
        }
        else{
            System.out.println("Invalid input");
        }
    }

    public void setMinute(int setMinuteValue) {
        if (setMinuteValue >= 0 && setMinuteValue <= 59) {
            minute = setMinuteValue;
        } else {
            System.out.println("Invalid input");
        }
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public String toString(){
        return String.format("%02d:%02d", hour, minute);
    }


}
