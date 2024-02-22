public class Treasure {
    private int specialPowerPoints;

    private String colour;

    private String type;

    public Treasure(){
        specialPowerPoints = 0;
        colour = "uknown";
        type = "unknown";
    }

    public Treasure(int setSpecialPowerPoints, String setColour, String setType){
        specialPowerPoints = setSpecialPowerPoints;
        colour = setColour;
        type = setType;
    }

    public void setPower(int setSpecialPowerPoints){
        specialPowerPoints = setSpecialPowerPoints;
    }

    public int getPower(){
        return specialPowerPoints;
    }


}
