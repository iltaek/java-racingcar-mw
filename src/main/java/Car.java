import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Car {

    final String name;
    final List<Boolean> record;

    public Car(String name) {
        this.name = name;
        record = new LinkedList<>();
    }

    public int goEachRound() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        record.add(randomNumber >= 4);
        return randomNumber;
    }

    public List<Boolean> goEveryRound(int round) {
        for(int i =0; i<round ; i++){
            goEachRound();
        }
        return record;
    }
}
