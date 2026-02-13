package main.java.command;


import command.Inventory;
import main.java.Default.Game;
import main.java.Default.GameInfo;

import Items.MapOfTheForest;
import Items.TravellersScroll;

import java.util.Random;
import java.util.Scanner;
//this class is for using items
public class UseItem implements Command{
    @Override
    public String execute() {
        System.out.println("Which item do you want to use?");
        System.out.println(Inventory.getInventory());
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase().trim().replace(" ","");
        //handles the inputs
        switch (input){
            case "mapoftheforest":
                if (Inventory.getInventory().contains("mapoftheforest")) {
                    return MapOfTheForest.getMapMT();
                }
                return "Map was not found";
            case "travellersscroll":if (Inventory.getInventory().contains("travellersscroll")) {
                return TravellersScroll.getMapTS();
            }return "Scroll was not found";
            case "shield":
                if (GameInfo.getCurrentLocation().isCanUseItem()&&Inventory.getInventory().contains("shield")) {
                    return "You have just used the shield to keep the door open.";}
                return "Shield was not found or you can not use it now.";

            case "key":
                //handles the final scene with the princess
                if (GameInfo.getCurrentLocation().getName().equalsIgnoreCase("FortPrincess")){

                    System.out.println("The seal fades.");
                    Game.jednaapul();
                    System.out.println("The princess steps forward.");
                    Game.jednaapul();

                    System.out.println();
                    System.out.println("\"The king erased your memory.\"");
                    Game.jednaapul();

                    System.out.println();
                    System.out.println("\"That is why you came without fear.\"");                    Game.jednaapul();

                    System.out.println("\"Without questions.\"");
                    Game.jednaapul();

                    System.out.println();
                    System.out.println("\"You were never meant to remember this tower.\"");                    Game.jednaapul();

                    System.out.println("\"Or me.\"");
                    Game.jednaapul();

                    System.out.println();
                    System.out.println("\"When we leave, he will try to erase you again.\"");                    Game.jednaapul();

                    System.out.println("\"But not fast enough.\"");                    Game.jednaapul();


                    System.out.println();
                    System.out.println("\"The truth does not need your memory.\"");                    Game.jednaapul();

                    System.out.println("\"It only needs you to bring me back.\"");                    Game.jednaapul();


                    System.out.println();
                    System.out.println("She turns toward the exit.");                    Game.jednaapul();

                    System.out.println("You follow her.");                    Game.jednaapul();
                    if (Inventory.getInventory().contains("heart")){
                        System.out.println("You have a choice:");
                        System.out.println("1: You give her the heart. ");
                        System.out.println("2: You do not give her the heart.");
                        input = sc.nextLine().toLowerCase().trim();
                        if (input.equals("1")){
                            System.out.println("Princess: Wow you gave me your heart.");Game.jednaapul();
                            System.out.println("Princess: You are the real SIGMA i have been waiting for.");Game.dvaapul();
                            if (Inventory.getInventory().contains("perryschild")){
                                System.out.println("Princess: And we even have a baby.");
                                Game.dvaapul();
                                Game.dvaapul();
                                Game.dvaapul();


                            }
                        }

                    }
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();

                        System.out.println("YOU WON");
                        Game.dvaapul();
                    System.exit(67);





                }
                //handles the castle puzzle mission
                if (GameInfo.getCurrentLocation().getName().equalsIgnoreCase("castle")&&Inventory.getInventory().contains("key")){


                    Scanner scanner = new Scanner(System.in);
                    Random random = new Random();

                    boolean lockOpened = false;
                    boolean waited = false;
                    int anger = 0;

                    System.out.println("A strange lock blocks the gate. It looks old... and alive.");
                    System.out.println("Type: use key, listen, touch lock, wait\n" +
                            "Hear him out, then use the key.");
                    int i =0;


                    while (!lockOpened) {
                        System.out.print("> ");
                        input = scanner.nextLine().toLowerCase().trim().replace(" ", "");


                        if (input.equals("usekey")) {
                            if (i>=3) {
                                System.out.println("The lock clicks, startled.");
                                System.out.println("Lock: ...You waited. Fine.");
                                lockOpened = true;
                                Inventory.getInventory().remove("key");
                                Inventory.getInventory().add("travellersscroll");


                            } else {
                                System.out.println("The lock rattles violently.");
                                System.out.println("Lock: Too early.");
                                anger++;
                            }
                        }

                        else if (input.equals("listen")) {
                                if (i==1){;System.out.println("If you’re looking for justice, try another century.");}
                               if (i==0){;System.out.println("Welcome back. Or… is this the first time? You’d never know, would you?");}
                                if (i==2){;System.out.println("At least if you die here, you won’t have to remember why you came.");}
                                    if (i==3){System.out.println("Some hosts are picky about who never leaves.");}
                                    if (i>=4){System.out.println("Try the key.");}
                            i++;
                        }

                        else if (input.equals("epstein")){

                            System.out.println("The lock clicks, startled.");
                            System.out.println("Lock: ...You waited. Fine.");
                            lockOpened = true;
                            Inventory.getInventory().remove("key");
                            Inventory.getInventory().add("travellersscroll");


                        }

                        else if (input.equals("touchlock")) {
                            System.out.println("The lock shivers.");
                            System.out.println("Lock: Do not touch me.");
                            anger++;
                        }

                        else if (input.equals("wait")) {
                            System.out.println("You wait. The courtyard falls silent.");
                        }

                        else {
                            System.out.println("The lock remains silent.");
                        }

                        if (anger >= 3 && !waited) {
                            System.out.println("Lock: You are trying too hard.");
                            System.out.println("Lock: Calm yourself.");
                        }
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("The gate opens.");
                    System.out.println("Behind it, you find the Travellers Scroll.");
                    System.out.println("Your inventory looks like this now: "+ Inventory.getInventory());


                    return "";




                }
                return "Key was not found or you can not use it now.";
            case "lantern":

                return "You are using your lantern already";

            default:return "Item was not found or you can not use it now.";
        }




    }

    @Override
    public boolean exit() {
        return false;
    }
}
