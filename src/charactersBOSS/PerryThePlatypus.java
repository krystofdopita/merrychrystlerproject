package charactersBOSS;
import Default.GameInfo;
import Default.LocationManager;
import command.Inventory;
import java.util.Random;
import java.util.Scanner;

public class PerryThePlatypus {




    public static void fightwithperry(){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        LocationManager.loadLocations("resources/map.json");
        GameInfo.setCurrentLocation(LocationManager.getLocations().get(2));

        boolean inPerryFight = true;
        int playerHP = 200;
        int perryHP = 200;
        boolean hasPotion = false;
        int strongSpamCounter = 0;
        if (Inventory.getInventory().contains("potion")){ hasPotion=true;}



        System.out.println("Suddenly, Perry the Platypus jumps in front of you, eyes gleaming and ready to attack.\n" +
                "“This is where it ends!” he growls.\n" +
                "Use your potion wisely – it might be the only thing that keeps you alive.\n" +
                "Type attack if you want to attack normally, strong if you want to do a strong attack.");
        System.out.println("Commands: ATTACK, STRONG, DEFEND" + (hasPotion ? ", HEAL" : ""));

        while (inPerryFight) {
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase();
            boolean defended = false;
            boolean strongMiss = false;
            if (command.equals("win")){
                System.out.println("You won the fight");
                Inventory.getInventory().add("heart");
                System.out.println("Your inventory looks like this now:"+ Inventory.getInventory());
               break;



            }

            if (command.equals("attack")) {
                strongSpamCounter = 0;
                int playerDamage = 15 + rand.nextInt(11);
                if (rand.nextInt(100) < 10) {
                    playerDamage *= 2;
                    System.out.println("Critical hit! Massive damage!");
                }

                boolean perryDefending = rand.nextInt(100) < 30;
                if (perryDefending) {
                    playerDamage /= 2;
                    System.out.println("Perry defends! Your attack is halved.");
                }

                perryHP -= playerDamage;
                System.out.println("You hit Perry for " + playerDamage + " damage.");

            } else if (command.equals("strong")) {
                strongSpamCounter++;
                int chance = 30 - (strongSpamCounter - 1) * 10;
                if (chance < 5) chance = 5;

                if (rand.nextInt(100) < chance) {
                    int playerDamage = 30 + rand.nextInt(11); // 30–40
                    System.out.println("Strong attack hits Perry for " + playerDamage + " damage!");
                    perryHP -= playerDamage;
                } else {
                    System.out.println("Strong attack missed! Perry gets a free strong attack!");
                    strongMiss = true;
                }

            } else if (command.equals("defend")) {
                strongSpamCounter = 0;
                defended = true;
                System.out.println("You brace yourself to reduce damage.");

            } else if (command.equals("heal")) {
                if (hasPotion) {
                    strongSpamCounter = 0;
                    int heal = 25 + rand.nextInt(11);
                    playerHP += heal;
                    hasPotion = false;
                    Inventory.getInventory().remove("potion");
                    System.out.println("You drink the potion and restore " + heal + " HP!");
                } else {
                    System.out.println("You don't have any potion!");
                    continue;
                }

            } else {
                System.out.println("Invalid command. Use ATTACK, STRONG, DEFEND" + (hasPotion ? ", HEAL" : ""));
                continue;
            }


            if (rand.nextInt(100) < 5) {
                int heal = 5 + rand.nextInt(6); // 5–10 HP
                playerHP += heal;
                System.out.println("You quickly patch yourself up! +" + heal + " HP.");
            }

            if (perryHP <= 0) {
                GameInfo.getCurrentLocation().getItems().add("heart");
                System.out.println("Perry falls. The path is clear.\n" +
                        "You picked up his heart");
                Inventory.getInventory().add("heart");
                System.out.println("Your inventory looks like this now:"+ Inventory.getInventory());
                GameInfo.setCurrentLocation(LocationManager.getLocations().get(1));

                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            if (!strongMiss) {
                int perryAction = rand.nextInt(100);

                if (perryAction < 25) {
                    System.out.println("Perry defends this turn!");
                } else if (perryAction < 40) {
                    int perryDamage = 30 + rand.nextInt(11); // special attack
                    playerHP -= perryDamage;
                    System.out.println("Perry uses a devastating special attack! " + perryDamage + " damage!");
                } else if (perryAction < 50) {
                    System.out.println("Perry hesitates this turn!");
                } else {
                    int perryDamage = 10 + rand.nextInt(11); // normal attack
                    if (defended) perryDamage /= 2;
                    playerHP -= perryDamage;
                    System.out.println("Perry attacks normally for " + perryDamage + " damage.");
                }
            }

            System.out.println("Your HP: " + playerHP + " | Perry HP: " + perryHP);

            if (playerHP <= 0) {
                System.out.println("You fall. Game over.");
                System.exit(67);

            }
        }
    }
}
