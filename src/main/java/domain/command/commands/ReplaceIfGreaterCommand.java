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
        HumanBeing homeBeing = collection.get(enteredKey);
        ShellPresenter io = ShellPresenter.getInstanse();

        if (homeBeing == null) {
            io.put("Элемент с таким ключам отсутствует в коллекции. Используйте insert (см help)");
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

        HumanBeing humanBeing;
        while (true) {
            impactSpeed = Double.parseDouble(io.get("Введите скорость в момент аварии (double) (определяющий параметр): "));
            if (homeBeing.getImpactSpeed() > impactSpeed) {
                io.put("Старое значение больше нового");
                return;
            }
            name = io.get("Введите имя: ");
            int coordX = Integer.parseInt(io.get("Введите X координату (int): "));
            double coordY = Double.parseDouble(io.get("Введите Y координату (double): "));
            coordinates = new Coordinates(coordX, coordY);
            realHero = Boolean.parseBoolean(io.get("Реальный герой (boolean)? "));
            hasToothpick = Boolean.parseBoolean(io.get("Есть зубочистка (boolean)? "));
            soundtrackName = io.get("Введите название трека: ");
            minutesOfWaiting = Long.parseLong(io.get("Введите время ожидания (long): "));
            weaponType = WeaponType.valueOf(io.get("Введите тип оружия: \nAXE\nPISTOL\nSHOTGUN\nMACHINE_GUN\nBAT\n"));
            car = new Car(Boolean.parseBoolean(io.get("Крутая машина (boolean)? ")));

            try {
                humanBeing = HumanBeing.insertHumanBeing(Integer.valueOf(args[1]), name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
                break;
            } catch (NullPointerException e) {
                io.put(e.getMessage());
            }
        }
        collection.put(humanBeing.getId(), humanBeing);
    }

    @Override
    public int getArgsCount() {
        return 1;
    }
}
