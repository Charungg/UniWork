/**
 * A basic Monster class that is missing many methods but
 * has a readKeyboard method to allow populating the class with data
 * @author Lynda Thomas, Chris Loftus and Faisal Rezwan
 * @version 3.0, 20th February 2022
 */
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
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
        loot = new ArrayList<>();
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
        loot = (ArrayList)setLoot.clone();
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

    public void seeIfFileExist(String monsterFile){
        try{
            File monsterFileObject = new File(monsterFile);

            if (monsterFileObject.createNewFile()){
                System.out.println("Monster file has been created");
            }

            else{

                System.out.println("Monster file already exist");
            }
        }

        catch (IOException e){
            System.out.println("Error has been found");
            e.printStackTrace();
        }

    }

    public void save(String monsterFile){
        System.out.println("Save running");

        try{
            BufferedReader in = new BufferedReader(new FileReader(monsterFile));
            PrintWriter out = new PrintWriter(new FileWriter((monsterFile)));

            

            in.close();
            out.close();
        }

        catch (IOException e){
            System.out.println("An Error Has Been Found");
            e.printStackTrace();
        }
        System.out.println("Save close");
    }

    public void load(String monsterFile){
        System.out.println("load running");

        try{
            BufferedReader in = new BufferedReader(new FileReader(monsterFile));
            ArrayList<String> saveFileContent = new ArrayList<String>();
            String lineContent;

            do{
                lineContent = in.readLine();
                saveFileContent.add(lineContent);
            }
            while(lineContent != null);

            for (int i=0; i<saveFileContent.size(); i ++){
                System.out.println(saveFileContent.get(i));
            }

            in.close();
            System.out.println("loaded content");
        }

        catch (IOException e){
            System.out.println("An Error Has Been Found");
            e.printStackTrace();
        }
    }
}