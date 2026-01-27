package command;

public class Stop implements Command{
    @Override
    public String execute() {
        return "Goodbye my little sigma 67";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
