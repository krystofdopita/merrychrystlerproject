package Default;

import locations.Location;
import java.util.List;

public class GameInfo {
    private static Location CurrentLocation;
    private static String CurrentState;
    private static List<Location> allLocations;
    //private static


    public static Location getCurrentLocation() {
        return CurrentLocation;
    }

    public static void setCurrentLocation(Location currentLocation) {
        CurrentLocation = currentLocation;
    }

    public static String getCurrentState() {
        return CurrentState;
    }

    public static void setCurrentState(String currentState) {
        CurrentState = currentState;
    }

    public static List<Location> getAllLocations() {
        return allLocations;
    }

    public static void setAllLocations(List<Location> allLocations) {
        GameInfo.allLocations = allLocations;
    }

    @Override
    public String toString() {
        return "Default.GameInfo{" +
                "CurrentLocation='" + CurrentLocation + '\'' +
                ", CurrentState='" + CurrentState + '\'' +
                '}';
    }
}
