package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;
import domain.command.Receiver;

public class InsertCommand implements Command {
    private Receiver receiver = Receiver.getReceiver();
    private String key;
    private HumanBeing element;

    public InsertCommand(String key, HumanBeing element) {
        this.key = key;
        this.element = element;
    }
    @Override
    public void execute() {
        receiver.insert(key, element);
    }
}
