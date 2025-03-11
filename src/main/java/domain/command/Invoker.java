package domain.command;

public class Invoker {
    private static Invoker invoker;

    private Invoker() {}

    public static Invoker getCommandHandler() {
        if (invoker == null) {
            invoker = new Invoker();
        }
        return invoker;
    }
}
