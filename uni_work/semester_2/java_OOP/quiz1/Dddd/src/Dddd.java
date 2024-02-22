public class Dddd {
    java.util.Scanner input;

    /**
     *  private int static final
     */
    private int numberFinder = 35;

    private int[] x;

    public int userInput(){
        x = new int[14];
        int i = 0;

        for(x.length<15){
            System.out.println("Type in a number");
            x[i] = input.nextInt();
        }

    }

    public void checker(){
        int found = 0;
        int i =0;
        for (x.length<15){
            if (x[i]==numberFinder){
                found++;
                i++;
            }
            else{
                i++;
            }
        }
        System.out.println("Found value " +numberFinder + " " + found " times");
    }
}
