import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car implements Comparable<Car>{

    private final String name;
    private final Integer criterion; //기준 점수 이상일 경우 전진, 미만이면 정지
    private final List<Integer> scores; //라운드별 누적 점수

    public Car(String name, Integer criterion) {
        this.name = name;
        this.criterion = criterion;
        this.scores = new ArrayList<>();
    }

    void goOneStep(int randomValue) {
        addScore(randomValue);
    }

    private void addScore(int randomNumber) {
        scores.add(getLastScore() + determineGoOrStop(randomNumber));
    }

    private Integer determineGoOrStop(int value) {
        return value >= criterion ? 1 : 0;
    }

    Integer getLastScore() {
        return scores.isEmpty() ? 0 : scores.get(scores.size() - 1);
    }

    List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    String getName() {
        return name;
    }

    boolean isWinner(Car car){
        return compareTo(car) == 0;
    }

    @Override
    public int compareTo(Car car) {
        return getLastScore() - car.getLastScore();
    }

    @Override
    public String toString() {
        return this.name;
    }
}
