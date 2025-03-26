package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;

public class RemoveGreaterKeyCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        Integer enteredKey = Integer.valueOf(args[1]);
        Hashtable<Integer, HumanBeing> oldCollection = (Hashtable<Integer, HumanBeing>) collection.clone();
        for (Integer key : oldCollection.keySet()) {
            if (enteredKey < key) {
                collection.remove(key);
            }
        }
        if (oldCollection.equals(collection)) {
            io.put("Таких элементов нет. Коллекция не была изменена");
        }
    }

    @Override
    public int getArgsCount() {
        return 1;
    }
}
