package main.java.command;

public class Stop implements Command{
    //executes the logic for stopping the game
    @Override
    public String execute() {
        return "Goodbye my little sigma 67";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
