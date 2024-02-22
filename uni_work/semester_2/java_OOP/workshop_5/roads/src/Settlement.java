public class Settlement {
    private String name;
    private int population;
    private SettlementType kind;
    private Road[] roads;
    private int numRoads;

    /**
     * Represents the maximun number of roads that can be
     * connected to a Settlement object.
     */
    public static final int MAX_ROADS = 100;

    public Settlement(String setName, SettlementType setKind){
        name = setName;
        kind = setKind;
        roads = new Road[MAX_ROADS];
    }

    public String getName(){
        return name;
    }
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int setPopulation) {
        this.population = setPopulation;
    }

    public SettlementType getKind(){
        return kind;
    }

    public void setKind(SettlementType setKind){
        this.kind = setKind;
    }

    public void add(Road road){
        if (numRoads < MAX_ROADS){
            roads[numRoads] = road;
            numRoads++;
        }
    }

    public String toString(){
        return ("Name of settlement = " + name +
                ", populatsion = " + population +
                ", kind = " + kind);
    }
}
