package domain.command;

import data.models.HumanBeingModel.HumanBeing;

import java.util.Hashtable;

public interface Command {
    void execute(Hashtable<Integer, HumanBeing> collection, String[] args);

    default int getArgsCount() {
        return 0;
    }
}

