/**
 * This is the class Monster - a "BP" for all Monster
 *
 * @author Charung
 * @version 1
 */
public class MythicalMonster {

    //*****************instance variables are the 'attributes' of a thing
    private String monsterType;
    private String hair;
    private int powerPoints;
    private String skinColour;
    private int speed;


    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;

    }
//***************** constructors are the routines to build the object

    /**
     * Constructor for objects of class Monster
     */
    public MythicalMonster() {
        monsterType = "unknown";
        powerPoints = 100;
    }

//***************** methods are the 'actions' the thing can do

    /**
     * Constructor for objects of class Monster
     *
     * @param startType   becomes initial type of monster
     * @param startHair   becomes initial hair colour
     * @param startPoints initial powerPoints
     */
    public MythicalMonster(String startType, String startHair, int startPoints, String startSkinColour) {
        monsterType = startType;
        hair = startHair;
        powerPoints = startPoints;
        skinColour = startSkinColour;
    }

    /**
     * This method 'returns' information about a monster
     *
     * @return monster info for printing
     */
    public String toString() {
        return "This scary monster is of type " + monsterType
                + " with " + hair + " hair, " + skinColour + " " +
                "skin colour and " + + powerPoints + " points";
    }

    /**
     * This method makes the monster wail
     * it uses a loop - not done yet
     */
    public void wail() {
        System.out.println("I am a " + monsterType + " watch me WAIL!!!");
        for (int i = 0; i < powerPoints / 5; i++)
            System.out.println("ooooooooOOOOOOh ");
    }

    /**
     * This method sets a new  hair colour
     *
     * @param newHairColour becomes new hair colour
     */
    public void setHair(String newHairColour) {
        hair = newHairColour;
    }

    /**
     * This method gets the  hair colour
     *
     * @return hair colour
     */
    public String getHair() {
        return hair;
    }

    /**
     * This method sets new powerPoints
     *
     * @param newPoints becomes new points
     */
    public void setPoints(int newPoints) {
        powerPoints = newPoints;
    }

}



