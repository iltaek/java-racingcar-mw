import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Car implements Comparable<Car> {
    private final String name;
    private final List<Boolean> score = new LinkedList<>();
    public int totalScore = 0;
    private boolean isWinner = false;

    Car(String name) {
        this.name = name;
    }


    public void go() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            score.add(Boolean.TRUE);
            totalScore++;
        } else {
            score.add(Boolean.FALSE);
        }
    }

    public void setWinner() {
        this.isWinner = true;
    }

    public String getName() {
        return name;
    }

    public List<Boolean> getScore() {
        return score;
    }

    public boolean isWinner() {
        return isWinner;
    }

    @Override
    public int compareTo(Car car) {
        return this.totalScore - car.totalScore;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
