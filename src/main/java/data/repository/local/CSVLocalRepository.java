package data.repository.local;

import data.models.HumanBeingModel.Car;
import data.models.HumanBeingModel.Coordinates;
import data.models.HumanBeingModel.HumanBeing;
import data.models.HumanBeingModel.WeaponType;
import domain.DAO.HumanBeingShellInit;
import domain.DAO.HumanBeingRepo;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Реализация репозитория HumanBeing для локального хранения данных
 */
public class CSVLocalRepository implements HumanBeingRepo {
    private FileWriter fileWriter;
    private static CSVLocalRepository instance;
    private String fileName = "FileName";

    private CSVLocalRepository() {}

    /**
     * Реализация singleton класса
     * @return
     */
    public static CSVLocalRepository getInstance() {
        if (instance == null) {
            instance = new CSVLocalRepository();
        }
        return instance;
    }

    /**
     * Возвращает массив строк, содержащих поля элементов переданной коллекции
     * @param collection коллекция Hastable из Integer и HumanBeing.
     * @return массив строк
     */
    private ArrayList<String> humanBeingForm(Hashtable<Integer, HumanBeing> collection) {
        ArrayList<String> strCollection = new ArrayList<>();
//        String[] strCollection = new String[];
        collection.forEach((k, v) -> {
            strCollection.add(String.join(",", String.valueOf(k), v.getName(), String.valueOf(v.getCoordinates().getX()), String.valueOf(v.getCoordinates().getY()), v.getCreationDate().toString(), v.getRealHero().toString(), v.getHasToothpick().toString(), String.valueOf(v.getImpactSpeed()), v.getSoundtrackName(), String.valueOf(v.getMinutesOfWaiting()), v.getWeaponType().toString(), String.valueOf(v.getCar().getCool())));
        });
        return strCollection;
    }

    /**
     * Инициализация FileWriter
     * @param filepath имя файла, из которого получаем данные для коллекции
     */
    public void fileWriterInit(String filepath) {
        try {
            fileWriter = new FileWriter(filepath);
            fileWriter.write("id,name,coordX,coordY,creationDate,realHero,hasToothpick,impactSpeed,soundtrackName,miutesOfWaiting,weaponType,car\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
// id,name,coordX,coordY,creationDate,realHero,hasToothpick,impactSpeed,soundtrackName,miutesOfWaiting,weaponType,car

    /**
     * Запись коллекции в файл
     * @param collection коллекция Hastable из Integer и HumanBeing.
     */
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


//    @Override
//    public Hashtable<Integer, HumanBeing> getData(String filePath) {
//        Hashtable<Integer, HumanBeing> collection = new Hashtable<>();
//
//        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
//            String line;
//            boolean isHeader = true; // Флаг для пропуска заголовка
//
//            while (scanner.hasNextLine()) {
//                line = scanner.nextLine();
//                if (isHeader) {
//                    isHeader = false;
//                    continue;
//                }
//
//                // Разделяем строку на поля
//                String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1); // Учитываем запятые внутри кавычек
//                if (fields.length < 10) {
//                    return null;
//                }
//                // Парсим поля
////                Integer id = Integer.parseInt(fields[0]);
//                String name = fields[1];
//                int x = Integer.parseInt(fields[2]);
//                double y = Double.parseDouble(fields[3]);
////                LocalDate creationDate = LocalDate.parse(fields[4]);
//                Boolean realHero = Boolean.parseBoolean(fields[5]);
//                Boolean hasToothpick = Boolean.parseBoolean(fields[6]);
//                double impactSpeed = Double.parseDouble(fields[7]);
//                String soundtrackName = fields[8];
//                long minutesOfWaiting = Long.parseLong(fields[9]);
//                WeaponType weaponType = WeaponType.valueOf(fields[10]);
//                Boolean carCool = fields[11].equals("null") ? null : Boolean.parseBoolean(fields[11]);
//
////                String name = fields[0];
////                int x = Integer.parseInt(fields[1]);
////                double y = Double.parseDouble(fields[2]);
////                LocalDate creationDate = LocalDate.parse(fields[4]);
////                Boolean realHero = Boolean.parseBoolean(fields[4]);
////                Boolean hasToothpick = Boolean.parseBoolean(fields[5]);
////                double impactSpeed = Double.parseDouble(fields[6]);
////                String soundtrackName = fields[7];
////                long minutesOfWaiting = Long.parseLong(fields[8]);
////                WeaponType weaponType = WeaponType.valueOf(fields[9]);
////                Boolean carCool = fields[10].equals("null") ? null : Boolean.parseBoolean(fields[11]);
//
//                // Создаем вложенные объекты
//                Coordinates coordinates = new Coordinates(x, y);
//                Car car = (carCool != null) ? new Car(carCool) : null;
//
//                // Создаем объект HumanBeing
//                HumanBeing human = new HumanBeing(
//                        name,
//                        coordinates,
//                        realHero,
//                        hasToothpick,
//                        impactSpeed,
//                        soundtrackName,
//                        minutesOfWaiting,
//                        weaponType,
//                        car
//                );
//
//                // Добавляем в Hashtable
//                collection.put(human.getId(), human);
//            }
//        } catch (NullPointerException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.err.println("Ошибка чтения файла: " + e.getMessage());
//        }
//
//        return collection;
//    }

    /**
     * Получение данных из файла и парсинг
     * @param filePath путь к файлу
     * @return коллекция типа Hastable
     */
    @Override
    public Hashtable<Integer, HumanBeing> getData(String filePath) {
        Hashtable<Integer, HumanBeing> collection = new Hashtable<>();

        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
                if (line.isEmpty() || isHeader) {
                    isHeader = false;
                    continue;
                }

                String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (fields.length != 12) { // Проверяем количество полей
                    System.err.println("Ошибка: неверное количество полей в строке: " + line);
                    return null;
                }

                try {
                    // Валидация и парсинг каждого поля
                    int id = validateAndParseInt(fields[0], "ID");
                    String name = validateString(fields[1], "Name");
                    int x = validateAndParseInt(fields[2], "Coordinate X");
                    double y = validateAndParseDouble(fields[3], "Coordinate Y");
                    LocalDate creationDate = validateAndParseDate(fields[4], "Creation Date");
                    boolean realHero = validateAndParseBoolean(fields[5], "Real Hero");
                    boolean hasToothpick = validateAndParseBoolean(fields[6], "Has Toothpick");
                    double impactSpeed = validateAndParseDouble(fields[7], "Impact Speed");
                    String soundtrackName = validateString(fields[8], "Soundtrack Name");
                    long minutesOfWaiting = validateAndParseLong(fields[9], "Minutes of Waiting");
                    WeaponType weaponType = validateAndParseWeaponType(fields[10], "Weapon Type");
                    Boolean carCool = validateNullableBoolean(fields[11], "Car");

                    // Создание объектов
                    Coordinates coordinates = new Coordinates(x, y);
                    Car car = (carCool != null) ? new Car(carCool) : null;

                    HumanBeing human = new HumanBeing(
                            name, coordinates, realHero, hasToothpick,
                            impactSpeed, soundtrackName, minutesOfWaiting,
                            weaponType, car
                    );
                    collection.put(id, human);

                } catch (ValidationException e) {
                    System.err.println("Ошибка в строке: " + line + " | " + e.getMessage());
                    return null;
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return null;
        }

        return collection.isEmpty() ? null : collection; // Возвращаем null если коллекция пуста
    }

    //--- Вспомогательные методы валидации ---
    private static int validateAndParseInt(String value, String fieldName) throws ValidationException {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new ValidationException(fieldName + " должно быть целым числом");
        }
    }

    private static double validateAndParseDouble(String value, String fieldName) throws ValidationException {
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            throw new ValidationException(fieldName + " должно быть числом с плавающей точкой");
        }
    }

    private static LocalDate validateAndParseDate(String value, String fieldName) throws ValidationException {
        try {
            return LocalDate.parse(value.trim());
        } catch (DateTimeParseException e) {
            throw new ValidationException(fieldName + " должно быть в формате YYYY-MM-DD");
        }
    }

    private static boolean validateAndParseBoolean(String value, String fieldName) throws ValidationException {
        String trimmed = value.trim();
        if (!trimmed.equalsIgnoreCase("true") && !trimmed.equalsIgnoreCase("false")) {
            throw new ValidationException(fieldName + " должно быть 'true' или 'false'");
        }
        return Boolean.parseBoolean(trimmed);
    }

    private static WeaponType validateAndParseWeaponType(String value, String fieldName) throws ValidationException {
        try {
            return WeaponType.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ValidationException(fieldName + " содержит недопустимое значение. Допустимые: " + Arrays.toString(WeaponType.values()));
        }
    }

    private static Boolean validateNullableBoolean(String value, String fieldName) throws ValidationException {
        String trimmed = value.trim();
        if (trimmed.equalsIgnoreCase("null")) return null;
        return validateAndParseBoolean(value, fieldName);
    }

    private static String validateString(String value, String fieldName) throws ValidationException {
        if (value.trim().isEmpty()) {
            throw new ValidationException(fieldName + " не может быть пустым");
        }
        return value.trim();
    }

    /**
     * Валидирует и парсит строку в long
     * @param value строка для парсинга
     * @param fieldName название поля для сообщения об ошибке
     * @return распарсенное значение
     * @throws ValidationException если значение невалидно
     */
    private static long validateAndParseLong(String value, String fieldName) throws ValidationException {
        try {
            return Long.parseLong(value.trim());
        } catch (NumberFormatException e) {
            throw new ValidationException(fieldName + " должно быть целым числом (long)");
        }
    }

    // Кастомное исключение для валидации
    private static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }

}
