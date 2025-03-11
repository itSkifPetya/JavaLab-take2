package data.models.HumanBeingModel;

public class Car {
    private Boolean cool; //Поле не может быть null

    public Car(Boolean cool) {
        this.cool = cool;
    }

    public Boolean getCool() {
        return cool;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cool=" + cool +
                '}';
    }
}