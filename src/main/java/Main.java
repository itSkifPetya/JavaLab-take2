import data.models.HumanBeingModel.Car;
import data.models.HumanBeingModel.Coordinates;
import data.models.HumanBeingModel.HumanBeing;
import data.models.HumanBeingModel.WeaponType;

public class Main {

    public static void main(String[] args) {
        HumanBeing humanBeing = new HumanBeing("Alex", new Coordinates(100, 100), true, true, "Everybody Loves Me", WeaponType.SHOTGUN, new Car(true));


    }
}
