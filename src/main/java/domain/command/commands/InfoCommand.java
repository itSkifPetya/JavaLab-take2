package domain.command.commands;

import data.models.HumanBeingModel.Car;
import data.models.HumanBeingModel.Coordinates;
import data.models.HumanBeingModel.HumanBeing;
import data.models.HumanBeingModel.WeaponType;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;
import java.util.Iterator;

public class InfoCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        int collectionSize = collection.size();
        io.put("Количество элементов: " + Integer.toString(collectionSize));
        io.put("Тип коллекции" + collection.getClass().getName());
    }
}
