package Default;

import locations.Location;
import java.util.List;

public class GameInfo {
    private static Location CurrentLocation;

    private static List<Location> allLocations;



    public static Location getCurrentLocation() {
        return CurrentLocation;
    }

    public static void setCurrentLocation(Location currentLocation) {
        CurrentLocation = currentLocation;
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
                '}';
    }
}
