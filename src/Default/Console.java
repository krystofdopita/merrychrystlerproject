package Default;

import command.Command;
import command.Move;
import command.Stop;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private HashMap<String, Command> commands;
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
    }

    public void execute() {
        while (!isExit) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String command = input.trim().toLowerCase();

            if (commands.containsKey(command)) {
                System.out.println(commands.get(command).execute());
                isExit = commands.get(command).exit();
            } else {
                System.out.println("Command is not recognized.");
            }
        }
        scanner.close();
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }
}
