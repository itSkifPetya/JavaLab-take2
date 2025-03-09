package data.models.HumanBeingModel;

import java.time.LocalDate;

public class HumanBeing implements Comparable<HumanBeing> {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private Boolean hasToothpick; //Поле не может быть null
    private double impactSpeed;
    private String soundtrackName; //Поле не может быть null
    private long minutesOfWaiting;
    private WeaponType weaponType; //Поле не может быть null
    private Car car; //Поле может быть null
    private float absoluteParameter;

    public HumanBeing() {};

    public HumanBeing(
            String name,
            Coordinates coordinates,
            Boolean realHero,
            Boolean hasToothpick,
            String soundtrackName,
            WeaponType weaponType,
            Car car
    ) {

    }

    public HumanBeing(
            String name,
            Coordinates coordinates,
            Boolean realHero,
            Boolean hasToothpick,
            double impactSpeed,
            String soundtrackName,
            long minutesOfWaiting,
            WeaponType weaponType,
            Car car
    ) {

    }



    @Override
    public int compareTo(HumanBeing other) {
        return Double.compare(absoluteParameter, other.absoluteParameter);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(int x, double y) {
        this.coordinates = new Coordinates(x, y);
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public void setImpactSpeed(double impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public void setMinutesOfWaiting(long minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}