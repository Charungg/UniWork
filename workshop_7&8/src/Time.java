public class Time {
    private int hour;

    private int minute;

    public Time(int setHourValue, int setMinuteValue){
        hour = setHourValue;
        minute = setMinuteValue;
    }

    public void setHour(int setHourValue){
        hour = setHourValue;
    }

    public void setMinute(int setMinuteValue){
        minute = setMinuteValue;
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public String toString(){
        return ("Hour = " + hour + ", minute= " + minute);
    }


}
