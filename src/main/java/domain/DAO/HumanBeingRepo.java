package domain.DAO;

import data.models.HumanBeingModel.HumanBeing;

import java.util.Hashtable;

public interface HumanBeingRepo { // получение данных из хранилища
    void writeData(Hashtable<Integer, HumanBeing> humanBeings);
    Hashtable<Integer, HumanBeing> getData();


//    String info(Hashtable<String, HumanBeing> humanBeings);
//    String show(Hashtable<String, HumanBeing> humanBeings);
//    void insert(int id, HumanBeing humanBeing);
//    void update(int id, HumanBeing humanBeing);
//    void remove_key(String key);
//    void clear();

}
