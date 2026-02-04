package command;

import java.util.ArrayList;

public class Inventory implements Command{

    private static ArrayList<String> inventory = new ArrayList<>();


    public static ArrayList<String> getInventory() {
        return inventory;
    }

    public static void setInventory(ArrayList<String> inventory) {
        Inventory.inventory = inventory;
    }

    @Override
    public String execute() {
        return Inventory.getInventory().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
