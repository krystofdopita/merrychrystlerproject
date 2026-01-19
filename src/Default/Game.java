package Default;

public class Game {

    public static void start(){
        Console console = new Console();
        console.inicialization();
        GameInfo.setCurrentLocation(LocationManager.loadLocations("resources/map.json").getLocations().get(0));
        System.out.println("Welcome, adventurer! You can type move to explore the world or type exit to leave the game.");


        console.execute();



    }
}
