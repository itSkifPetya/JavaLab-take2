package domain;

import presentation.ShellPresenter;

public class Application {

    public Application() {

    }

    public void start() {
        optionHandler();
    }

    private void optionHandler() {
        ShellPresenter io = ShellPresenter.getInstanse();
        String opt;
        cycle:
        while (true) {
            io.put("Выберите режим работы:\ninteract - основное приложение\nadmin - инициализация датасета");
            opt = io.get("> ").toLowerCase();
            switch (opt) {
                case "interact" -> {
                    interactOpt(io);
                    break cycle;
                }
                case "admin" -> {
                    adminOpt(io);
                    break cycle;
                }
                default -> {
                    io.put("Ошибка ввода, попробуйте ещё раз!");
                }
            }
        }
    }

    private void interactOpt(ShellPresenter presenter) {
        System.out.println("Вы в интерактивном режиме");

    }

    private void adminOpt(ShellPresenter presenter) {
        System.out.println("Вы в админке");
    }



}
