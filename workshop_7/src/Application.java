import java.util.Scanner;

/**
 *  This workshop teaches me how to get user input.
 *  Independently create classes and linking between multiple objects.
 *  Created clocks which holds multiple time, current time and alarm time.
 *  Created a loop which asks for alarm time.
 */
public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.runTests();
    }

    public void runTests() {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter a hour time for clock time");
        int hour = console.nextInt();

        System.out.println("Enter a minute time for clock time");
        int minute = console.nextInt();

        Time current = new Time(hour, minute);
        Time alarm = new Time(8, 20);

        Clock clock1 = new Clock();
        clock1.setCurrentTime(current);
        clock1.setAlarmTime(alarm);

        System.out.println(clock1.toString());

//        for (int i = 0; i < 5; i++) {
//            System.out.println();
//            System.out.println("Enter a hour time for alarm time");
//            hour = console.nextInt();
//
//            System.out.println("Enter a minute time for alarm time");
//            minute = console.nextInt();
//            System.out.println("Clock state = " + alarm);
//        }

        /**
         * Top: for loop.
         * Bottom: while loop.
         */

        runMenuWithForLoop(clock1, current, alarm);

        runMenuWithWhileLoop(clock1, current, alarm);
    }

    public void runMenuWithForLoop(Clock clock1, Time current, Time alarm) {
        Scanner console = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("a. Change the current time;");
            System.out.println("b. Change the alarm time;");
            System.out.println("c. Set or unset the alarm;");
            String userInput = console.next();

            switch (userInput) {
                case "a":
                    System.out.println("Enter a hour time for clock time");
                    int hour = console.nextInt();

                    System.out.println("Enter a minute time for clock time");
                    int minute = console.nextInt();

                    current.setHour(hour);
                    current.setMinute(minute);
                    break;

                case "b":
                    System.out.println("Enter a hour time for alarm time");
                    hour = console.nextInt();

                    System.out.println("Enter a minute time for alarm time");
                    minute = console.nextInt();

                    alarm.setHour(hour);
                    alarm.setMinute(minute);
                    break;

                case "c":
                    System.out.println("true or false");
                    boolean userInputBoolean = console.nextBoolean();

                    clock1.setAlarmTime(userInputBoolean);
                    break;

            }
        }
    }


    public void runMenuWithWhileLoop(Clock clock1, Time current, Time alarm){
        Scanner console = new Scanner(System.in);
        String userInput;

        do{
            System.out.println("a. Change the current time;");
            System.out.println("b. Change the alarm time;");
            System.out.println("c. Set or unset the alarm;");
            userInput = console.next();

            switch (userInput) {
                case "a":
                    System.out.println("Enter a hour time for clock time");
                    int hour = console.nextInt();

                    System.out.println("Enter a minute time for clock time");
                    int minute = console.nextInt();

                    current.setHour(hour);
                    current.setMinute(minute);
                    break;

                case "b":
                    System.out.println("Enter a hour time for alarm time");
                    hour = console.nextInt();

                    System.out.println("Enter a minute time for alarm time");
                    minute = console.nextInt();

                    alarm.setHour(hour);
                    alarm.setMinute(minute);
                    break;

                case "c":
                    System.out.println("true or false");
                    boolean userInputBoolean = console.nextBoolean();

                    clock1.setAlarmTime(userInputBoolean);
                    break;
            }
        }
        while(true);
    }
}