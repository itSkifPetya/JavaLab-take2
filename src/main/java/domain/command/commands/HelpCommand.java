package domain.command.commands;

import data.models.HumanBeingModel.HumanBeing;
import domain.command.Command;
import presentation.ShellPresenter;

import java.util.Hashtable;

public class HelpCommand implements Command {

    @Override
    public void execute(Hashtable<Integer, HumanBeing> collection, String[] args) {
        ShellPresenter io = ShellPresenter.getInstanse();
        io.put("help: вывести справку по доступным командам");
        io.put("info: информация о коллекции");
        io.put("show: вывести коллекцию");
        io.put("insert {key}: добавить элемент по ключу");
        io.put("update {id}: обновить элемент по его id");
        io.put("remove_key {key}: удалить элемент из коллекции по его ключу");
        io.put("clear: очистить коллекцию");
        io.put("save {file_path}: сохранить коллекцию в файл");
        io.put("execute_script {file_path}: выполнить скрипт");
        io.put("exit: завершить программу без сохранения");
        io.put("history: вывести последние 5 команд");
        io.put("replace_if_greater {key}: заменить элемент по ключу, если новый больше старого");
        io.put("remove_greater_key {key}: удалить все элементы, ключ которых превышает данный");
        io.put("sum_of_impact_speed: вывести сумму значений поля impactSpeed для всех элементов коллекции");
        io.put("min_by_soundtrack_name: вывести любой элемент коллекции с минимальным полему soundtrackName");
        io.put("group_counting_by_has_toothpick: сгруппировать элементы коллекции по значению поля hasToothpick, вывести количество элементов в каждой группе");

    }
}



//public class Meow{
//    String cat;
//
//    public Meow(String cat){
//        this.cat = cat;
//    }
//
//    public String getCat() {
//        return cat;
//    }
//
//    public static void meow(){
//        System.out.println(cat + " say " + meeeeeow);
//    }
//}
//

