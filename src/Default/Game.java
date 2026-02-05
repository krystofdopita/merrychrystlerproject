package Default;



public class Game {
    public static void jednaapul(){
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
    public static void dvaapul(){
//        try {
//            Thread.sleep(2500);
//        } catch (InterruptedException e) {
//    }
   }

    public static void start(){

        Console console = new Console();
        LocationManager lm = LocationManager.loadLocations("resources/map.json");
        GameInfo.setAllLocations(LocationManager.getLocations());
        console.inicialization();
        GameInfo.setCurrentLocation(LocationManager.getLocations().getFirst());


        System.out.println("Welcome, adventurer! Type tasks to display objectives and if you need help with controls type help.");



        console.execute();



    }
}
