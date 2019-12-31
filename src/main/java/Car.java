import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Car {
    final String name;
    final Queue<Boolean> score;

    Car(String name){
        this.name = name;
        this.score = new LinkedList<>();
    }

    public void go(){
        Random random = new Random();
        if(random.nextInt(10) >= 4){
            score.add(Boolean.TRUE);
        }
        else{
            score.add(Boolean.FALSE);
        }
    }

}
