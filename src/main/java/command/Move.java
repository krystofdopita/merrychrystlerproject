package main.java.command;

import command.Inventory;
import main.java.Default.Game;
import main.java.Default.GameInfo;
import main.java.Default.LocationManager;
import main.java.characters.Princess;
import main.java.charactersBOSS.PerryThePlatypus;
import locations.Location;

import java.util.Scanner;
//this class controls movement and some cutscenes and missions
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
                        //it turns on the mission to find the princess
                        if (GameInfo.getCurrentLocation().getName().equalsIgnoreCase("FortPrincess")){
                            Princess.vez();
                            return "";
                        }
                        //secret cutscene
                        if (Inventory.getInventory().contains("heart")&&GameInfo.getCurrentLocation().getName().equalsIgnoreCase("Ruin")&&!Inventory.getInventory().contains("perryschild")){
                            System.out.println("You step toward the ruins, the stone path cracking under your feet.");
                            Game.dvaapul();
                            System.out.println("The air grows heavy, unnaturally quiet.");
                            Game.jednaapul();
                            System.out.println("Then something moves ahead of you.");
                            Game.dvaapul();
                            System.out.println("From the shadows of the road, she steps forward.");
                            Game.dvaapul();
                            System.out.println("Perry’s partner.");
                            Game.jednaapul();
                            System.out.println("She does not block your way.");
                            Game.jednaapul();
                            System.out.println("She just stands there, looking at you, as if she already knows how this ends.");
                            Game.dvaapul();
                            System.out.println("Perry’s partner: You killed him and he will never get the chance to see his firstborn child.");
                            Game.dvaapul();

                            ;


                            System.out.println("Perry’s partner:He stood there every time.");Game.jednaapul();
                            System.out.println("Perry’s partner:Same place. Same silence.");
                            Game.jednaapul();
                            System.out.println("Perry’s partner: Waiting for someone who never remembered him.");
                            Game.jednaapul();
                            System.out.println("Perry’s partner: They called him a guardian.");
                            Game.jednaapul();

                            System.out.println("They never asked what he was guarding.");
                            Game.jednaapul();
                            System.out.println("You will walk past me now.");
                            Game.jednaapul();
                            System.out.println("You always do.");
                            Game.dvaapul();
                            System.out.println("And when you forget this moment, remember one thing.");
                            Game.dvaapul();
                            System.out.println("He did not choose this.");
                            Game.jednaapul();
                            System.out.println("Neither did you.");
                            Game.jednaapul();
                            System.out.println();
                            System.out.println("");
                            System.out.println("How do you respond?");
                            System.out.println("");
                            System.out.println("1. \"I did what I had to do.\"");
                            System.out.println("2. \"I do not remember him.\"");
                            System.out.println("3. Say nothing and walk past her.");
                            System.out.println("4. Act on your anger.");
                            System.out.println("");
                            System.out.print("Type your choice: ");

                            input = scanner.nextLine().trim();
                            System.out.println("");

                            if (input.equals("1")) {
                                System.out.println("She looks at you for a moment.");
                                System.out.println("\"That is what they always say,\" she replies quietly.");

                            } else if (input.equals("2")) {
                                System.out.println("She exhales slowly.");
                                System.out.println("\"Then they succeeded,\" she says.");

                            } else if (input.equals("3")) {
                                System.out.println("You say nothing and walk past her.");
                                System.out.println("She does not stop you.");

                            } else if (input.equals("4")) {
                                System.out.println("You take a step forward.");
                                System.out.println("The world seems to hesitate.");
                                System.out.println("");
                                Game.dvaapul();

                                System.out.println("You smashed it into oblivion.");
                                Inventory.getInventory().add("perryschild");
                                System.out.println("Your inventory now looks like this: "+ Inventory.getInventory());
                                Game.dvaapul();
                                Game.dvaapul();


                            } else {
                                System.out.println("She waits.");
                                System.out.println("Your silence stretches longer than intended.");
                            }




                        }
                        return "You just moved to "+ GameInfo.getCurrentLocation().getDescription();
                    }

                }

                break;
            case "backward","east","back":

                for (Location location : LocationManager.getLocations()){

                    if (location.getName().equals(GameInfo.getCurrentLocation().getEast())){
                        GameInfo.setCurrentLocation(location);
                        GameInfo.getCurrentLocation().setVisitCount(GameInfo.getCurrentLocation().getVisitCount()+1);
//secret cutscene with perry
                        if (GameInfo.getCurrentLocation().getName().equalsIgnoreCase("Forest")&&Inventory.getInventory().contains("dagger")&&!Inventory.getInventory().contains("heart")&&!Inventory.getInventory().contains("shield")){
                            System.out.println("You just moved to "+ GameInfo.getCurrentLocation().getDescription());
                            PerryThePlatypus.fightwithperry();
                            return "You won the fight";
                        }
                        //mission with the lock
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
