package main.java.Default;

import com.fasterxml.jackson.databind.ObjectMapper;
import locations.Location;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
//loads locations from json file
public class LocationManager {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private static LinkedList<Location> locations;

    public LocationManager() {
    }

    public static LocationManager loadLocations(String jsonPath) {

        try {

            final InputStream is = new FileInputStream(jsonPath);

            return objectMapper.readValue(is, LocationManager.class);

        } catch (Exception e) {
            System.err.println(jsonPath);
            throw new RuntimeException(e);
        }
    }

    public static LinkedList<Location> getLocations() {
        return locations;
    }

    public void setLocations(LinkedList<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Default.LocationManager{" +
                "locations=" + locations +
                '}';
    }
}
