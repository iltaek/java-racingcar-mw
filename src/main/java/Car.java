import java.util.Random;

public class Car {
    String name;

    public boolean goOnce() {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(9);
        return randomNumber >= 4;
    }
}
