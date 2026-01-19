package Default;

import locations.Location;

public class GameInfo {
    private static Location CurrentLocation;
    private static String CurrentState;


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

    @Override
    public String toString() {
        return "Default.GameInfo{" +
                "CurrentLocation='" + CurrentLocation + '\'' +
                ", CurrentState='" + CurrentState + '\'' +
                '}';
    }
}
