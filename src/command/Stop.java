package command;

public class Stop implements Command{
    @Override
    public String execute() {
        return "goodbye";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
