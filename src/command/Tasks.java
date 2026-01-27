package command;

import Default.LocationManager;

public class Tasks implements Command{
    @Override
    public String execute() {
        if (LocationManager.getLocations().get(5).getVisitCount() == 1){
            return "Find the princess.";
        }
        if(LocationManager.getLocations().get(4).getVisitCount() == 1){

            return "Have you met the traveler in this location?\n" +
                    "You can talk with him.";
        }
        if (LocationManager.getLocations().get(3).getVisitCount() == 1){

            return "Have you met the merchant in this location?\n" +
                    "You can talk with him.";
        }

        if (LocationManager.getLocations().get(2).getVisitCount() != 1){
            return "Try to find the villager.\n";


        }
    if (LocationManager.getLocations().get(2).getVisitCount() == 1){
        return "Have you already tried talking to the villager?\n";
    }






        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
