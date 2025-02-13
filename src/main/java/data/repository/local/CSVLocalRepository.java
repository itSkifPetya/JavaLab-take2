package data.repository.local;

import data.models.HumanBeingModel.HumanBeing;
import domain.DAO.HumanBeingRepo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class CSVLocalRepository implements HumanBeingRepo {
    private FileWriter fileWriter;
    private static CSVLocalRepository instance;
    private String fileName = "FileName";

    private CSVLocalRepository() {}
    // Реализация singleton класса
    public static CSVLocalRepository getInstance() {
        if (instance == null) {
            instance = new CSVLocalRepository();
        }
        return instance;
    }

    public void fileWriterInit(String name) {
        try {
            fileWriter = new FileWriter(name + ".csv");
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    @Override
    public void writeData(Hashtable<Integer, HumanBeing> humanBeings) {
        again:
        try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
            // TODO: ТУДУ ЁПТА, ТУТ НИЧЕ НЕ ГОТОВО
        } catch (NullPointerException | IOException e) {
            System.out.println(e);
            System.out.println(humanBeings);
            fileWriterInit(fileName);
            break again;
        }
    }

    @Override
    public Hashtable<Integer, HumanBeing> getData() {
        return null;
    }


}
