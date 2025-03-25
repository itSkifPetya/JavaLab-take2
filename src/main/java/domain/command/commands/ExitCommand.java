package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;

import java.util.Hashtable;

public class ExitCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        System.exit(0);
    }
}
