package Default;



public class Game {

    public static void start(){
        Console console = new Console();
        LocationManager lm = LocationManager.loadLocations("resources/map.json");
        GameInfo.setAllLocations(LocationManager.getLocations());
        console.inicialization();
        GameInfo.setCurrentLocation(LocationManager.getLocations().getFirst());
        System.out.println("Welcome, adventurer! Type tasks to display objectives.");



        console.execute();



    }
}
