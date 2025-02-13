package domain.command.commands;

import domain.command.Command;
import domain.command.Receiver;

public class ShowCommand implements Command {
    Receiver receiver = Receiver.getReceiver();

    @Override
    public void execute() {
        receiver.show();
    }
}
