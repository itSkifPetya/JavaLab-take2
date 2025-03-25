package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;

import java.util.Hashtable;

public class ExecuteScriptCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        // TODO: сделать!
    }

    @Override
    public int getArgsCount() {
        return 1;
    }
}
