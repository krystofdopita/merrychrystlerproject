package Default;

import command.*;

import java.util.HashMap;
import java.util.Scanner;

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

    public static HashMap<String, Command> getCommands() {
        return commands;
    }
}
