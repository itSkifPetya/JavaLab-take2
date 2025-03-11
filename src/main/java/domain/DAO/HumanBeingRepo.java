package domain.DAO;

import data.models.HumanBeingModel.HumanBeing;

import java.util.Hashtable;

public interface HumanBeingRepo { // получение данных из хранилища
    void writeData(Hashtable<Integer, HumanBeing> humanBeings);
    Hashtable<Integer, HumanBeing> getData(String filePath);
}
