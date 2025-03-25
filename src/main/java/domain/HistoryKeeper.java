package domain;

import java.util.ArrayList;
import java.util.Stack;

public class HistoryKeeper {
    private static HistoryKeeper instance;
    private Stack<String> history;

    private HistoryKeeper() {}

    public static HistoryKeeper getInstance() {
        if (instance == null) {
            return new HistoryKeeper();
        } else {
            return instance;
        }
    }

    public void add(String command) {
        history.add(command);
    }

    public Stack<String> getHistory() {
        return history;
    }
}
