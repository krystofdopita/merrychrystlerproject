package command;

import Default.GameInfo;
import Default.LocationManager;
import Items.MapOfTheForest;
import Items.TravellersScroll;

import java.util.Random;
import java.util.Scanner;

public class UseItem implements Command{
    @Override
    public String execute() {
        System.out.println("Which item do you want to use?");
        System.out.println(Inventory.getInventory());
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase().trim().replace(" ","");
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
                                System.out.println("Your inventory looks like this now: "+ Inventory.getInventory());

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
