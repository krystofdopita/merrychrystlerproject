package Default;

public class Game {

    public static void start(){
        Console console = new Console();
        LocationManager lm = LocationManager.loadLocations("resources/map.json");
        console.inicialization();
        GameInfo.setCurrentLocation(LocationManager.loadLocations("resources/map.json").getLocations().get(0));
        System.out.println("Welcome, adventurer! You can type move to explore the world,type exit to leave the game or type help if you need some help.");


        console.execute();



    }
}
