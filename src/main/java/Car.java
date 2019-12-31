import java.util.LinkedList;
import java.util.Queue;

public class Car {
    final String name;
    final Queue<Boolean> score;

    Car(String name){
        this.name = name;
        this.score = new LinkedList<>();
    }

}
