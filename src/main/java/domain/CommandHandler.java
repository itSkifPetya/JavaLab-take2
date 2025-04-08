package domain;

import domain.command.Command;

import java.util.HashMap;

public class CommandHandler {
    private static CommandHandler instance;
    private HashMap<String, Command> commands = new HashMap<>(16);

    private CommandHandler() {}

    public static CommandHandler getInstance() {
        if (instance == null) {
            instance = new CommandHandler();
        }
        return instance;
    }

    public void handle(String cmd) {

    }
}
