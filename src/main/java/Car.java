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
}
