/**
 * A basic Monster class that is missing many methods but
 * has a readKeyboard method to allow populating the class with data
 * @author Lynda Thomas, Chris Loftus and Faisal Rezwan
 * @version 3.0, 20th February 2022
 */
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;

public class Monster {
    // *****************instance variables are the 'attributes' of a thing
    private String type;
    private String hair;
    private String face;
    private int powerPoints;
    private ArrayList<Treasure> loot;

    /**
     * A default constructor.
     */
    public Monster() {
        type = "unknown";
        loot = new ArrayList<Treasure>();
    }

    /**
     * This constructor allows us to set the features of the monster.
     * @param startType The type of monster
     * @param startHair The hair colour
     * @param startFace The face colour
     */
    public Monster(String startType, String startHair, String startFace, ArrayList<Treasure> setLoot) {
        type = startType;
        hair = startHair;
        face = startFace;
        powerPoints = 100;
        loot = new ArrayList<Treasure>();
    }

    /**
     * We can set the treasure object
     * @param newTreasure the treasure we wish to give the monster
     */
    public void addTreasure(Treasure newTreasure) {
        loot.add(newTreasure);
    }

    /**
     * Reads the monster type, hair colour, face colour and power points from
     * the keyboard.
     */

    public void changeMonster(){
        Scanner in = new Scanner(System.in);
        System.out.println("enter hair: ");
        hair = in.nextLine();
        System.out.println("enter face: ");
        face = in.nextLine();
    }
    public void readKeyboard() {
        Scanner in = new Scanner(System.in);
        System.out.print("enter type: ");
        type = in.nextLine();
        System.out.print("enter hair: ");
        hair = in.nextLine();
        System.out.print("enter face: ");
        face = in.nextLine();
        System.out.print("enter power: ");
        powerPoints = in.nextInt();
        // This clears the end of line characters ready for the
        // next character input, otherwise you'll get an empty
        // string returned.
        in.nextLine();
    }

    public String toString() {
        String ret = "This scary monster is of type " + type + " with " + hair
                + " hair and " + face + " face and " + powerPoints
                + " points";
        if (loot != null) {
            ret += " and treasure " + loot.toString() + "\n";
        } else {
            ret += " and no treasure\n";
        }
        return ret;
    }

    public boolean seeIfFileExist(String monsterFile) throws IOException{
        File monsterFileObject = new File(monsterFile);

        if (monsterFileObject.createNewFile()){
            System.out.println("Monster file has been created");
            return false;
        }

        else{
            System.out.println("Monster file already exist");
            return true;
        }
    }

    public void save(String monsterFile) throws IOException{
        System.out.println("Save running");
        PrintWriter out = new PrintWriter(new FileWriter(monsterFile));

        out.println(type + "\n" + hair + "\n" + face + "\n" + powerPoints);
        for (int i=0; i<loot.size(); i++){
            out.println(loot.get(i).getName() + "\n" + loot.get(i).getValue());
        }

        System.out.println("Save close");
        out.close();
    }


    public void load(String monsterFile) throws IOException{
        FileReader fileInput = new FileReader(monsterFile);
        Scanner console = new Scanner(fileInput);

        console.useDelimiter("\r?\n|\r");

        type = console.next();
        hair = console.next();
        face = console.next();
        powerPoints = console.nextInt();

        while (console.hasNext()){
                loot.add(new Treasure(console.next(),console.nextInt()));
        }

        console.close();
        fileInput.close();
    }
}