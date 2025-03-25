package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.HistoryKeeper;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;
import java.util.Stack;

public class HistoryCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        HistoryKeeper historyKeeper = HistoryKeeper.getInstance();
        Stack<String> history = historyKeeper.getHistory();
        for (int i = 0; i <= 5; i++) {
            io.put(history.pop());
            history.removeLast();
        }

    }
}
