package domain.command;

public class CommandHandler {
    private static CommandHandler commandHandler;

    private CommandHandler() {}

    public static CommandHandler getCommandHandler() {
        if (commandHandler == null) {
            commandHandler = new CommandHandler();
        }
        return commandHandler;
    }
}
