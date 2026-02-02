package command;

import Default.GameInfo;

import java.util.Scanner;

public class Speak implements Command{
    //todo
    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        if (GameInfo.getCurrentLocation().isCanSpeakWithNpc()){


            switch (GameInfo.getCurrentLocation().getName()){
                case "Castle":
                    System.out.println("You are talking with the King:");


                    return "";
                case "OldVillagersHouse":
                    System.out.println("You are talking with the Villager:");

                    return "";
                case "Ruin":
                    System.out.println("You are talking with the Traveller");

                    return "";
                case "FortPrincess":
                    System.out.println("You are talking with the Princess");

                    return "";
                case "Obchodnikuvdomecek":
                    System.out.println("You are talking with the Merchant");
                    return "";





            }


        }


        return "There is no one to talk to.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
