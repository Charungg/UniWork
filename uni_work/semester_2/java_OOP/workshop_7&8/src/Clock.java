public class Clock {
    private Time currentTime;

    private Time alarmTime;

    private boolean alarm;

    public Clock (){
        alarm = false;
    }
    public Clock (Time setCurrentTime, Time setAlarmTime){
        currentTime = setCurrentTime;
        alarmTime = setAlarmTime;
        alarm = false;
    }

    public void setCurrentTime(Time setTimeValue){
        currentTime = setTimeValue;
    }

    public void setAlarmTime(Time setTimeValue){
        alarmTime = setTimeValue;
    }

    public void setAlarmTime(boolean setAlarmValue){
        alarm = setAlarmValue;
    }

    public boolean isAlarmSet(){
        return alarm;
    }

    public String toString(){
        return ("Clock:  " + "\n" +
                "Current Time = " + currentTime.toString() + "\n" +
                "Alarm Time = " + alarmTime.toString() + "\n" +
                "Alarm status is set " + alarm);
    }



}
