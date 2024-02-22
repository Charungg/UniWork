public class Road {
    private String name;
    private RoadType roadType;
    private Settlement sourceSettlement;
    private Settlement destinationSettlement;

    public Road(String setName, RoadType setClassifier, Settlement setSource, Settlement setDestination){
        name = setName;
        roadType = setClassifier;
        sourceSettlement = setSource;
        destinationSettlement = setDestination;
    }

    public String getName(){
        return name;
    }

    public RoadType getRoadType(){
        return roadType;
    }

    public Settlement getSourceSettlement(){
        return sourceSettlement;
    }

    public Settlement getDestinationSettlement(){
        return destinationSettlement;
    }

    public String toString(){
        return ("Road name = " + name +
                ", road type = " + roadType +
                ", source settlement = " + sourceSettlement.getName() +
                ", destination = " + destinationSettlement.getName());
    }
}
