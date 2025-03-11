package presentation;

import presentation.presenterrequirements.Presenter;

import java.util.Scanner;

public class ShellPresenter implements Presenter {
    private static ShellPresenter shell;

    private ShellPresenter() {}

    public static ShellPresenter getInstanse() {
        if(shell == null) {
            shell = new ShellPresenter();
        }
        return shell;
    }

    @Override
    public void put(String msg) {
        System.out.println(msg);
    }

    @Override
    public String get() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public String get(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        return scanner.nextLine();
    }
}
