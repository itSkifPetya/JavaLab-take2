package domain;

import java.util.ArrayList;
import java.util.Stack;

public class HistoryKeeper {
    private static HistoryKeeper instance;
    private Stack<String> history = new Stack<>();

    private HistoryKeeper() {}

    public static HistoryKeeper getInstance() {
        if (instance == null) {
            instance = new HistoryKeeper();
        }
        return instance;
    }

    public void add(String command) {
        history.push(command);
    }

    public Stack<String> getHistory() {
        return history;
    }
}
