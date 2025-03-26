package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.HistoryKeeper;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class HistoryCommand implements Command {
    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        HistoryKeeper historyKeeper = HistoryKeeper.getInstance();
        Stack<String> history = historyKeeper.getHistory();
        // TODO: фиксить!! Это вообще гавно полное,
        //  тут всё будет ломаться, если история меньше 5 + она очищается
        if (history.isEmpty()) {
            io.put("История команд пуста.");
            return;
        }

        // Определяем, сколько команд выводить (не более 5)
        int hisLen = Math.min(history.size(), 5);

        // Создаём временный список для вывода
        List<String> lastCommands = new ArrayList<>();

        // Извлекаем последние 5 команд без удаления из стека
        for (int i = 0; i < hisLen; i++) {
            io.put(history.get(history.size() - 1 - i));
        }

    }
}
