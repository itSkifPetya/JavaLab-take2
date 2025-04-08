package domain.command.commands;

import data.models.HumanBeingModel.Car;
import data.models.HumanBeingModel.Coordinates;
import data.models.HumanBeingModel.HumanBeing;
import data.models.HumanBeingModel.WeaponType;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;

public class ReplaceIfGreaterCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        Integer enteredKey = Integer.valueOf(args[1]);
        HumanBeing humanBeing1 = collection.get(enteredKey);
        ShellPresenter io = ShellPresenter.getInstanse();

        if (humanBeing1 == null) {
            io.put("Элемент с таким ключом отсутствует в коллекции. Используйте insert (см help)");
            return;
        }
        String name;
        Coordinates coordinates;
        Boolean realHero;
        Boolean hasToothpick;
        double impactSpeed;
        String soundtrackName;
        long minutesOfWaiting;
        WeaponType weaponType;
        Car car;

        // Переменные для хранения значений
        int coordX;
        double coordY;

        HumanBeing humanBeing;
        while (true) {
            try {
                // Ввод impactSpeed
                while (true) {
                    try {
                        impactSpeed = Double.parseDouble(io.get("Введите скорость в момент аварии (double) (определяющий параметр): "));
                        if (humanBeing1.getImpactSpeed() > impactSpeed) {
                            io.put("Старое значение больше нового");
                            return;
                        }
                        break; // Выход из цикла, если ввод корректен
                    } catch (NumberFormatException e) {
                        io.put("Ошибка: Введите число с плавающей точкой (double).");
                    }
                }

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
        collection.put(humanBeing.getId(), humanBeing);
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


    @Override
    public int getArgsCount() {
        return 1;
    }
}
