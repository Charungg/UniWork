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

    public void runTests(){
        Scanner console = new Scanner(System.in);

        System.out.println("Enter a hour time for clock time");
        int hour = console.nextInt();

        System.out.println("Enter a minute time for clock time");
        int minute = console.nextInt();

        Time current = new Time(hour,minute);
        Time alarm = new Time(8,20);

        Clock clock1 = new Clock();
        clock1.setCurrentTime(current);
        clock1.setAlarmTime(alarm);

        System.out.println(clock1.toString());

        for (int i=0; i<5; i++){
            System.out.println();
            System.out.println("Enter a hour time for alarm time");
            hour = console.nextInt();

            System.out.println("Enter a minute time for alarm time");
            minute = console.nextInt();
            System.out.println("Clock state = " + alarm);
        }
    }
}