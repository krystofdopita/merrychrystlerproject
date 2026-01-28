package command;

import Default.GameInfo;
import Default.LocationManager;
import Items.MapOfTheForest;
import Items.TravellersScroll;

import java.util.Scanner;

public class UseItem implements Command{
    @Override
    public String execute() {
        System.out.println("Which item do you want to use?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        switch (input){
            case "mapoftheforest":
                if (Inventory.getInventory().contains("mapoftheforest")) {
                    return MapOfTheForest.getMapMT();
                }
            case "travellersscroll":if (Inventory.getInventory().contains("travellersscroll")) {
                return TravellersScroll.getMapTS();
            }
            case "shield":
                if (GameInfo.getCurrentLocation().isCanUseItem()&&Inventory.getInventory().contains("shield")) {return "You have just used the shield to keep the door open.";}
            case "lantern": return "You are already using your lantern.";        
        }



        return "You cannot use any items here.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
