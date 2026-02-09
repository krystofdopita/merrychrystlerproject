package command;

import Default.Game;
import Default.GameInfo;
import characters.Princess;

import java.util.Random;
import java.util.Scanner;
//this class controls speaking with the characters
public class Speak implements Command{

    @Override
    public String execute() {
        Scanner scanner = new Scanner(System.in);
        if (GameInfo.getCurrentLocation().isCanSpeakWithNpc()){


            switch (GameInfo.getCurrentLocation().getName()){
                case "Castle":
                    System.out.println("You are talking with the King:");
                    System.out.println();
                    Game.jednaapul();
                    System.out.println("(The King stands over a map of the kingdom. When you enter, he does not turn.)");
                    Game.dvaapul();
                    System.out.println("King: I knew you would come.");
                    Game.jednaapul();
                    System.out.println();

                    System.out.println("1) Why am I here?");
                    System.out.println("2) What do you want from me?");
                    int choice = 0;


                    try {
                        choice = scanner.nextInt();
                    } catch (Exception e) {
                        return "Type 1 or 2";
                    }
                    Game.jednaapul();

                    if (choice == 1) {
                        System.out.println("King: The kingdom is falling apart. People are disappearing. And you are still useful.");
                        Game.dvaapul();
                    } else if (choice == 2) {
                        System.out.println("King: My daughter has been taken.");
                        Game.dvaapul();
                    }

                    System.out.println("King: She was brought to an ancient fortress beyond the Black Forest.");
                    Game.dvaapul();
                    System.out.println("King: No one I sent ever returned.");
                    Game.jednaapul();

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
                        Game.dvaapul();
                    } else if (choice2 == 2) {

                        System.out.println("King: Because you want to clear your name.");
                        Game.dvaapul();
                    }

                    System.out.println("King: Find the princess. Bring her back.");
                    Game.dvaapul();
                    System.out.println("King: I want nothing more from you.");
                    Game.dvaapul();

                    System.out.println("(The King turns back to the map.)");
                    Game.dvaapul();
                    System.out.println("King: Do not waste time on questions.");
                    Game.dvaapul();
                    System.out.println("King: Memories are not reliable.");
                    Game.dvaapul();
                    System.out.println();

                    System.out.println("King: Take this map — it will guide you where you are supposed to go.");Game.dvaapul();
                    Inventory.getInventory().add("mapoftheforest");
                    System.out.println("Your inventory looks like this now:"+ Inventory.getInventory());Game.jednaapul();
                    System.out.println("King: You will need a lantern, be sure to pick it up.");Game.dvaapul();
                    System.out.println("You can type pick item up to pick up the lantern.");
                    System.out.println("Type use item to look at the map.");
                    Game.dvaapul();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        System.out.println("King: Now go and find the princess."); Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "";
                case "OldVillagersHouse":
                    System.out.println("You are talking with the Villager:");Game.jednaapul();
                    //speaking with the villager if you dont have the herbs
                    if (Inventory.getInventory().contains("mapoftheforest")&&!Inventory.getInventory().contains("herbs")) {
                        System.out.println("(You approach an old villager sitting by the ruins of a house.)");Game.dvaapul();
                        System.out.println("Villager: Ah… I knew someone would come. Someone who can still change what is coming.");Game.dvaapul();
                        System.out.println();

                        System.out.println("Villager: The path ahead is dark and full of dangers. You will need a lantern to see through the forest.");Game.dvaapul();
                        System.out.println("Villager: And a sword, if you hope to survive the creatures that roam at night.");Game.dvaapul();
                        System.out.println();

                        System.out.println("Villager: I can help you… but first, you must return a step into the forest.");Game.dvaapul();
                        System.out.println("Villager: In the shadowed glade near the old well, gather the herbs that will prepare you for the journey.");Game.dvaapul();
                        System.out.println("Villager: Be careful, the forest isn’t as empty as it seems.");Game.dvaapul();
                        System.out.println();

                        System.out.println("1) I will go back and gather the herbs.");
                        System.out.println("2) I don't have time for this.");



                        try {
                            choice = scanner.nextInt();
                        } catch (Exception e) {
                            return "Type 1 or 2";
                        }

                        if (choice == 1) {
                            System.out.println("Villager: Good. Step carefully and return once you have them. Only then will I give you what you need.");Game.dvaapul();
                        } else if (choice == 2) {
                            System.out.println("Villager: Then do not expect my guidance. The road will be harder without it.");Game.dvaapul();
                        }

                    }
                    //speaking with the villager if you have the herbs
                    if (GameInfo.getCurrentLocation().getVisitCount() >= 2&&Inventory.getInventory().contains("herbs")) {

                        System.out.println("Villager: Have you found the herbs?");Game.dvaapul();
                        System.out.println("Will you give him the herbs. Y/N");
                        String input = scanner.nextLine().toLowerCase();
                        if (input.equals("y")) {
                            if (Inventory.getInventory().contains("herbs")) {
                                Inventory.getInventory().remove("herbs");

                                System.out.println("Villager: Well done. These herbs will help prepare you for what lies ahead.");Game.dvaapul();
                                System.out.println("Villager: As promised, take this small dagger. It may help you in dangerous encounters.");Game.dvaapul();
                                System.out.println("Villager: You gave me the herbs, so you can keep some of my potion. It will heal you if you’re in a fight.");Game.dvaapul();
                                Inventory.getInventory().add("dagger");
                                Inventory.getInventory().add("potion");
                                System.out.println("Villager: Step carefully, the forest watches all who pass through it.");Game.dvaapul();
                                System.out.println("Your inventory looks like this now:"+ Inventory.getInventory());Game.dvaapul();

                            }

                        }else {
                            System.out.println("Villager: Try to find the herbs.");

                        }


                    }

                    return "";
                    //speaking with the merchant
                    //you can have two different talks
                    case "Obchodnikuvdomecek":

                    System.out.println("You are talking with the Merchant");
                        Random rand = new Random();
                        int version = rand.nextInt(2);

                        if(version == 0) {

                            System.out.println("You are late. Or you are early. You used to argue about the time, and now you do not even notice it.");Game.dvaapul();
                            System.out.println("The funny thing is that you stand in the same way every time. It is as if you are waiting for something to remember you first. Perhaps you do, perhaps you do not.");Game.dvaapul();Game.dvaapul();
                            System.out.println("People tend to forget places. You tend to forget yourself. And yet, here you are, standing in front of me again.");Game.dvaapul();
                            System.out.println("I do not ask why anymore. It would be useless. The questions never seem to reach the right answers.");Game.dvaapul();
                            System.out.println("Some remember courage, some remember fear. You seem to remember both, or perhaps neither.");Game.dvaapul();
                            System.out.println("I watch people come and go, and yet you always find this place. It is almost predictable, in a way.");Game.dvaapul();
                            System.out.println("Take this shield. It is not much, but it is better than nothing. You might need it, even if you do not realize why yet.");Game.dvaapul();
                            System.out.println("You reached for the shield before I offered it. That worried me, but I suppose it is inevitable.");Game.dvaapul();
                            System.out.println("Try not to leave the shield behind again. You might need it sooner than you expect.");Game.dvaapul();
                            System.out.println("Remember, not everything that seems familiar is safe. And not everything that is safe seems familiar.");Game.dvaapul();
                            System.out.println("You can find the traveller if you go the same way you came here with.");
                        } else {

                            System.out.println("I remember you. That is the problem.");Game.jednaapul();
                            System.out.println("You came here with purpose once. Now you just come.");Game.dvaapul();
                            System.out.println("I thought it was fear. Then I thought it was courage.");Game.dvaapul();
                            System.out.println("Now I think it is habit.");Game.jednaapul();
                            System.out.println("You wander, asking questions, looking for answers that might not even exist.");Game.dvaapul();
                            System.out.println("The way you move… it feels familiar. As if you have done this many times, yet not exactly this way.");Game.dvaapul();
                            System.out.println("But it might slow things down long enough for you to notice.");Game.dvaapul();
                            System.out.println("I do not know if you will use it correctly. But you will use it, eventually.");Game.dvaapul();
                            System.out.println("Be careful. You are already walking in circles without realizing it.");Game.dvaapul();
                            System.out.println("Take this shield. It will not save you.");Game.jednaapul();
                            System.out.println("If you go forward you will find the traveller.");

                        }




                        Inventory.getInventory().add("shield");
                        System.out.println("Your inventory looks like this now: "+ Inventory.getInventory());Game.dvaapul();
                        return "";
                case "Ruin":
                    System.out.println("You are talking with the Traveller");
                    try {
                        System.out.println("Traveller: Welcome, the path ahead is dangerous. Only those who prove themselves worthy may proceed.");

                            Game.dvaapul();
                            System.out.println("Traveller: I possess a key that will grant access to a locked chamber within the castle.");
                        Game.dvaapul();                            System.out.println("Traveller: You must take it and return there swiftly. Many have tried and failed.");
                        Game.dvaapul();                            System.out.println("Traveller: Remember, hesitation could cost you everything. Choose your steps carefully.");
                        Game.dvaapul();
                            System.out.println();
                            System.out.println("How do you respond?");
                            System.out.println("1: I will not fail. I accept this challenge.");
                            System.out.println("2: I must prepare more before I go.");
                            System.out.println("3: Why should I trust you?");


                            System.out.print("> ");
                            String choice3 = scanner.nextLine();

                            if (choice3.equals("1")) {
                                System.out.println("Traveller: Good. Courage and decisiveness will serve you well. Take the key.");Game.dvaapul();
                            } else if (choice3.equals("2")) {
                                System.out.println("Traveller: Preparation is wise, but do not tarry too long. Take the key and go.");Game.dvaapul();
                            } else if (choice3.equals("3")) {
                                System.out.println("Traveller: Trust is earned in action. Take the key and prove yourself.");Game.dvaapul();
                            } else {
                                System.out.println("Traveller: Speak clearly, traveller. Take the key and do not waste time.");Game.dvaapul();
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
