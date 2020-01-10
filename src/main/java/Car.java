import java.util.Random;

public class Car {
    private String name;
    private int location = 0;
    private static Random rnd = new Random();

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void goForward() {
        location++;
    }

    public void move() {
        if (decideMovement()) {
            goForward();
        }
    }

    private boolean decideMovement() {
        return rnd.nextInt(10) >= 4;
    }
}
