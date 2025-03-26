package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;

public class SumOfImpactSpeedCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        double sum = 0;
        for (HumanBeing h : collection.values()) {
            sum += h.getImpactSpeed();
        }
        io.put("Суммарная скорость в момент аварии по коллекции: %.2f".formatted(sum));
    }
}
