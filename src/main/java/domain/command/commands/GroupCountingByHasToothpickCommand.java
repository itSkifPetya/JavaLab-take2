package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;

public class GroupCountingByHasToothpickCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        Hashtable<Integer, HumanBeing> hasToothpickCollection = new Hashtable<>();
        Hashtable<Integer, HumanBeing> hasNoToothpickCollection = new Hashtable<>();

        for (Integer k : collection.keySet()) {
            HumanBeing h = collection.get(k);
            if (h.getHasToothpick()) {
                hasToothpickCollection.put(k, h);
            } else {
                hasNoToothpickCollection.put(k, h);
            }
        }

        io.put("hasToothpick: true");
        io.put(hasToothpickCollection.toString());
        io.put("hasToothpick: false");
        io.put(hasNoToothpickCollection.toString());
    }
}
