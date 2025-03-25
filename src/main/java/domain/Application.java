package domain;

import data.models.HumanBeingModel.HumanBeing;
import data.repository.local.CSVLocalRepository;
import domain.command.Command;
import domain.command.Invoker;
import presentation.ShellPresenter;

import java.util.Hashtable;
import java.util.Map;

public class Application {
    ShellPresenter io = ShellPresenter.getInstanse();
    Hashtable<Integer, HumanBeing> collection;
    CSVLocalRepository repo = CSVLocalRepository.getInstance();
    Invoker invoker = Invoker.getInstance();
    Map<String, Command> commandMap = invoker.getCommandMap();
    HistoryKeeper historyKeeper = HistoryKeeper.getInstance();

    public Application() {

    }

    public void start() {
//        optionHandler();
        interactOpt();
    }

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

    private void interactOpt() {
        invoker.invokerInit();

        io.put("Вы в интерактивном режиме! Перед началом работы введите путь к файлу коллекции:");
        String path = io.get("path: ");
        collection = repo.getData(path);
        io.put("Коллекция загружена! Начните с команды help");
        while (true) {
            String inp = io.get("> ");
            String[] inpArray = inp.split(" ");
            Command command = commandMap.get(inpArray[0]);
            historyKeeper.add(inpArray[0]);
            if (command.getArgsCount() != inpArray.length-1) {
                io.put("Команда не имеет аргументов или количество аргументов не совпадает");
                continue;
            }
            command.execute(collection, inpArray);

        }

    }

    private void adminOpt() {
        io.put("Вы в админке!");
        while (true) {

        }
    }
}
