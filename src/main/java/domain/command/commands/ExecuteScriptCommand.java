package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;
import domain.command.Invoker;
import presentation.ShellPresenter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {

    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        Invoker invoker = Invoker.getInstance();
        Map<String, Command> commandMap = invoker.getCommandMap();

        String filePath = args[1];
        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            String inp;
            while (scanner.hasNextLine()) {
                inp = scanner.nextLine();
                String[] inpArray = inp.split(" ");
                Command command = commandMap.get(inpArray[0]);
                if (command == null) {
                    io.put("Команда %s не распознана!".formatted(inpArray[0]));
                    continue;
                }
                if (command.getArgsCount() != inpArray.length-1) {
                    io.put("Команда %s не имеет аргументов или количество аргументов не совпадает".formatted(inpArray[0]));
                    return;
                }
                command.execute(collection, inpArray);

            }
        } catch (FileNotFoundException e) {
            io.put("Файл не найден!");
        }

    }

    @Override
    public int getArgsCount() {
        return 1;
    }
}
