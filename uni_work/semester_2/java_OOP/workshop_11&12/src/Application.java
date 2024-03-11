/**
 * The application class that we run from
 * @author Lynda Thomas, Chris Loftus and Faisal Rezwan
 * @version 3.0, 26th February 2022
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    private Monster monster1;
    private Treasure treasure1;
    private Treasure treasure2;
    private Scanner in;

    /**
     * Initialise the application with two empty monsters
     * and two empty treasures and a Scanner.
     */
    public Application() {
        monster1 = new Monster();
        treasure1 = new Treasure();
        treasure2 = new Treasure();
        in = new Scanner(System.in);
    }

    private void runApp() {
        String choice;
        char a;
        System.out.println("*** HELLO - WELCOME TO MONSTER LAND ");
        do {
            printMenu();
            choice = in.nextLine().toUpperCase();
            switch (choice) {
                // Read in information about the two monsters
                case "M":
                    System.out.println("enter info about monster 1");
                    monster1.readKeyboard();
                    break;
                // Read in information about the two treasures
                case "T":
                    System.out.println("enter info about treasure 1");
                    treasure1.readKeyboard();
                    System.out.println("enter info about treasure 2");
                    treasure2.readKeyboard();

                    break;
                // Give treasure1 to monster1 and treasure2 to monster2
                case "G":
                    monster1.addTreasure(treasure1);
                    monster1.addTreasure(treasure2);
                    System.out.println("DONE!");
                    break;
                // Display the current state of our monsters
                case "P":
                    System.out.println(this.toString());
                    break;

                case "Q":
                    System.out.println("*** THANK YOU FOR USING MONSTER LAND");
                    break;

                case "C":
                    monster1.changeMonster();
                    break;

                default:
                    System.out.println("not a valid choice");
            }
        } while (!choice.equals("Q"));
    }

    private void printMenu() {
        System.out.println("lots of menu lines \n m - read monsters info \n c - change monster info \n t - read treasures info \n g - give treasures to monsters \n p - print \nq = quit");
    }

    public static void main(String args[]) {
//        Application app = new Application();
//        app.runApp();

        Monster test = new Monster();

        String saveFile = "monsterData.txt";
        test.seeIfFileExist(saveFile);
//        test.save(saveFile);
        test.load(saveFile);
    }
}
