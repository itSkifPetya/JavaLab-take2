package domain.command;

import domain.command.commands.*;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private static Invoker instance;
    private Map<String, Command> commandMap = new HashMap<>();

    private Invoker() {

    }

    public static Invoker getInstance() {
        if (instance == null) {
            instance = new Invoker();
        }
        return instance;
    }

    public void invokerInit() {
        commandMap.put("help", new HelpCommand());
        commandMap.put("info", new InfoCommand());
        commandMap.put("show", new ShowCommand());
        commandMap.put("insert", new InsertCommand());
        commandMap.put("update", new UpdateCommand());
        commandMap.put("remove_key", new RemoveKeyCommand());
        commandMap.put("clear", new ClearCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("execute_script", new ExecuteScriptCommand());
        commandMap.put("exit", new ExitCommand());
        commandMap.put("history", new HistoryCommand());
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
