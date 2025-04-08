package domain.command;

import data.models.HumanBeingModel.HumanBeing;

import java.util.Hashtable;

/**
 * Интерфейс Команда. Часть реализации паттерна "Command"
 */
public interface Command {
    /**
     * Метод, запускающий выполнение команды, имплементирующей интерфейс
     * @param collection коллекция, с которой работает команда. Тип - Hashtable<Integer, HumanBeing>
     * @param args строковый массив, содержащий аргументы команды, если есть. В ином случае - пустой массив
     */
    void execute(Hashtable<Integer, HumanBeing> collection, String[] args);

    /**
     * Возвращает количество аргументов команды. При помощи данного метода происходит проверка наличия
     * аргументов у команды при распознавании
     * @return
     */
    default int getArgsCount() {
        return 0;
    }
}

