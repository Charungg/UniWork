public class Application {
    public static void main(String[] args) {
//        Settlement settlement1 = new Settlement("Rocky Town", SettlementType.TOWN);
//        settlement1.setPopulation(200);
//        System.out.println(settlement1.toString());
//
//        Settlement settlement2 = new Settlement("Snowy Village", SettlementType.VILLAGE);
//        settlement2.setPopulation(100);
//        System.out.println(settlement2.toString());


//        Settlement aberystwyth = new Settlement("Aberystwyth", SettlementType.TOWN);
//        Settlement bowStreet = new Settlement("Bow Street", SettlementType.VILLAGE);
//
//        Road A487 = new Road("A487", RoadType.A, aberystwyth, bowStreet);
//        System.out.println(A487.toString());

        Settlement aberystwyth = new Settlement("Aberystwyth",
                SettlementType.TOWN);
        aberystwyth.setPopulation(20000);
        Settlement bowStreet = new Settlement("Bow Street",
                SettlementType.VILLAGE);
        bowStreet.setPopulation(2000);
        Settlement borth = new Settlement("Borth",
                SettlementType.VILLAGE);
        borth.setPopulation(1500);
        Settlement llanbadarn = new Settlement("Llanbadarn",
                SettlementType.VILLAGE);
        llanbadarn.setPopulation(3000);
        Settlement penparcau = new Settlement("Penparcau",
                SettlementType.VILLAGE);
        penparcau.setPopulation(3100);

        Road A44 = new Road("A44", RoadType.A, aberystwyth, llanbadarn);
        Road A487 = new Road( "A487", RoadType.A, aberystwyth, bowStreet);
        Road A487_2 = new Road("A487",RoadType.A, aberystwyth, penparcau);
        Road hoelYBont = new Road ("Hoel-Y-Bont",RoadType.U, llanbadarn, penparcau);
        Road B4353 = new Road ("B4353", RoadType.B, bowStreet, borth);

        System.out.println(aberystwyth.toString());
        System.out.println(borth.toString());
        System.out.println(borth.toString());
        System.out.println(llanbadarn.toString());
        System.out.println(penparcau.toString());
        System.out.println(A44.toString());
        System.out.println(A487.toString());
        System.out.println(A487_2.toString());
        System.out.println(hoelYBont.toString());
        System.out.println(B4353.toString());



    }
}
