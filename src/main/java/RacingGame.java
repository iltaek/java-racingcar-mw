import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final Random random = new Random(); //주사위
    private final List<Car> cars;
    private final int round;

    public RacingGame(List<String> playerNames, int round) {
        cars = CarMaker.make(playerNames);
        this.round = round;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    public void start() {
        IntStream.range(0, round)
            .forEach(i -> startOneRound());
    }

    public void startOneRound() {
        cars.forEach(c -> c.goOneStep(random.nextInt(10)));
    }

    public List<Car> getWinner() {
        Car winner = Collections.max(cars);
        return cars.stream()
            .filter(c -> c.compareTo(winner)==0)
            .collect(Collectors.toList());
    }
}
