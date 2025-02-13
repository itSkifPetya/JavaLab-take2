package domain.command;

import data.models.HumanBeingModel.HumanBeing;

import java.util.Hashtable;

public class Receiver {
    private static Receiver receiver;

    private Receiver() {}

    public static Receiver getReceiver() {
        if (receiver == null) {
            receiver = new Receiver();
        }
        return receiver;
    }

    public static Receiver getReceiver(Hashtable<Integer, HumanBeing> humanBeingHashtable) {
        if (receiver == null) {
            receiver = new Receiver();
        }
        return receiver;
    }

    public void help() {}
    public void info() {}
    public void show() {}
    public void insert(String key, HumanBeing element) {}
    public void update(int id, HumanBeing element) {}
    public void remove_key(String key) {}
    public void clear() {}
    public void save() {}
    public void execute_script(String fileName) {}
    public void exit() {}
    public void history() {}
    public void replace_if_greater(String key, HumanBeing element) {}
    public void remove_greater_key(String key) {}
    public void sum_of_impact_speed() {}
    public void min_by_soundtrack_name() {}
    public void group_counting_by_has_toothpick() {}
}
