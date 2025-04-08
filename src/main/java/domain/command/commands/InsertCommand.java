package domain.command.commands;

import data.models.HumanBeingModel.Car;
import data.models.HumanBeingModel.Coordinates;
import data.models.HumanBeingModel.HumanBeing;
import data.models.HumanBeingModel.WeaponType;
import data.repository.local.CSVLocalRepository;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;

public class InsertCommand implements Command {

    @Override
    public int getArgsCount() {
        return 1;
    }

    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();

        String name;
        Coordinates coordinates;
        Boolean realHero;
        Boolean hasToothpick;
        double impactSpeed;
        String soundtrackName;
        long minutesOfWaiting;
        WeaponType weaponType;
        Car car;

        HumanBeing humanBeing;

        // Переменные для хранения значений
        int coordX = 0;
        double coordY = 0.0;

        while (true) {
            try {
                // Ввод имени
                name = io.get("Введите имя: ");
                if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Имя не может быть пустым.");
                }
                // Ввод X координаты
                while (true) {
                    try {
                        coordX = Integer.parseInt(io.get("Введите X координату (int): "));
                        break; // Выход из цикла, если ввод корректен
                    } catch (NumberFormatException e) {
                        io.put("Ошибка: Введите целое число (int).");
                    }
                }

                // Ввод Y координаты
                while (true) {
                    try {
                        coordY = Double.parseDouble(io.get("Введите Y координату (double): "));
                        break; // Выход из цикла, если ввод корректен
                    } catch (NumberFormatException e) {
                        io.put("Ошибка: Введите число с плавающей точкой (double).");
                    }
                }

                // Создание объекта Coordinates
                coordinates = new Coordinates(coordX, coordY);

                // Ввод realHero
                realHero = readBoolean(io, "Реальный герой (boolean)? (true/false): ");


                // Ввод hasToothpick
                hasToothpick = readBoolean(io, "Есть зубочистка (boolean)? (true/false): ");


                // Ввод impactSpeed
                while (true) {
                    try {
                        impactSpeed = Double.parseDouble(io.get("Введите скорость в момент аварии (double): "));
                        break; // Выход из цикла, если ввод корректен
                    } catch (NumberFormatException e) {
                        io.put("Ошибка: Введите число с плавающей точкой (double).");
                    }
                }

                // Ввод soundtrackName
                soundtrackName = io.get("Введите название трека: ");
                if (soundtrackName == null || soundtrackName.trim().isEmpty()) {
                    throw new IllegalArgumentException("Название трека не может быть пустым.");
                }

                // Ввод minutesOfWaiting
                while (true) {
                    try {
                        minutesOfWaiting = Long.parseLong(io.get("Введите время ожидания (long): "));
                        break; // Выход из цикла, если ввод корректен
                    } catch (NumberFormatException e) {
                        io.put("Ошибка: Введите целое число (long).");
                    }
                }

                // Ввод weaponType
                while (true) {
                    try {
                        weaponType = WeaponType.valueOf(io.get("Введите тип оружия: \nAXE\nPISTOL\nSHOTGUN\nMACHINE_GUN\nBAT\n"));
                        break; // Выход из цикла, если ввод корректен
                    } catch (IllegalArgumentException e) {
                        io.put("Ошибка: Введите один из доступных типов оружия.");
                    }
                }

                // Ввод car
                car = new Car(readBoolean(io, "Крутая машина (boolean)? (true/false): "));

                // Создание объекта HumanBeing
                humanBeing = HumanBeing.insertHumanBeing(Integer.valueOf(args[1]), name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
                break; // Выход из основного цикла

            } catch (NullPointerException | IllegalArgumentException e) {
                io.put(e.getMessage());
            }
        }

        // Добавление элемента в коллекцию
        if (collection.get(humanBeing.getId()) == null) {
            collection.put(humanBeing.getId(), humanBeing);
        } else {
            io.put("Элемент с id %s уже существует. Измените или воспользуйтесь командой update (см help)".formatted(humanBeing.getId()));
        }
    }

    private boolean readBoolean(ShellPresenter io, String prompt) {
        while (true) {
            String input = io.get(prompt).toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            io.put("Ошибка: введите 'true' или 'false'");
        }
    }

//    @Override
//    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
//        ShellPresenter io = ShellPresenter.getInstanse();
//
//        String name;
//        Coordinates coordinates;
//        Boolean realHero;
//        Boolean hasToothpick;
//        double impactSpeed;
//        String soundtrackName;
//        long minutesOfWaiting;
//        WeaponType weaponType;
//        Car car;
//
//        HumanBeing humanBeing;
//        while (true) {
//            name = io.get("Введите имя: ");
//            int coordX = Integer.parseInt(io.get("Введите X координату (int): "));
//            double coordY = Double.parseDouble(io.get("Введите Y координату (double): "));
//            coordinates = new Coordinates(coordX, coordY);
//            realHero = Boolean.parseBoolean(io.get("Реальный герой (boolean)? "));
//            hasToothpick = Boolean.parseBoolean(io.get("Есть зубочистка (boolean)? "));
//            impactSpeed = Double.parseDouble(io.get("Введите скорость в момент аварии (double): "));
//            soundtrackName = io.get("Введите название трека: ");
//            minutesOfWaiting = Long.parseLong(io.get("Введите время ожидания (long): "));
//            weaponType = WeaponType.valueOf(io.get("Введите тип оружия: \nAXE\nPISTOL\nSHOTGUN\nMACHINE_GUN\nBAT\n"));
//            car = new Car(Boolean.parseBoolean(io.get("Крутая машина (boolean)? ")));
//
//            try {
//                humanBeing = HumanBeing.insertHumanBeing(Integer.valueOf(args[1]), name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
//                break;
//            } catch (NullPointerException e) {
//                io.put(e.getMessage());
//            }
//        }
//        if (collection.get(humanBeing.getId()) == null) {
//            collection.put(humanBeing.getId(), humanBeing);
//        } else {
//            io.put("Элемент с id %s уже существует. Измените или воспользуйтесь командой update (см help)".formatted(humanBeing.getId()));
//        }
//    }
}


