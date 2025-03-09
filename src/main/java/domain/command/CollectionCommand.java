package domain.command;

import data.models.HumanBeingModel.HumanBeing;

import java.util.Hashtable;

public interface CollectionCommand extends Command {
    void setCollection(Hashtable<Integer, HumanBeing> collection);
}
