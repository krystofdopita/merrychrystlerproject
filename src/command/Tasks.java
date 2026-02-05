package command;

import Default.GameInfo;
import Default.LocationManager;

public class Tasks implements Command{
    @Override
    public String execute() {
        if (!Inventory.getInventory().contains("mapoftheforest")){return "Type speak, to talk with the king.";}
        if (!Inventory.getInventory().contains("lantern")){return"Type pickitemup, to pick up the lantern.";}

        if (Inventory.getInventory().contains("travellersscroll")){
            return "Find the princess.";
        }
        if (GameInfo.getCurrentLocation().getName().equalsIgnoreCase("Castle")&&Inventory.getInventory().contains("key")){
            return "Use the key to unlock the chamber.";
        }
        if (Inventory.getInventory().contains("key")){
            return "Find the chamber in the castle.";
        }
        if (Inventory.getInventory().contains("shield")&&!Inventory.getInventory().contains("travellersscroll")){
            return "Have you met the Traveller? " + "You can talk with him.";
        }
        if (!Inventory.getInventory().contains("shield")&&Inventory.getInventory().contains("dagger")){
            return "Have you met the merchant? " + "You can talk with him.";
        }
        if (Inventory.getInventory().contains("herbs")){
            return "Speak with the villager and hand him the herbs.";
        }
        if (Inventory.getInventory().contains("mapoftheforest")){
            return "Try to find the villager and speak to him. "+ "Type move and go to the villager." +
                    "You can also check your map by typing use item.";
        }
        return "Find the villager";












    }

    @Override
    public boolean exit() {
        return false;
    }
}
