package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import data.repository.local.CSVLocalRepository;
import domain.command.Command;

import java.util.Hashtable;

public class SaveCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        CSVLocalRepository repo = CSVLocalRepository.getInstance();
        repo.fileWriterInit(args[1]);
        repo.writeData(collection);
    }

    @Override
    public int getArgsCount() {
        return 1;
    }
}
