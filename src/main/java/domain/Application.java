package domain;

import data.models.HumanBeingModel.HumanBeing;
import data.repository.local.CSVLocalRepository;
import domain.command.Command;
import domain.command.Invoker;
import presentation.ShellPresenter;

import java.util.Hashtable;
import java.util.Map;

/**
 * Класс, отвечающий за приложение
 */
public class Application {
    ShellPresenter io = ShellPresenter.getInstanse();
    CSVLocalRepository repo = CSVLocalRepository.getInstance();
    Invoker invoker = Invoker.getInstance();
    Hashtable<Integer, HumanBeing> collection;
    Map<String, Command> commandMap = invoker.getCommandMap();
    HistoryKeeper historyKeeper = HistoryKeeper.getInstance();
    private static Application instance;

    private Application() {

    }

    /**
     * Реализация Singleton
     * @return
     */
    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    /**
     * Точка входа в программу
     */
    public void start() {
        interactOpt();
    }

    /**
     * Выбор опции
     */
    private void optionHandler() {
        String opt;
        cycle:
        while (true) {
            io.put("Выберите режим работы:\ninteract - основное приложение\nadmin - инициализация датасета");
            opt = io.get("> ").toLowerCase();
            switch (opt) {
                case "interact" -> {
                    interactOpt();
                    break cycle;
                }
                case "admin" -> {
                    adminOpt();
                    break cycle;
                }
                default -> {
                    io.put("Ошибка ввода, попробуйте ещё раз!");
                }
            }
        }
    }

    /**
     * Интерактивный режим
     */
    private void interactOpt() {
        invoker.invokerInit();
        io.put("Вы в интерактивном режиме! Перед началом работы введите путь к файлу коллекции:");
        String path = io.get("path: ");
//        String path = "text.csv"; //TODO: поменять на проде
        collection = repo.getData(path);
        io.put("Коллекция загружена! Начните с команды help");
        while (true) {
            String inp = io.get("> ");
            String[] inpArray = inp.split(" ");
            Command command = commandMap.get(inpArray[0]);
            if (command == null) {
                io.put("Команда %s не распознана!".formatted(inpArray[0]));
                continue;
            }
            historyKeeper.add(inpArray[0]);
            if (command.getArgsCount() != inpArray.length-1) {
                io.put("Команда %s не имеет аргументов или количество аргументов не совпадает".formatted(inpArray[0]));
                continue;
            }
            command.execute(collection, inpArray);

        }

    }

    /**
     * Режим админки
     */
    private void adminOpt() {
        io.put("Вы в админке!");
        while (true) {

        }
    }
}
