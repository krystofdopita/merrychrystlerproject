package command;

import Default.GameInfo;

public class Speak implements Command{
    //todo
    @Override
    public String execute() {
        if (GameInfo.getCurrentLocation().isCanSpeakWithNpc()){
            //todo text u postav

            return "67";

        }


        return "There is no one to talk to.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
