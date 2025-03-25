package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;

public class ShowCommand implements Command {

    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        if (collection.isEmpty()) {
            io.put("Коллекция не содержит элементов.");
        } else {
            for (Integer key : collection.keySet()) {
                io.put(key.toString() + ": ");
                io.put(collection.get(key).toString());
            }
        }
    }
}
