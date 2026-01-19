package command;

import Default.GameInfo;
import Default.LocationManager;
import locations.Location;

import java.util.Map;
import java.util.Scanner;

public class Move implements Command{

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Where do you want to go? For example: forward, west, backward, east.");
        System.out.print(">> ");
        String input = scanner.nextLine();
        String command = input.trim().toLowerCase();
        switch (command) {
            case "forward","west":

                for (Location location : LocationManager.getLocations()){
                    if (location.getName().equals(GameInfo.getCurrentLocation().getWest())){
                        GameInfo.setCurrentLocation(location);
                        return "You just moved to "+ GameInfo.getCurrentLocation().getDescription();
                    }

                }



                break;
            case "backward","","east":

                for (Location location : LocationManager.getLocations()){
                    if (location.getName().equals(GameInfo.getCurrentLocation().getEast())){
                        GameInfo.setCurrentLocation(location);
                        return "You just moved to "+ GameInfo.getCurrentLocation().getDescription();
                    }

                }
                break;
                //smi pouzivat pouze level hacker
            default:
                for (Location location : LocationManager.getLocations()){
                if (location.getName().equalsIgnoreCase(command)){
                    GameInfo.setCurrentLocation(location);
                    return "You just moved to "+ GameInfo.getCurrentLocation().getDescription();

                }

            }

        }


        return "You wrote it wrong";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
