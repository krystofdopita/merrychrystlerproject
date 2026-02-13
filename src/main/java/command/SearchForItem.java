package main.java.command;

import main.java.Default.GameInfo;

public class SearchForItem implements Command{
//executes the logic for searching for items in different locations
    @Override
    public String execute() {

        if (!GameInfo.getCurrentLocation().getItems().isEmpty())
        return "Items found:"+ GameInfo.getCurrentLocation().getItems();
        return "Item was not found.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
