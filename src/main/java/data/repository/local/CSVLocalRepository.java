package data.repository.local;

import data.models.HumanBeingModel.Car;
import data.models.HumanBeingModel.Coordinates;
import data.models.HumanBeingModel.HumanBeing;
import data.models.HumanBeingModel.WeaponType;
import domain.DAO.HumanBeingShellInit;
import domain.DAO.HumanBeingRepo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

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

    private ArrayList<String> humanBeingForm(Hashtable<Integer, HumanBeing> collection) {
        ArrayList<String> strCollection = new ArrayList<>();
//        String[] strCollection = new String[];
        collection.forEach((k, v) -> {
            strCollection.add(String.join(",", String.valueOf(k), v.getName(), String.valueOf(v.getCoordinates().getX()), String.valueOf(v.getCoordinates().getY()), v.getCreationDate().toString(), v.getRealHero().toString(), v.getHasToothpick().toString(), String.valueOf(v.getImpactSpeed()), v.getSoundtrackName(), String.valueOf(v.getMinutesOfWaiting()), v.getWeaponType().toString(), String.valueOf(v.getCar().getCool())));
        });
        return strCollection;
    }

    public void fileWriterInit(String filepath) {
        try {
            fileWriter = new FileWriter(filepath);
            fileWriter.write("id,name,coordX,coordY,creationDate,realHero,hasToothpick,impactSpeed,soundtrackName,miutesOfWaiting,weaponType,car\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
// id,name,coordX,coordY,creationDate,realHero,hasToothpick,impactSpeed,soundtrackName,miutesOfWaiting,weaponType,car

    @Override
    public void writeData(Hashtable<Integer, HumanBeing> collection) {
        again:
        try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
//            System.out.println(collection);
            ArrayList<String> strCollection = humanBeingForm(collection);
            for (String x : strCollection) {
                writer.write(x + "\n");
            }
        } catch (NullPointerException | IOException e) {
//            System.out.println(e);
//            System.out.println(collection);
            fileWriterInit(fileName);
//            break again;
        }
    }

// name,coordX,coordY,realHero,hasToothpick,impactSpeed,soundtrackName,minutesOfWaiting,weaponType,car

//    public HumanBeing writeData(String data) {
//
//    }


    @Override
    public Hashtable<Integer, HumanBeing> getData(String filePath) {
        Hashtable<Integer, HumanBeing> collection = new Hashtable<>();

        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            String line;
            boolean isHeader = true; // Флаг для пропуска заголовка

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                // Разделяем строку на поля
                String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Учитываем запятые внутри кавычек

                // Парсим поля
                Integer id = Integer.parseInt(fields[0]);
                String name = fields[1];
                int x = Integer.parseInt(fields[2]);
                double y = Double.parseDouble(fields[3]);
                LocalDate creationDate = LocalDate.parse(fields[4]);
                Boolean realHero = Boolean.parseBoolean(fields[5]);
                Boolean hasToothpick = Boolean.parseBoolean(fields[6]);
                double impactSpeed = Double.parseDouble(fields[7]);
                String soundtrackName = fields[8];
                long minutesOfWaiting = Long.parseLong(fields[9]);
                WeaponType weaponType = WeaponType.valueOf(fields[10]);
                Boolean carCool = fields[11].equals("null") ? null : Boolean.parseBoolean(fields[11]);

//                String name = fields[0];
//                int x = Integer.parseInt(fields[1]);
//                double y = Double.parseDouble(fields[2]);
//                LocalDate creationDate = LocalDate.parse(fields[4]);
//                Boolean realHero = Boolean.parseBoolean(fields[4]);
//                Boolean hasToothpick = Boolean.parseBoolean(fields[5]);
//                double impactSpeed = Double.parseDouble(fields[6]);
//                String soundtrackName = fields[7];
//                long minutesOfWaiting = Long.parseLong(fields[8]);
//                WeaponType weaponType = WeaponType.valueOf(fields[9]);
//                Boolean carCool = fields[10].equals("null") ? null : Boolean.parseBoolean(fields[11]);

                // Создаем вложенные объекты
                Coordinates coordinates = new Coordinates(x, y);
                Car car = (carCool != null) ? new Car(carCool) : null;

                // Создаем объект HumanBeing
                HumanBeing human = HumanBeing.parseHumanBeing(
                        id,
                        name,
                        coordinates,
                        creationDate,
                        realHero,
                        hasToothpick,
                        impactSpeed,
                        soundtrackName,
                        minutesOfWaiting,
                        weaponType,
                        car
                );

                // Добавляем в Hashtable
                collection.put(id, human);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        return collection;
    }

}
