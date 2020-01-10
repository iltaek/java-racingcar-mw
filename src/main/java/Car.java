import java.util.Objects;

public class Car {
    private final String name;
    private int movingDistance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.movingDistance++;
    }

    public int getMovingDistance() {
        return this.movingDistance;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Car car = (Car) object;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
