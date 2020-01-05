import java.util.Random;

public class Car {

    final String name;
    public boolean record;

    public Car(String name) {
        this.name = name;
    }

    public int go() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        record = randomNumber >= 4;
        return randomNumber;
    }
}
