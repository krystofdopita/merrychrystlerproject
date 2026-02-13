package main.java.Default;
import command.Inventory;





import main.java.command.Help;

import main.java.command.UseItem;
import  main.java.command.*;
import main.java.command.Move;
import main.java.command.SearchForItem;
import main.java.command.Speak;
import main.java.command.Stop;
import main.java.command.Tasks;
import main.java.command.Command;


import java.util.HashMap;
import java.util.Scanner;
/**
 * This class handles all the player's input.
 * It's like the main brain that decides what to do when the player types something.
 */
public class Console {
    private static HashMap<String, Command> commands;
    private boolean isExit;
    private Scanner scanner;

    public Console() {
        this.commands = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.isExit = false;
    }

    public void inicialization() {
        commands.put("move", new Move());
        commands.put("exit", new Stop());
        commands.put("tasks", new Tasks());
        commands.put("useitem",new UseItem());
        commands.put("pickitemup",new PickItemUp());
        commands.put("searchforitem",new SearchForItem());
        commands.put("speak",new Speak());
        commands.put("help",new Help());
        commands.put("inventory",new Inventory());

    }
//executing input
    public void execute() {
        while (!isExit) {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.print(">> ");
            String input = scanner.nextLine();
            String command = input.trim().toLowerCase().replace(" ","");

            if (commands.containsKey(command)) {
                System.out.println(commands.get(command).execute());
                isExit = commands.get(command).exit();
            } else {
                System.out.println("Command is not recognized.");
            }
        }
        scanner.close();
    }
//getter for commands
    public static HashMap<String, Command> getCommands() {
        return commands;
    }
}
