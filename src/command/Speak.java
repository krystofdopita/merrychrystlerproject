package command;

import Default.GameInfo;

import java.util.Scanner;

public class Speak implements Command{

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        if (GameInfo.getCurrentLocation().isCanSpeakWithNpc()){


            switch (GameInfo.getCurrentLocation().getName()){
                case "Castle":
                    System.out.println("You are talking with the King:");
                    System.out.println();
                    System.out.println("(The King stands over a map of the kingdom. When you enter, he does not turn.)");
                    System.out.println("King: I knew you would come.");
                    System.out.println();

                    System.out.println("1) Why am I here?");
                    System.out.println("2) What do you want from me?");
                    int choice = 0;


                    try {
                        choice = scanner.nextInt();
                    } catch (Exception e) {
                        return "Type 1 or 2";
                    }

                    if (choice == 1) {
                        System.out.println("King: The kingdom is falling apart. People are disappearing. And you are still useful.");
                    } else if (choice == 2) {
                        System.out.println("King: My daughter has been taken.");
                    }

                    System.out.println("King: She was brought to an ancient fortress beyond the Black Forest.");
                    System.out.println("King: No one I sent ever returned.");

                    System.out.println("1) Why don't you send an army?");
                    System.out.println("2) Why should I help you?");


                    int choice2 = 0;
                    try {
                        choice2 = scanner.nextInt();
                    } catch (Exception e) {
                        return "Type 1 or 2";
                    }

                    if (choice2 == 1) {
                        System.out.println("King: The army failed. You did not.");
                    } else if (choice2 == 2) {
                        //todo threadsleep
                        System.out.println("King: Because you want to clear your name.");
                    }

                    System.out.println("King: Find the princess. Bring her back.");
                    System.out.println("King: I want nothing more from you.");

                    System.out.println("(The King turns back to the map.)");
                    System.out.println("King: Do not waste time on questions.");
                    System.out.println("King: Memories are not reliable.");

                    System.out.println();
                    ;
                    System.out.println("King: Take this map — it will guide you where you are supposed to go.");
                    Inventory.getInventory().add("mapoftheforest");
                    System.out.println("Your inventory looks like this now:"+ Inventory.getInventory());
                    System.out.println("King: You will need a lantern, be sure to pick it up.");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        System.out.println("King: Now go and find the princess."); Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "";
                case "OldVillagersHouse":
                    //todo threadsleep
                    System.out.println("You are talking with the Villager:");
                    if (GameInfo.getCurrentLocation().getVisitCount() == 1) {
                        System.out.println("(You approach an old villager sitting by the ruins of a house.)");
                        System.out.println("Villager: Ah… I knew someone would come. Someone who can still change what is coming.");
                        System.out.println();

                        System.out.println("Villager: The path ahead is dark and full of dangers. You will need a lantern to see through the forest.");
                        System.out.println("Villager: And a sword, if you hope to survive the creatures that roam at night.");
                        System.out.println();

                        System.out.println("Villager: I can help you… but first, you must return a step into the forest.");
                        System.out.println("Villager: In the shadowed glade near the old well, gather the herbs that will prepare you for the journey.");
                        System.out.println("Villager: Be careful, the forest isn’t as empty as it seems.");
                        System.out.println();

                        System.out.println("1) I will go back and gather the herbs.");
                        System.out.println("2) I don't have time for this.");



                        try {
                            choice = scanner.nextInt();
                        } catch (Exception e) {
                            return "Type 1 or 2";
                        }

                        if (choice == 1) {
                            System.out.println("Villager: Good. Step carefully and return once you have them. Only then will I give you what you need.");
                        } else if (choice == 2) {
                            System.out.println("Villager: Then do not expect my guidance. The road will be harder without it.");
                        }

                    }
                    if (GameInfo.getCurrentLocation().getVisitCount() >= 2&&Inventory.getInventory().contains("herbs")) {

                        System.out.println("Villager: Have you found the herbs?");
                        System.out.println("Will you give him the herbs. Y/N");
                        String input = scanner.nextLine().toLowerCase();
                        if (input.equals("y")) {
                            if (Inventory.getInventory().contains("herbs")) {
                                Inventory.getInventory().remove("herbs");

                                System.out.println("Villager: Well done. These herbs will help prepare you for what lies ahead.");
                                System.out.println("Villager: As promised, take this small dagger. It may help you in dangerous encounters.");
                                System.out.println("Villager: You gave me the herbs, so you can keep some of my potion. It will heal you if you’re in a fight.");
                                Inventory.getInventory().add("dagger");
                                Inventory.getInventory().add("potion");
                                System.out.println("Villager: Step carefully, the forest watches all who pass through it.");
                                System.out.println("Your inventory looks like this now:"+ Inventory.getInventory());

                            }

                        }else {
                            System.out.println("Villager: Try to find the herbs.");
                        }


                    }

                    return "";
                    case "Obchodnikuvdomecek":

                    System.out.println("You are talking with the Merchant");






                        return "";
                case "Ruin":
                    System.out.println("You are talking with the Traveller");
                    //todo speak traveller
                    try {
                        System.out.println("Traveller: Welcome, the path ahead is dangerous. Only those who prove themselves worthy may proceed.");

                            Thread.sleep(2500);

                            System.out.println("Traveller: I possess a key that will grant access to a locked chamber within the castle.");
                            Thread.sleep(2500);
                            System.out.println("Traveller: You must take it and return there swiftly. Many have tried and failed.");
                            Thread.sleep(2500);
                            System.out.println("Traveller: Remember, hesitation could cost you everything. Choose your steps carefully.");
                            Thread.sleep(2500);

                            System.out.println();
                            System.out.println("How do you respond?");
                            System.out.println("1: I will not fail. I accept this challenge.");
                            System.out.println("2: I must prepare more before I go.");
                            System.out.println("3: Why should I trust you?");


                            System.out.print("> ");
                            String choice3 = scanner.nextLine();

                            if (choice3.equals("1")) {
                                System.out.println("Traveller: Good. Courage and decisiveness will serve you well. Take the key.");
                            } else if (choice3.equals("2")) {
                                System.out.println("Traveller: Preparation is wise, but do not tarry too long. Take the key and go.");
                            } else if (choice3.equals("3")) {
                                System.out.println("Traveller: Trust is earned in action. Take the key and prove yourself.");
                            } else {
                                System.out.println("Traveller: Speak clearly, traveller. Take the key and do not waste time.");
                            }
                            Inventory.getInventory().add("key");
                            System.out.println("Your inventory looks like this now:" + Inventory.getInventory());
                            Thread.sleep(1500 * 2);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return "";
                case "FortPrincess":
                    System.out.println("You are talking with the Princess");
                    //todo speak princess


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
