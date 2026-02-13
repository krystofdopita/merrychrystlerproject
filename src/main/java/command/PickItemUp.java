package main.java.command;

import command.Inventory;
import main.java.Default.GameInfo;

public class PickItemUp implements Command{

    @Override
    public String execute() {
//executes the logic for picking item up from different locations
        if (!GameInfo.getCurrentLocation().getItems().isEmpty()){
            Inventory.getInventory().add(GameInfo.getCurrentLocation().getItems().get(0));
            GameInfo.getCurrentLocation().getItems().remove(0);


            return "Your inventory looks like this now:"+ Inventory.getInventory();
        }
        return "Item was not found.";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
