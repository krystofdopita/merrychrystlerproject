package command;

import Default.GameInfo;
import Default.LocationManager;
import locations.Location;

import java.util.Scanner;

public class Move implements Command{

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        if (Inventory.getInventory().isEmpty()){
            return "You don’t have a lantern, so you can’t move.\n";
        }
        System.out.println("Where do you want to go? For example: forward, west, backward, east.");
        System.out.print(">> ");
        String input = scanner.nextLine();
        String command = input.trim().toLowerCase();
        switch (command) {
            case "forward","west":

                for (Location location : LocationManager.getLocations()){
                    if (location.getName().equals(GameInfo.getCurrentLocation().getWest())){
                        GameInfo.setCurrentLocation(location);
                        GameInfo.getCurrentLocation().setVisitCount(GameInfo.getCurrentLocation().getVisitCount()+1);
                        return "You just moved to "+ GameInfo.getCurrentLocation().getDescription();
                    }

                }

                break;
            case "backward","","east":

                for (Location location : LocationManager.getLocations()){
                    if (location.getName().equals(GameInfo.getCurrentLocation().getEast())){
                        GameInfo.setCurrentLocation(location);
                        GameInfo.getCurrentLocation().setVisitCount(GameInfo.getCurrentLocation().getVisitCount()+1);
                        return "You just moved to "+ GameInfo.getCurrentLocation().getDescription() + GameInfo.getCurrentLocation().getVisitCount();
                    }

                }
                break;





        }


        return "You cannot move there.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
