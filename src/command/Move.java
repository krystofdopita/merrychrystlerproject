package command;

import Default.GameInfo;
import Default.LocationManager;
import charactersBOSS.PerryThePlatypus;
import locations.Location;

import java.util.Scanner;

public class Move implements Command{

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        if (Inventory.getInventory().isEmpty()){
            return "You don’t have a lantern, so you can’t move.";
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
            case "backward","east":

                for (Location location : LocationManager.getLocations()){

                    if (location.getName().equals(GameInfo.getCurrentLocation().getEast())){
                        GameInfo.setCurrentLocation(location);
                        GameInfo.getCurrentLocation().setVisitCount(GameInfo.getCurrentLocation().getVisitCount()+1);
                        if (GameInfo.getCurrentLocation().getName().equalsIgnoreCase("Forest")&&Inventory.getInventory().contains("dagger")&&!Inventory.getInventory().contains("heart")){
                            System.out.println("You just moved to "+ GameInfo.getCurrentLocation().getDescription());
                            PerryThePlatypus.fightwithperry();
                            return "You won the fight";
                        }
                        if (Inventory.getInventory().contains("key")&&GameInfo.getCurrentLocation().getName().equalsIgnoreCase("Castle")){
                            try {

                                System.out.println("You reach the Castle Courtyard. At the far end, a sturdy locked gate awaits.");
                                Thread.sleep(1500);
                                return "";



                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }


                        }
                        return "You just moved to "+ GameInfo.getCurrentLocation().getDescription();
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
