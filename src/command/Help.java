package command;

import Default.Console;

public class Help implements Command{
    @Override
    public String execute() {
        return Console.getCommands().keySet().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
