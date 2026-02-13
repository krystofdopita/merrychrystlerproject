package main.java.Default;

import com.fasterxml.jackson.databind.ObjectMapper;
import locations.Location;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
//loads locations from json file
public class LocationManager {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private static LinkedList<Location> locations;

    public LocationManager() {
    }

    public static LocationManager loadLocations(String jsonPath) {
        ObjectMapper parser = new ObjectMapper();
        InputStream input = LocationManager.class.getResourceAsStream(jsonPath);
        if(input == null) {
            throw new RuntimeException("Unable to load the game");
        }

        try(input){
           return  parser.readValue(input, LocationManager.class);
            /*System.out.println(roomManager.toString());*/

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
