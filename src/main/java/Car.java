import java.util.ArrayList;
import java.util.List;

public class Car implements Comparable<Car>{

    private final String name;
    private final Integer criterion; //기준 점수 이상일 경우 전진, 미만이면 정지
    private final List<Integer> values; //라운드별 랜덤값
    private final List<Integer> scores; //라운드별 누적 점수

    public Car(String name, Integer criterion) {
        this.name = name;
        this.criterion = criterion;
        this.values = new ArrayList<>();
        this.scores = new ArrayList<>();
    }

    public void goOneStep(int randomValue) {
        values.add(randomValue);
        addScore(randomValue);
    }

    private void addScore(int randomNumber) {
        scores.add(getLastScore() + determineGoOrStop(randomNumber));
    }

    private Integer determineGoOrStop(int value) {
        return value >= criterion ? 1 : 0;
    }

    public Integer getLastScore() {
        return scores.isEmpty() ? 0 : scores.get(scores.size() - 1);
    }

    public List<Integer> getScores() {
        return scores;
    }

    public List<Integer> getValues() {
        return values;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return getLastScore() - car.getLastScore();
    }
}
