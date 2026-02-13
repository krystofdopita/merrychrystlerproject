package main.java.characters;


import command.Inventory;
import main.java.Default.Game;

import java.util.Scanner;

public class Princess {
//turns on the last mission
    public static void vez() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("You enter the tower. There are two floors.");

        // --- Floor 1 ---
        System.out.println("\n--- Floor 1 ---");
        System.out.println("The room has two paths: left and right.");
        System.out.println("Which path will you take? (left/right)");
        String path = scanner.nextLine().trim();

        boolean floor1MechanismActivated = false;

        if (path.equalsIgnoreCase("left")) {
            System.out.println("You chose the left path.");
            System.out.println("On the wall are ancient symbols. You must arrange them correctly to unlock the door to the next floor.");
            while (!floor1MechanismActivated) {
                System.out.println("Enter the correct order of symbols (e.g., 'sun moon star'):");
                String order = scanner.nextLine().trim().replace(" ","");
                if (order.equalsIgnoreCase("moonsunstar")) {
                    System.out.println("The symbols are arranged correctly! The door to the second floor is now unlocked.");
                    floor1MechanismActivated = true;
                } else {
                    System.out.println("Incorrect order. Try again.");
                }
            }

        }
        else if (path.equalsIgnoreCase("right")) {
            System.out.println("You chose the right path.");
            System.out.println("The room contains an old labyrinth with sliding blocks. Solve it to unlock the door to the next floor.");
            while (!floor1MechanismActivated) {
                System.out.println("Enter the correct block combination (e.g., 'up left right'):");
                String order = scanner.nextLine().trim().replace(" ","");
                if (order.equalsIgnoreCase("rightupleft")) {
                    System.out.println("The labyrinth is solved! The door to the second floor is now unlocked.");
                    floor1MechanismActivated = true;
                } else {
                    System.out.println("Wrong combination. Try again.");
                }
            }

        } else {
            System.out.println("Invalid choice. You automatically go left.");
            // loop for left path
            while (!floor1MechanismActivated) {
                System.out.println("Enter the correct order of symbols (e.g., 'sun moon star'):");
                String order = scanner.nextLine().trim().replace(" ","");
                if (order.equalsIgnoreCase("moonsunstar")) {
                    System.out.println("The symbols are arranged correctly! The door to the second floor is now unlocked.");
                    floor1MechanismActivated = true;
                } else {
                    System.out.println("Incorrect order. Try again.");
                }
            }
        }

        // --- Floor 2 ---
        System.out.println("\n--- Floor 2 ---");
        System.out.println("You enter the second floor. The princess is locked behind a magical barrier.");Game.dvaapul();
        System.out.println("You can see the key, but you tried to move forward."  );Game.dvaapul();
        System.out.println("But the mechanism closed the door with the key.");
        Game.dvaapul();
        System.out.println("If only you had something that would block the mechanism.");
        System.out.print(">> ");
        do {


        String input = scanner.nextLine().trim().toLowerCase().replace(" ","");
        if (input.equals("useitem")){
            System.out.println("Your inventory looks like this: "+ Inventory.getInventory());
            System.out.println("Which item do you want to use?");
            System.out.print(">> ");
            input = scanner.nextLine().trim().toLowerCase().replace(" ","");
            if (input.equals("shield")){
                Inventory.getInventory().remove("shield");
                System.out.println("It worked... You can pick the key up.");
                input = scanner.nextLine().trim().toLowerCase().replace(" ","");
                if (input.equals("pickitemup")){
                    Inventory.getInventory().add("key");
                    System.out.println("Your inventory looks like this now: "+ Inventory.getInventory());

                }


            }

        }else {
            System.out.println("Try again.");
        }
    }while (Inventory.getInventory().contains("shield"));






    }
    }


