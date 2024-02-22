/**
 * This is the class Monster - a "BP" for all Monster
 *
 * @author Charung
 * @version 1
 */

public class Application {

    public static void main(String args[]) {
//        Monster elf = new Monster("elf","pink",100);
//        System.out.println(elf.toString());
//
//        Monster uknownMonster = new Monster ("unknown","no",100);
//        System.out.println(uknownMonster.toString());


        MythicalMonster anon = new MythicalMonster();
        MythicalMonster elf = new MythicalMonster("elf", "pink", 123, "black");
        anon.setPoints(50);

        System.out.println(anon.toString());
        System.out.println(elf.toString());

        Treasure chest = new Treasure();
        System.out.println(chest.getPower());


    }
}

