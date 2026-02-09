package command;

import Default.Console;

public class Help implements Command{
    //this prints out all the commands
    @Override
    public String execute() {
        return Console.getCommands().keySet().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
