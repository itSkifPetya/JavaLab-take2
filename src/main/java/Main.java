import data.repository.local.CSVLocalRepository;
import domain.Application;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        CSVLocalRepository repo = CSVLocalRepository.getInstance();
//        HumanBeing humanBeing = new HumanBeing("Alex", new Coordinates(1, 1), true, true, 100., "Everybody loves me", 100L, WeaponType.SHOTGUN, new Car(true));
//        Hashtable<Integer, HumanBeing> collection = new Hashtable<>();
//        collection.put(humanBeing.getId(), humanBeing);
//        repo.fileWriterInit("test");
//        // Запись в файл работает
//        repo.writeData(collection);
//        // Парсинг работает
//        System.out.println(repo.getData("test.csv"));
        Application app = Application.getInstance();
        app.start();
//        Scanner sc = new Scanner(System.in);
//        var data = sc.nextLine();
//        repo.fileWriterInit("inp1");
//        repo.writeData(data);

    }

}
