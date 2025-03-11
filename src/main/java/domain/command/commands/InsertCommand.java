package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;

public class InsertCommand implements Command {
    private String key;
    private HumanBeing element;

    public InsertCommand(String key, HumanBeing element) {
        this.key = key;
        this.element = element;
    }
    @Override
    public void execute() {

    }
}
