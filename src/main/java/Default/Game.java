package main.java.Default;




public class Game {
    // Helper method to wait for 1.5 seconds
    public static void jednaapul(){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    // Helper method to wait for 2.5 seconds
    public static void dvaapul(){
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
    }
   }
//This method starts the whole game
    public static void start(){

        Console console = new Console();
        LocationManager lm = LocationManager.loadLocations("/map.json");
        GameInfo.setAllLocations(LocationManager.getLocations());
        console.inicialization();
        GameInfo.setCurrentLocation(LocationManager.getLocations().getFirst());


        System.out.println("Welcome, adventurer! Type tasks to display objectives and if you need help with controls type help.");



        console.execute();



    }
}
