package data.models.HumanBeingModel;

/**
 * Модель класса Coordinates
 */
public class Coordinates {
    private int x;
    private double y;

    public Coordinates(int x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}